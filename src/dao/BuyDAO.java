package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import base.DBManager;
import beans.BuyData;
import beans.ShopCartData;

public class BuyDAO {
	//total price表示
	public static int getTotalItemPrice(List<ShopCartData> items) {
		int total = 0;
		for (ShopCartData item : items) {
			total += item.getPrice() * item.getCartitemNum();
		}
		return total;
	}
	//個数
	public static int getTotalItem(List<ShopCartData> items) {
		int totalItem = 0;
		for (ShopCartData item : items) {
			totalItem += 1 * item.getCartitemNum();
		}
		return totalItem;
	}

	//購入情報登録処理
	public static int insertBuy(BuyData bdb) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO t_buy(user_id,total_price,delivery_method_id,buy_date) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bdb.getUserId());
			st.setInt(2, bdb.getTotalPrice());
			st.setInt(3, bdb.getDeliveryMethodId());
			st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("inserting buy-datas has been completed");
			return autoIncKey;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	//セッションから指定データを取得（削除も一緒に行う
	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);

		return test;
	}

	//購入IDによる購入情報検索
	public static BuyData getDataByBuyId(int buyId) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement(
					"SELECT * FROM t_buy"
							+ " JOIN m_delivery_method"
							+ " ON t_buy.delivery_method_id = m_delivery_method.id"
							+ " WHERE t_buy.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			BuyData bdb = new BuyData();
			if (rs.next()) {
				bdb.setId(rs.getInt("id"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setBuyDate(rs.getTimestamp("buy_date"));
				bdb.setDeliveryMethodId(rs.getInt("delivery_method_id"));
				bdb.setUserId(rs.getInt("user_id"));
				bdb.setDeliveryMethodPrice(rs.getInt("price"));
				bdb.setDeliveryMethodName(rs.getString("name"));
			}
			return bdb;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	//UserIdから情報を参照
	public static List<BuyData> getBuyByUserId(int userid) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		List<BuyData>  buyList = new ArrayList<BuyData>();

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_buy"
							+ " JOIN m_delivery_method"
							+ " ON t_buy.delivery_method_id = m_delivery_method.id"
							+ " WHERE t_buy.user_id = ?"
							+ " ORDER BY buy_date DESC");
			st.setInt(1, userid);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int totalPrice = rs.getInt("total_price");
				Timestamp buyDate = rs.getTimestamp("buy_date");
				int delivertMethodId = rs.getInt("delivery_method_id");
				int userId = rs.getInt("user_id");
				int deliveryMethodPrice = rs.getInt("price");
				String deliveryMethodName = rs.getString("name");
				BuyData data = new BuyData(id, totalPrice, buyDate, delivertMethodId, userId, deliveryMethodPrice, deliveryMethodName );

				buyList.add(data);
				System.out.println(id);
			}
			System.out.println("searching BuyDataBeans by UserID has been completed");

			return buyList;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}

		}
	}

	//購入詳細 上部
	public static BuyData getBuyhistory(int Id) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_buy"
							+ " JOIN m_delivery_method"
							+ " ON t_buy.delivery_method_id = m_delivery_method.id"
							+ " WHERE t_buy.id = ?");
			st.setInt(1, Id);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int totalPrice = rs.getInt("total_price");
				Timestamp buyDate = rs.getTimestamp("buy_date");
				int deliveryMethodId = rs.getInt("delivery_method_id");
				int deliveryMethodPrice = rs.getInt("price");
				String deliveryMethodName = rs.getString("name");


				return new BuyData(id, totalPrice, buyDate, deliveryMethodId, deliveryMethodPrice, deliveryMethodName);

			}
			System.out.println("searching BuyDataBeans by UserID has been completed");

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}

		}
		return null;
	}

	//購入詳細 下部 購入詳細
	public static   List<BuyData> buyDetail(int buy_Id) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		List<BuyData>  buyHist = new ArrayList<BuyData>();

		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement(
					"SELECT * FROM t_buy_detail"
							+ " join  m_item"
							+ " on t_buy_detail.item_id = m_item.id"
							+ " join t_buy"
							+ " on t_buy_detail.buy_id = t_buy.id"
							+ " WHERE t_buy_detail.buy_id = ?");
			st.setInt(1, buy_Id);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int itemPrice = rs.getInt("price");
				int itemId = rs.getInt("item_id");
				String itemName = rs.getString("name");
				int buyId = rs.getInt("buy_id");
				String fileName = rs.getString("file_name");
				int cartItemNum = rs.getInt("cart_item_num");

				System.out.println(itemName);
				System.out.println(cartItemNum);
				BuyData data = new BuyData (id, itemPrice, itemId, itemName, buyId, fileName, cartItemNum);
				buyHist.add(data);
			}
			System.out.println("searching BuyDataBeans by UserID has been completed");

			return buyHist;

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}

		}
	}
}
