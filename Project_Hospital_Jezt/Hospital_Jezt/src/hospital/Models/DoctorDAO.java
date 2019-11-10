package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Category;
import hospital.Entities.Doctor;
import hospital.Interfaces.IDoctor;

public class DoctorDAO implements IDoctor{

	@Override
	public Doctor checkLoginDoctor(String doAcc, String doPass) {
		Connection conn = null;
		CallableStatement callst = null;
		Doctor doc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call checkLoginDoctor(?,?)}");
			callst.setString(1, doAcc);
			callst.setString(2, doPass);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				doc = new Doctor();
				doc.setDoId(rs.getInt("DoId"));
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
				doc.setDoFullName(rs.getString("DoFullName"));
				doc.setDoPhone(rs.getString("DoPhone"));
				doc.setDoAge(rs.getInt("DoAge"));
				doc.setDoEmail(rs.getString("DoEmail"));
				doc.setDoAvatar(rs.getString("DoAvatar"));
				doc.setDoAddress(rs.getString("DoAddress"));
				doc.setDoContent(rs.getString("DoContent"));
				doc.setDoStatus(rs.getBoolean("DoStatus"));
				doc.setCaId(rs.getInt("CaId"));
				doc.setRollId(rs.getInt("RollId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return doc;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		Connection conn = null;
		CallableStatement callst = null;
		List<Doctor> listDoc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getAllDoctor()}");
			
			ResultSet rs = callst.executeQuery();
			listDoc = new ArrayList<>();
			while(rs.next()) {
				Doctor doc = new Doctor();
				
				doc.setDoId(rs.getInt("DoId"));
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
				doc.setDoFullName(rs.getString("DoFullName"));
				doc.setDoPhone(rs.getString("DoPhone"));
				doc.setDoAge(rs.getInt("DoAge"));
				doc.setDoEmail(rs.getString("DoEmail"));
				doc.setDoAvatar(rs.getString("DoAvatar"));
				doc.setDoAddress(rs.getString("DoAddress"));
				doc.setDoContent(rs.getString("DoContent"));								
				doc.setCaId(rs.getInt("CaId"));
				doc.setRollId(rs.getInt("RollId"));
				listDoc.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return listDoc;
	}

	@Override
	public Doctor getDoctorById(int doId) {
		Connection conn = null;
		CallableStatement callst = null;
		Doctor doc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getDoctorById(?)}");
			callst.setInt(1, doId);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				doc = new Doctor();
				doc.setDoId(rs.getInt("doId"));
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
				doc.setDoFullName(rs.getString("DoFullName"));
				doc.setDoPhone(rs.getString("DoPhone"));
				doc.setDoAge(rs.getInt("DoAge"));
				doc.setDoEmail(rs.getString("DoEmail"));
				doc.setDoAvatar(rs.getString("DoAvatar"));
				doc.setDoAddress(rs.getString("DoAddress"));
				doc.setDoContent(rs.getString("DoContent"));
				doc.setDoStatus(rs.getBoolean("DoStatus"));
				doc.setCaId(rs.getInt("CaId"));
				doc.setRollId(rs.getInt("RollId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return doc;
	}

	@Override
	public boolean inserDoctor(Doctor doc) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call insertDoctor(?,?,?,?,?,?,?,?,?,?,?,?)}");
			callst.setString(1, doc.getDoAcc());
			callst.setString(2, doc.getDoPass());
			callst.setString(3, doc.getDoFullName());
			callst.setString(4, doc.getDoPhone());
			callst.setInt(5, doc.getDoAge());
			callst.setString(6, doc.getDoEmail());
			callst.setString(7, doc.getDoAvatar());
			callst.setString(8, doc.getDoAddress());
			callst.setString(9, doc.getDoContent());
			callst.setBoolean(10, doc.isDoStatus());
			callst.setInt(11, doc.getCaId());
			callst.setInt(12, doc.getRollId());
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
	public boolean updateDoctor(Doctor doc) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call updateDoctor(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			callst.setInt(1, doc.getDoId());
			callst.setString(2, doc.getDoAcc());
			callst.setString(3, doc.getDoPass());
			callst.setString(4, doc.getDoFullName());
			callst.setString(5, doc.getDoPhone());
			callst.setInt(6, doc.getDoAge());
			callst.setString(7, doc.getDoEmail());
			callst.setString(8, doc.getDoAvatar());
			callst.setString(9, doc.getDoAddress());
			callst.setString(10, doc.getDoContent());
			callst.setBoolean(11, doc.isDoStatus());
			callst.setInt(12, doc.getCaId());
			callst.setInt(13, doc.getRollId());
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
	public boolean deleteDoctor(int doId) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call deleteDoctor(?)}");
			callst.setInt(1, doId);
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
	public List<Doctor> searchDoctorByName(String doFullName) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Doctor> listDoc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call searchDoctorByName(?)}");
			callst.setString(1, doFullName);
			ResultSet rs = callst.executeQuery();
			listDoc = new ArrayList<>();
			while(rs.next()) {
				Doctor doc = new Doctor();
				doc.setDoId(rs.getInt("DoId"));
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
				doc.setDoFullName(rs.getString("DoFullName"));
				doc.setDoPhone(rs.getString("DoPhone"));
				doc.setDoAge(rs.getInt("DoAge"));
				doc.setDoEmail(rs.getString("DoEmail"));
				doc.setDoAvatar(rs.getString("DoAvatar"));
				doc.setDoAddress(rs.getString("DoAddress"));
				doc.setDoContent(rs.getString("DoContent"));
				doc.setDoStatus(rs.getBoolean("DoStatus"));
				doc.setCaId(rs.getInt("CaId"));
				doc.setRollId(rs.getInt("RollId"));
				listDoc.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return listDoc;
	}

	@Override
	public Doctor checkAccDoctor(String doAcc) {
		Connection conn = null;
		CallableStatement callst = null;
		Doctor doc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call checkAccDoctor(?)}");
			callst.setString(1, doAcc);
			ResultSet rs = callst.executeQuery();
			
			while(rs.next()) {
				doc = new Doctor();
				doc.setDoId(rs.getInt("DoId"));
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
				doc.setDoFullName(rs.getString("DoFullName"));
				doc.setDoPhone(rs.getString("DoPhone"));
				doc.setDoAge(rs.getInt("DoAge"));
				doc.setDoEmail(rs.getString("DoEmail"));
				doc.setDoAvatar(rs.getString("DoAvatar"));
				doc.setDoAddress(rs.getString("DoAddress"));
				doc.setDoContent(rs.getString("DoContent"));
				doc.setDoStatus(rs.getBoolean("DoStatus"));
				doc.setCaId(rs.getInt("CaId"));
				doc.setRollId(rs.getInt("RollId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return doc;
	}

	@Override
	public int countAllDoctor() {
		Connection conn = null;
		CallableStatement callst = null;
		int countAllDoctor = 0 ;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call countAllDoctor()}");
			ResultSet rs = callst.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return countAllDoctor;
	}

	@Override
	public List<Doctor> selectTop8Doctor() {
		Connection conn = null;
		CallableStatement callst = null;
		List<Doctor> listDoc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call selectTop8Doctor()}");
			
			ResultSet rs = callst.executeQuery();
			listDoc = new ArrayList<>();
			while(rs.next()) {
				Doctor doc = new Doctor();
				
				doc.setDoId(rs.getInt("DoId"));
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
				doc.setDoFullName(rs.getString("DoFullName"));
				doc.setDoPhone(rs.getString("DoPhone"));
				doc.setDoAge(rs.getInt("DoAge"));
				doc.setDoEmail(rs.getString("DoEmail"));
				doc.setDoAvatar(rs.getString("DoAvatar"));
				doc.setDoAddress(rs.getString("DoAddress"));
				doc.setDoContent(rs.getString("DoContent"));								
				doc.setCaId(rs.getInt("CaId"));
				doc.setRollId(rs.getInt("RollId"));
				listDoc.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return listDoc;
	}
	

}
