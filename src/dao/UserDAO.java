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
import beans.UserData;

public class UserDAO {
	//ログイン用
	public UserData findByLoginInfo (String loginId, String password) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "select * from t_user where login_id = ? and password = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,  loginId);
			pStmt.setString(2,  password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			int userIdData = rs.getInt("id");
			return new UserData(userIdData, loginIdData, nameData);
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
	}
	//新規作成用
	public UserData Make_New_User(String name, String loginid, String password,
			String email, int postcode, String metropolis, String districts,
			String addres) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "insert into t_user(name, login_id, password, e_mail, post,"
					+ "metropolis, districts,  addres, create_date, update_date)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, now(), now());";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, loginid);
			pStmt.setString(3, password);
			pStmt.setString(4, email);
			pStmt.setInt(5, postcode);
			pStmt.setString(6, metropolis);
			pStmt.setString(7, districts);
			pStmt.setString(8, addres);

			int result = pStmt.executeUpdate();
			System.out.println(result);

			pStmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//データベース切断
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

	//ユーザー表示(一覧)
	public List<UserData> findALLUser(){
		Connection conn = null;
		List<UserData> userList = new ArrayList<UserData>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM t_user where id not in(1)";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Timestamp createDate = rs.getTimestamp("create_date");

				UserData userdata = new UserData(id, loginId, name, createDate);

				userList.add(userdata);
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
		return userList;
	}

	//ユーザー詳細など
	public UserData SelectUser(int id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "select * from t_user where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int Id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String email = rs.getString("e_mail");
				int post = rs.getInt("post");
				String metropolis = rs.getString("metropolis");
				String districts = rs.getString("districts");
				String addres = rs.getString("addres");
				Timestamp createdate = rs.getTimestamp("create_date");
				Timestamp updatedate = rs.getTimestamp("update_date");

				return new UserData(Id, loginId, name, email, post, metropolis, districts, addres, createdate, updatedate);
			}
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

	//ユーザー削除
	public UserData UserDelete(int id) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "delete from t_user where id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);

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

	//ユーザー検索機能
	public List<UserData> UserSearch(String loginIdP, String nameP) {
		Connection conn = null;
		List<UserData> userList = new ArrayList<UserData>();

		try {
			conn = DBManager.getConnection();

			String sql = "select * from t_user where id not in(1)";

			if(!loginIdP.equals("")) {
				sql += " AND login_id = '" + loginIdP + "'";
			}

			if(!nameP.equals("")) {
				sql += " AND name LIKE '%" + nameP + "%'";
			}
			System.out.println(sql);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int Id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Timestamp createDate = rs.getTimestamp("create_date");

				UserData userdata = new UserData(Id, loginId, name, createDate);

				userList.add(userdata);
			    }
			}catch (SQLException e) {
				e.printStackTrace();
				return  null;
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
		    return userList;
		}
	//ユーザーIDからユーザー情報を取得する
	public static UserData getUserByUserId(int userId) throws SQLException {
		UserData udb = new UserData();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT id,name, login_id, addres FROM t_user WHERE id =" + userId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				udb.setId(rs.getInt("id"));
				udb.setName(rs.getString("name"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setAddres(rs.getString("addres"));
			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

		System.out.println("searching UserDataBeans by userId has been completed");
		return udb;
	}
	//ユーザーアップデート ver Normal
	public  UserData NewUpdate(int id, String name, String loginid, String password,
			String email, int postcode, String metropolis, String districts,
			String addres) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "update t_user set name = ?, login_id = ?, password = ?, e_mail = ?, post = ?,"
						+ "metropolis = ?, districts = ?,  addres = ?, update_date = now() where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setString(2,  loginid);
			pStmt.setString(3,  password);
			pStmt.setString(4,  email);
			pStmt.setInt(5,  postcode);
			pStmt.setString(6, metropolis);
			pStmt.setString(7, districts);
			pStmt.setString(8,  addres);
			pStmt.setInt(9, id);

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

	//ユーザーアップデート verPasswordなし
	public  UserData NewUpdateNopas(int id, String name, String loginid,
			String email, int postcode, String metropolis, String districts,
			String addres) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "update t_user set name = ?, login_id = ?, password = ?, e_mail = ?, post = ?,"
						+ "metropolis = ?, districts = ?,  addres = ?, update_date = now() where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2,  loginid);
			pStmt.setString(3,  email);
			pStmt.setInt(4,  postcode);
			pStmt.setString(5, metropolis);
			pStmt.setString(6, districts);
			pStmt.setString(7,  addres);
			pStmt.setInt(8, id);

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
	//ユーザーアップデート ver email
	public  UserData NewUpdateNoemail(int id, String name, String loginid, String password,
			int postcode, String metropolis, String districts,
			String addres) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "update t_user set name = ?, login_id = ?, password = ?, post = ?,"
						+ "metropolis = ?, districts = ?,  addres = ?, update_date = now() where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setString(2,  loginid);
			pStmt.setString(3,  password);
			pStmt.setInt(4,  postcode);
			pStmt.setString(5, metropolis);
			pStmt.setString(6, districts);
			pStmt.setString(7,  addres);
			pStmt.setInt(8, id);

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
	//ユーザーアップデート ver email&password
	public  UserData NewUpdateNoemailPass(int id, String name, String loginid,
			int postcode, String metropolis, String districts,
			String addres) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "update t_user set name = ?, login_id = ?, post = ?,"
						+ "metropolis = ?, districts = ?,  addres = ?, update_date = now() where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, name);
			pStmt.setString(2,  loginid);
			pStmt.setInt(3,  postcode);
			pStmt.setString(4, metropolis);
			pStmt.setString(5, districts);
			pStmt.setString(6,  addres);
			pStmt.setInt(7, id);

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
