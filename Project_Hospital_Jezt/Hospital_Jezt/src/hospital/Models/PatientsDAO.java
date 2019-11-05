package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Patients;
import hospital.Interfaces.IPatients;

public class PatientsDAO implements IPatients{

	@Override
	public Patients checkLoginPatients(String paAcc, String paPass) {
		Connection conn = null;
		CallableStatement callst = null;
		Patients pat = null;
		try {
			conn = ConnectionDB.openConection();
			callst  = conn.prepareCall("{call checkLoginPatients(?,?)}");
			callst.setString(1, paAcc);
			callst.setString(2, paPass);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				pat = new Patients();
				pat.setPaId(rs.getInt("PaId"));
				pat.setPaAcc(rs.getString("PaAcc"));
				pat.setPaPass(rs.getString("PaPass"));
				pat.setPaFullName(rs.getString("PaFullName"));
				pat.setPaPhone(rs.getString("PaPhone"));
				pat.setPaAge(rs.getInt("PaAge"));
				pat.setPaEmail(rs.getString("PaEmail"));
				pat.setPaAvatar(rs.getString("PaAvatar"));
				pat.setPaAddress(rs.getString("PaAddress"));
				pat.setPaContent(rs.getString("PaContent"));
				pat.setPaStatus(rs.getBoolean("PaStatus"));
				pat.setDoId(rs.getInt("DoId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return pat;
	}

	@Override
	public List<Patients> getAllPatientsDoId(int doId) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Patients> listPat = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getAllPatientsDoId(?)}");
			callst.setInt(1, doId);
			ResultSet rs = callst.executeQuery();
			listPat = new ArrayList<>();
			while(rs.next()) {
				Patients pat = new Patients();
				pat.setPaId(rs.getInt("PaId"));
				pat.setPaAcc(rs.getString("PaAcc"));
				pat.setPaPass(rs.getString("PaPass"));
				pat.setPaFullName(rs.getString("PaFullName"));
				pat.setPaPhone(rs.getString("PaPhone"));
				pat.setPaAge(rs.getInt("PaAge"));
				pat.setPaEmail(rs.getString("PaEmail"));
				pat.setPaAvatar(rs.getString("PaAvatar"));
				pat.setPaAddress(rs.getString("PaAddress"));
				pat.setPaContent(rs.getString("PaContent"));
				pat.setPaStatus(rs.getBoolean("PaStatus"));
				pat.setDoId(rs.getInt("DoId"));
				listPat.add(pat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPat;
	}

	@Override
	public Patients getPatientsById(int paId) {
		Connection conn = null;
		CallableStatement callst = null;
		Patients pat = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getPatientsById(?)}");
			callst.setInt(1, paId);
			ResultSet rs = callst.executeQuery();
			
			if(rs.next()) {
				pat = new Patients();
				pat.setPaId(rs.getInt("PaId"));
				pat.setPaAcc(rs.getString("PaAcc"));
				pat.setPaPass(rs.getString("PaPass"));
				pat.setPaFullName(rs.getString("PaFullName"));
				pat.setPaPhone(rs.getString("PaPhone"));
				pat.setPaAge(rs.getInt("PaAge"));
				pat.setPaEmail(rs.getString("PaEmail"));
				pat.setPaAvatar(rs.getString("PaAvatar"));
				pat.setPaAddress(rs.getString("PaAddress"));
				pat.setPaContent(rs.getString("PaContent"));
				pat.setPaStatus(rs.getBoolean("PaStatus"));
				pat.setDoId(rs.getInt("DoId"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pat;
	}

	@Override
	public boolean insertPatients(Patients pat) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call insertPatients(?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = callst.executeQuery();
			callst.setString(1, pat.getPaAcc());
			callst.setString(2, pat.getPaPass());
			callst.setString(3, pat.getPaFullName());
			callst.setString(4, pat.getPaPhone());
			callst.setInt(5, pat.getPaAge());
			callst.setString(6, pat.getPaEmail());
			callst.setString(7, pat.getPaAvatar());
			callst.setString(8, pat.getPaAddress());
			callst.setString(9, pat.getPaContent());
			callst.setBoolean(10, pat.isPaStatus());
			callst.setInt(11, pat.getDoId());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public boolean updatePatients(Patients pat) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call updatePatients(?,?,?,?,?,?,?,?,?,?,?,?)}");
			ResultSet rs = callst.executeQuery();
			callst.setInt(1, pat.getPaId());
			callst.setString(2, pat.getPaAcc());
			callst.setString(3, pat.getPaPass());
			callst.setString(4, pat.getPaFullName());
			callst.setString(5, pat.getPaPhone());
			callst.setInt(6, pat.getPaAge());
			callst.setString(7, pat.getPaEmail());
			callst.setString(8, pat.getPaAvatar());
			callst.setString(9, pat.getPaAddress());
			callst.setString(10, pat.getPaContent());
			callst.setBoolean(11, pat.isPaStatus());
			callst.setInt(12, pat.getDoId());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public boolean deletePatients(int paId) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call deletePatients(?)}");
			ResultSet rs = callst.executeQuery();
			callst.setInt(1, paId);		
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public List<Patients> searchPatientsByName(String paFullName) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Patients> listPat = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call searchPatientsByName(?)}");			
			callst.setString(1, paFullName);
			ResultSet rs = callst.executeQuery();
			listPat = new ArrayList<>();
			while(rs.next()) {
				Patients pat = new Patients();
				pat.setPaId(rs.getInt("PaId"));
				pat.setPaAcc(rs.getString("PaAcc"));
				pat.setPaPass(rs.getString("PaPass"));
				pat.setPaFullName(rs.getString("PaFullName"));
				pat.setPaPhone(rs.getString("PaPhone"));
				pat.setPaAge(rs.getInt("PaAge"));
				pat.setPaEmail(rs.getString("PaEmail"));
				pat.setPaAvatar(rs.getString("PaAvatar"));
				pat.setPaAddress(rs.getString("PaAddress"));
				pat.setPaContent(rs.getString("PaContent"));
				pat.setPaStatus(rs.getBoolean("PaStatus"));
				pat.setDoId(rs.getInt("DoId"));
				listPat.add(pat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPat;
	}

	@Override
	public List<Patients> getAllPatients() {
		Connection conn = null;
		CallableStatement callst = null;
		List<Patients> listPat = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getAllPatients()}");
			ResultSet rs = callst.executeQuery();
			listPat = new ArrayList<>();
			while(rs.next()) {
				Patients pat = new Patients();
				pat.setPaId(rs.getInt("PaId"));
				pat.setPaAcc(rs.getString("PaAcc"));
				pat.setPaPass(rs.getString("PaPass"));
				pat.setPaFullName(rs.getString("PaFullName"));
				pat.setPaPhone(rs.getString("PaPhone"));
				pat.setPaAge(rs.getInt("PaAge"));
				pat.setPaEmail(rs.getString("PaEmail"));
				pat.setPaAvatar(rs.getString("PaAvatar"));
				pat.setPaAddress(rs.getString("PaAddress"));
				pat.setPaContent(rs.getString("PaContent"));
				pat.setPaStatus(rs.getBoolean("PaStatus"));
				pat.setDoId(rs.getInt("DoId"));
				listPat.add(pat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPat;
	}

}
