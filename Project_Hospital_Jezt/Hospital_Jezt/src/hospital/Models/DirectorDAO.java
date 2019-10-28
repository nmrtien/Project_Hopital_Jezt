package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Director;
import hospital.Interfaces.IDirector;

public class DirectorDAO implements IDirector{

	@Override
	public Director checkDirector(String diAcc, String diPass) {
		Connection conn = null;
		CallableStatement callst = null;
		Director dir = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call checkDirector(?,?)}");
			callst.setString(1, diAcc);
			callst.setString(2, diPass);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				dir = new Director();
				dir.setDiAcc(rs.getString("DiAcc"));
				dir.setDiPass(rs.getString("DiPass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dir;
	}

	@Override
	public Director getDirectorById(int diId) {
		Connection conn = null;
		CallableStatement callst = null;
		Director dir = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getDirectorById(?)}");
			callst.setInt(1, diId);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				dir = new Director();
				dir.setDiId(rs.getInt("DiId"));
				dir.setDiAcc(rs.getString("DiAcc"));
				dir.setDiPass(rs.getString("DiPass"));
				dir.setDiFullName(rs.getString("DiFullName"));
				dir.setDiPhone(rs.getString("DiPhone"));
				dir.setDiContent(rs.getString("DiContent"));
				dir.setDiStatus(rs.getBoolean("DiStatus"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dir;
	}
	
	@Override
	public Director getDirector() {
		Connection conn = null;
		CallableStatement callst = null;
		Director dir = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getDirector()}");
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				dir = new Director();
				dir.setDiId(rs.getInt("DiId"));
				dir.setDiAcc(rs.getString("DiAcc"));
				dir.setDiPass(rs.getString("DiPass"));
				dir.setDiFullName(rs.getString("DiFullName"));
				dir.setDiPhone(rs.getString("DiPhone"));
				dir.setDiContent(rs.getString("DiContent"));
				dir.setDiStatus(rs.getBoolean("DiStatus"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dir;
	}
	
	@Override
	public boolean updateDirector(Director dir) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call updateDirector(?,?,?,?,?,?,?)}");
			callst.setInt(1, dir.getDiId());
			callst.setString(2, dir.getDiAcc());
			callst.setString(3, dir.getDiPass());
			callst.setString(4, dir.getDiFullName());
			callst.setString(5, dir.getDiPhone());
			callst.setString(6, dir.getDiContent());
			callst.setBoolean(7, dir.isDiStatus());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
}
