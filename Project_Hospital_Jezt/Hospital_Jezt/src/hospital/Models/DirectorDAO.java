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
	
	
	
}
