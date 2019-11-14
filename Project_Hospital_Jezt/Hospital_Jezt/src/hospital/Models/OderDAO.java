package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Oder;
import hospital.Interfaces.IOder;

public class OderDAO implements IOder{

	@Override
	public boolean inserOder(Oder od) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call insertOder(?,?,?)}");
			callst.setString(1, od.getOdName());
			callst.setString(2, od.getOdAddress());
			callst.setString(3, od.getOdPhone());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return check;
	}

	@Override
	public List<Oder> getAllOder() {
		Connection conn = null;
		CallableStatement callst = null;
		List<Oder> listOd = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getAllOder()}");
			ResultSet rs = callst.executeQuery();
			listOd = new ArrayList<>();
			while(rs.next()) {
				Oder od = new Oder();
				od.setOdId(rs.getInt("OdId"));
				od.setOdName(rs.getString("OdName"));
				od.setOdAddress(rs.getString("OdAddress"));
				od.setOdPhone(rs.getString("OdPhone"));
				listOd.add(od);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return listOd;
	}

	@Override
	public int getOderId() {
		Connection conn = null;
		CallableStatement callst = null;
		int jezt = 0;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getOderId()}");
			ResultSet rs = callst.executeQuery();
			rs.next();
			jezt = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return jezt;
	}

	@Override
	public List<Oder> searchOderById(int odId) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Oder> listOd = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call searchOderById(?)}");
			callst.setInt(1, odId);
			ResultSet rs = callst.executeQuery();
			listOd = new ArrayList<>();
			while(rs.next()) {
				Oder od = new Oder();
				od.setOdId(rs.getInt("OdId"));
				od.setOdName(rs.getString("OdName"));
				od.setOdAddress(rs.getString("OdAddress"));
				od.setOdPhone(rs.getString("OdPhone"));
				listOd.add(od);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return listOd;
	}

	@Override
	public boolean deleteOder(int odId) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call deleteOder(?)}");
			callst.setInt(1, odId);
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return check;
	}

}
