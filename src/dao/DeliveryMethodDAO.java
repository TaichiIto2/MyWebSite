package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.DeliveryMethodData;

public class DeliveryMethodDAO {

	// DBに登録されている配送方法を取得
	public static ArrayList<DeliveryMethodData> getDeliveryMethod() throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement("select * from m_delivery_method");

			ResultSet rs = st.executeQuery();

			ArrayList<DeliveryMethodData> deliveryMethodDataList = new ArrayList<DeliveryMethodData>();
			while (rs.next()) {
				DeliveryMethodData dmdb = new DeliveryMethodData();
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
				deliveryMethodDataList.add(dmdb);
			}
			return deliveryMethodDataList;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	public static DeliveryMethodData getDeliveryaByID(int DeliveryMethodId) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement("select * from m_delivery_method WHERE id = ?");
			st.setInt(1, DeliveryMethodId);

			ResultSet rs = st.executeQuery();

			DeliveryMethodData dmdb = new DeliveryMethodData();
			if (rs.next()) {
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
			}
			return dmdb;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
