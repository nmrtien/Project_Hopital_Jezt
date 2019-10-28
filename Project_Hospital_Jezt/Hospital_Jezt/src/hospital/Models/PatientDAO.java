package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Patient;
import hospital.Interfaces.IPatient;

public class PatientDAO implements IPatient{

	@Override
	public Patient checkPatient(String paAcc, String paPass) {
		Connection conn = null;
		CallableStatement callst = null;
		Patient pat = null;
		try {
			conn = ConnectionDB.openConection();
			callst  = conn.prepareCall("{call checkPatient(?,?)}");
			callst.setString(1, paAcc);
			callst.setString(2, paPass);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				pat = new Patient();
				pat.setPaAcc(rs.getString("PaAcc"));
				pat.setPaPass(rs.getString("PaPass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return pat;
	}

	@Override
	public List<Patient> getAllPatient(int doId) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Patient> listPat = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getAllPatient()}");
			ResultSet rs = callst.executeQuery();
			listPat = new ArrayList<>();
			while(rs.next()) {
				Patient pat = new Patient();
				pat.setPaId(rs.getInt("PaId"));
				pat.setPaAcc(rs.getString("PaAcc"));
				pat.setPaPass(rs.getString("PaPass"));
				pat.setPaFullName(rs.getString("PaFullName"));
				pat.setPaPhone(rs.getString("PaPhone"));
				pat.setPaAge(rs.getInt("PaAge"));
				pat.setPaEmail(rs.getString("PaEmail"));
				pat.setPaAvatar(rs.getString("PaAvatar"));
				pat.setPaAdress(rs.getString("PaAdress"));
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
	public Patient getPatientById(int paId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertPatient(Patient pat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePatient(Patient pat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatient(int paId) {
		// TODO Auto-generated method stub
		return false;
	}

}
