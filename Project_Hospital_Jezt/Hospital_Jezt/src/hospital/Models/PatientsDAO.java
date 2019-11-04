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
	public List<Patients> getAllPatients(int doId) {
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

	@Override
	public Patients getPatientsById(int paId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertPatients(Patients pat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePatients(Patients pat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatients(int paId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Patients> searchPatientsByName(String paFullName) {
		// TODO Auto-generated method stub
		return null;
	}

}
