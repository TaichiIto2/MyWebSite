package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.BuyDetailData;
import beans.ItemData;

public class ItemDAO {
	//HomeShopの一覧
	public List<ItemData> findALLItem(int limit){
		Connection conn = null;
		List<ItemData> itemList = new ArrayList<ItemData>();

		try {
			conn = DBManager.getConnection();

			String sql = "select * from m_item order by rand() limit ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,  limit);


			System.out.println(pStmt);

			ResultSet rs = pStmt.executeQuery();


			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String fileName = rs.getString("file_name");
				Timestamp create_date = rs.getTimestamp("create_date");
				int stock = rs.getInt("stock");

				ItemData itemdata = new ItemData(id, name, detail, price, fileName, create_date, stock);

				itemList.add(itemdata);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return itemList;
	}

	//mastaの一覧
	public List<ItemData> findALLMasta(){
		Connection conn = null;
		List<ItemData> mastaList = new ArrayList<ItemData>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM m_item";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String fileName = rs.getString("file_name");
				Timestamp create_date = rs.getTimestamp("create_date");
				int stock = rs.getInt("stock");

				ItemData itemdata = new ItemData(id, name, detail, price, fileName, create_date, stock);

				mastaList.add(itemdata);
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
		return mastaList;
	}


	//itemIdで検索
	public ItemData ChoseItem (int id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "select * from m_item"
					+ " where id = ?";

			System.out.println(sql);

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,  id);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int Id = rs.getInt("m_item.id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String fileName = rs.getString("file_name");
				Timestamp createdate = rs.getTimestamp("create_date");
				int stock = rs.getInt("stock");

				return new ItemData(Id, name, detail, price, fileName, createdate, stock);
			}
			//Beansと変数名を合わせる
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
			}try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//data型から検索
	public static ItemData datatoItem (BuyDetailData id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "select * from m_item"
					+ " where id = ?";

			System.out.println(sql);

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,  id.getItemId());
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int Id = rs.getInt("m_item.id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String fileName = rs.getString("file_name");
				Timestamp createdate = rs.getTimestamp("create_date");
				int stock = rs.getInt("stock");

				return new ItemData(Id, name, detail, price, fileName, createdate, stock);
			}
			//Beansと変数名を合わせる
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
			}try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//item削除
	public ItemData ItemDelete(int id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "delete from m_item where id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,  id);

			int result = pStmt.executeUpdate();
			System.out.println(result);
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
	//item新規作成
	public ItemData New_Make_Item (String name, String detail,
			int price, String filename, int stock) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "insert into m_item(name, detail, price, file_name, stock, create_date)"
					+ " values(?, ?, ?, ?, ?, now())";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,  name);
			pStmt.setString(2,  detail);
			pStmt.setInt(3,  price);
			pStmt.setString(4,  filename);
			pStmt.setInt(5, stock);

			int result = pStmt.executeUpdate();
			System.out.println(result);

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

	//item検索
	public List<ItemData> ItemSearch(String nameP, String sprice, String eprice,  String screatedate, String ecreatedate) {
		Connection conn = null;
		List<ItemData> itemList = new ArrayList<ItemData>();

		try {
			conn = DBManager.getConnection();

			String sql = "select * from m_item where";

			if (!nameP.equals("")) {
				sql += " name like '%" + nameP + "%'";
			}

			if (!sprice.equals("")) {
				sql += " price >= '" + sprice + "'";
			}

			if (!eprice.equals("")) {
				sql +=" price <= '" + eprice + "'";
			}

			if (!screatedate.equals("")) {
				sql +=" create_date >= '" + screatedate + "'";
			}

			if (!ecreatedate.equals("")) {
				sql +=" create_date <= '" + ecreatedate + "'";
			}
			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Timestamp createdate = rs.getTimestamp("create_date");
				int stock = rs.getInt("stock");

				ItemData item = new ItemData(id, name, price, createdate, stock);

				itemList.add(item);
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
		return itemList;
	}

	//商品検索（ユーザー画面用)
	public List<ItemData> ItemFind(String search_word, int pageNum, int pageMax) {
		Connection conn = null;
		PreparedStatement st = null;
		List<ItemData> itemList = new ArrayList<ItemData>();
		try {
			int startiItemNum = (pageNum - 1) * pageMax;
			conn = DBManager.getConnection();

			if (search_word.length() == 0) {
				// 全検索
				st = conn.prepareStatement("SELECT * FROM m_item ORDER BY id ASC LIMIT ?,? ");
				st.setInt(1, startiItemNum);
				st.setInt(2, pageMax);
			} else {
				// 商品名検索
				st = conn.prepareStatement("SELECT * FROM m_item WHERE name LIKE ?  ORDER BY id ASC LIMIT ?,? ");
				st.setString(1, "%" + search_word + "%");
				st.setInt(2, startiItemNum);
				st.setInt(3, pageMax);
			}

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				ItemData item = new ItemData();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getInt("price"));
				item.setFileName(rs.getString("file_name"));
				itemList.add(item);
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
		return itemList;
	}

	//商品総数を所得
	public static double getItemCount(String search_word) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("select count(*) as cnt from m_item where name like ?");
			st.setString(1, "%" + search_word + "%");
			ResultSet rs = st.executeQuery();
			double coung = 0.0;
			while (rs.next()) {
				coung = Double.parseDouble(rs.getString("cnt"));
			}
			return coung;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	//アイテム アップデート
	public ItemData UpdateItem (int id, String name, int price, String detail, String fileName, int stock) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "update m_item set name = ?, detail = ?, price = ?, file_name = ?, stock = ? where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2,  detail);
			pStmt.setInt(3,  price);
			pStmt.setString(4,  fileName);
			pStmt.setInt(5, stock);
			pStmt.setInt(6, id);

			int result = pStmt.executeUpdate();
			System.out.println(result);

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
