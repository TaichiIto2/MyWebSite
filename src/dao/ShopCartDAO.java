package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ShopCartData;

public class ShopCartDAO {
	//ショッピングカート一覧
	public List<ShopCartData> findCartList(int id){
		Connection conn = null;
		List<ShopCartData> cartList = new ArrayList<ShopCartData>();
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement(
					"select * from t_user_cart"
					+ " join m_item"
					+ " on t_user_cart.item_id = m_item.id"
					+ " join t_user"
					+ " on t_user_cart.user_id = t_user.id"
					+ " where t_user_cart.user_id = ?");
			st.setInt(1,  id);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int Id = rs.getInt("id");
				int itemId = rs.getInt("item_id");
				int price = rs.getInt("price");
				String name = rs.getString("name");
				String fileName = rs.getString("file_name");
				int cartitemNum = rs.getInt("cart_item_num");

				ShopCartData cartdata = new ShopCartData(Id, itemId, price, name, fileName, cartitemNum);

				cartList.add(cartdata);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return cartList;
	}

	//cart作成
	public void CreateCart (int user_id, int item_id, int cart_item_num) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("insert into t_user_cart(user_id, item_id, cart_item_num) values(?, ?, ?) ");
			st.setInt(1, user_id);
			st.setInt(2, item_id);
			st.setInt(3, cart_item_num);
			st.executeUpdate();

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	//cart アイテム削除
	public ShopCartData CartItemDelete(int cartId) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "delete from t_user_cart where id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,  cartId);

			int result = pStmt.executeUpdate();
			pStmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	//カート内アイテム削除
	public List<ShopCartData> deleteInCartItem(int id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "delete from t_user_cart where user_id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,  id);

			int reault = pStmt.executeUpdate();
			pStmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}