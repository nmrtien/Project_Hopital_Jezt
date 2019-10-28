package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Doctor;
import hospital.Interfaces.IDoctor;

public class DoctorDAO implements IDoctor{

	@Override
	public Doctor checkDoctor(String doAcc, String doPass) {
		Connection conn = null;
		CallableStatement callst = null;
		Doctor doc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call checkDoctor(?,?)}");
			callst.setString(1, doAcc);
			callst.setString(2, doPass);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				doc = new Doctor();
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
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
				doc.setDoAcc(rs.getString("DoAcc"));
				doc.setDoPass(rs.getString("DoPass"));
				doc.setDoFullName(rs.getString("DoFullName"));
				doc.setDoPhone(rs.getString("DoPhone"));
				doc.setDoAge(rs.getInt("DoAge"));
				doc.setDoEmail(rs.getString("DoEmail"));
				doc.setDoAvatar(rs.getString("DoAvatar"));
				doc.setDoAdress(rs.getString("DoAdress"));
				doc.setDoContent(rs.getString("DoContent"));
				doc.setDoStatus(rs.getBoolean("DoStatus"));
				doc.setCaId(rs.getInt("CaId"));
				listDoc.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return listDoc;
	}

	@Override
	public Doctor getDoctorById(int doId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inserDoctor(Doctor doc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDoctor(Doctor doc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDoctor(int doId) {
		// TODO Auto-generated method stub
		return false;
	}

}
