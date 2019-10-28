package hospital.Connections;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hospital.Commons.CommonData;;

public class ConnectionDB {

	public static Connection openConection() {
		Connection conn = null;
		try {
			Class.forName(CommonData.DRIVER);
			conn = DriverManager.getConnection(CommonData.URL, CommonData.USER, CommonData.PASS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(Connection conn, CallableStatement callst) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(callst!=null) {
			try {
				callst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
