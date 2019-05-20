package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDetailData;
import beans.ItemData;

public class BuyDetailDAO {
	//購入詳細登録処理
	public static void insertBuyDetail(BuyDetailData bddb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_buy_detail(buy_id, item_id, cart_item_num) VALUES(?, ?, ?)");
			st.setInt(1, bddb.getBuyId());
			st.setInt(2, bddb.getItemId());
			st.setInt(3, bddb.getCart_item_num());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	//購入IDによる購入詳細情報検索
	public static ArrayList<ItemData> getItemListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT m_item.id,"
					+ " m_item.name,"
					+ " m_item.price"
					+ " FROM t_buy_detail"
					+ " JOIN m_item"
					+ " ON t_buy_detail.item_id = m_item.id"
					+ " WHERE t_buy_detail.buy_id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<ItemData> buyDetailItemList = new ArrayList<ItemData>();

			while (rs.next()) {
				ItemData idb = new ItemData();
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setPrice(rs.getInt("price"));


				buyDetailItemList.add(idb);
			}

			System.out.println("searching ItemDataBeansList by BuyID has been completed");
			return buyDetailItemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	//在庫を減らす処理
	public static ItemData decreaseItem (BuyDetailData id, ItemData item) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();

			int stock = item.getStock();
			int purchase = id.getCart_item_num();

			stock -= purchase;

			st = conn.prepareStatement( "update m_item set stock = ? where m_item.id = ?");
			st.setInt(1, stock);
			st.setInt(2, id.getItemId());
			st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
