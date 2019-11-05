package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Medicine;
import hospital.Interfaces.IMedicine;

public class MedicineDAO implements IMedicine{

	@Override
	public List<Medicine> getAllMedicine() {
		Connection conn = null;
		CallableStatement callst = null;
		List<Medicine> listMed = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getAllMedicine()}");
			ResultSet rs = callst.executeQuery();
			listMed = new ArrayList<>();
			while(rs.next()) {
				Medicine med = new Medicine();
				med.setMeId(rs.getInt("MeId"));
				med.setMeName(rs.getString("MeName"));
				med.setMePrice(rs.getFloat("MePrice"));
				med.setMeProducer(rs.getString("MeProducer"));
				med.setMeTitle(rs.getString("MeTitle"));
				med.setMeContent(rs.getString("MeContent"));
				med.setMeDateOfManufacture(rs.getDate("MeDateOfManufacture"));
				med.setMeExpirationDate(rs.getDate("MeExpirationDate"));
				med.setMeImage(rs.getString("MeImage"));
				med.setMeStatus(rs.getBoolean("MeStatus"));
				med.setCaId(rs.getInt("CaId"));
				listMed.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMed;
	}

	@Override
	public Medicine getMedicineById(int meId) {
		Connection conn = null;
		CallableStatement callst = null;
		Medicine med = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getMedicineById(?)}");
			callst.setInt(1, meId);
			ResultSet rs = callst.executeQuery();			
			if(rs.next()) {
				med = new Medicine();
				med.setMeId(rs.getInt("MeId"));
				med.setMeName(rs.getString("MeName"));
				med.setMePrice(rs.getFloat("MePrice"));
				med.setMeProducer(rs.getString("MeProducer"));
				med.setMeTitle(rs.getString("MeTitle"));
				med.setMeContent(rs.getString("MeContent"));
				med.setMeDateOfManufacture(rs.getDate("MeDateOfManufacture"));
				med.setMeExpirationDate(rs.getDate("MeExpirationDate"));
				med.setMeImage(rs.getString("MeImage"));
				med.setMeStatus(rs.getBoolean("MeStatus"));
				med.setCaId(rs.getInt("CaId"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return med;
	}

	@Override
	public boolean insertMedicine(Medicine med) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call insertMedicine(?,?,?,?,?,?,?,?,?,?)}");
			callst.setString(1, med.getMeName());
			callst.setFloat(2, med.getMePrice());
			callst.setString(3, med.getMeProducer());
			callst.setString(4, med.getMeTitle());
			callst.setString(5, med.getMeContent());
			callst.setDate(6, new Date(med.getMeDateOfManufacture().getTime()));
			callst.setDate(7, new Date(med.getMeExpirationDate().getTime()));
			callst.setString(8, med.getMeImage());
			callst.setBoolean(9, med.isMeStatus());
			callst.setInt(10, med.getCaId());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public boolean updateMedicine(Medicine med) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call updateMedicine(?,?,?,?,?,?,?,?,?,?,?)}");
			callst.setInt(1, med.getMeId());
			callst.setString(2, med.getMeName());
			callst.setFloat(3, med.getMePrice());
			callst.setString(4, med.getMeProducer());
			callst.setString(5, med.getMeTitle());
			callst.setString(6, med.getMeContent());
			callst.setDate(7, new Date(med.getMeDateOfManufacture().getTime()));
			callst.setDate(8, new Date(med.getMeExpirationDate().getTime()));
			callst.setString(9, med.getMeImage());
			callst.setBoolean(10, med.isMeStatus());
			callst.setInt(11, med.getCaId());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public boolean deleteMedicine(int meId) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call deleteMedicine(?)}");
			callst.setInt(1, meId);			
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public List<Medicine> searchMedicineByName(String meName) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Medicine> listMed = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call searchMedicineByName(?)}");
			callst.setString(1, meName);
			ResultSet rs = callst.executeQuery();
			listMed = new ArrayList<>();
			while(rs.next()) {
				Medicine med = new Medicine();
				med.setMeId(rs.getInt("MeId"));
				med.setMeName(rs.getString("MeName"));
				med.setMePrice(rs.getFloat("MePrice"));
				med.setMeProducer(rs.getString("MeProducer"));
				med.setMeTitle(rs.getString("MeTitle"));
				med.setMeContent(rs.getString("MeContent"));
				med.setMeDateOfManufacture(rs.getDate("MeDateOfManufacture"));
				med.setMeExpirationDate(rs.getDate("MeExpirationDate"));
				med.setMeImage(rs.getString("MeImage"));
				med.setMeStatus(rs.getBoolean("MeStatus"));
				med.setCaId(rs.getInt("CaId"));
				listMed.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMed;
	}

	@Override
	public List<Medicine> getMedicineWithCaId(int caId) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Medicine> listMed = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getMedicineWithCaId(?)}");
			callst.setInt(1, caId);
			ResultSet rs = callst.executeQuery();
			listMed = new ArrayList<>();
			while(rs.next()) {
				Medicine med = new Medicine();
				med.setMeId(rs.getInt("MeId"));
				med.setMeName(rs.getString("MeName"));
				med.setMePrice(rs.getFloat("MePrice"));
				med.setMeProducer(rs.getString("MeProducer"));
				med.setMeTitle(rs.getString("MeTitle"));
				med.setMeContent(rs.getString("MeContent"));
				med.setMeDateOfManufacture(rs.getDate("MeDateOfManufacture"));
				med.setMeExpirationDate(rs.getDate("MeExpirationDate"));
				med.setMeImage(rs.getString("MeImage"));
				med.setMeStatus(rs.getBoolean("MeStatus"));
				med.setCaId(rs.getInt("CaId"));
				listMed.add(med);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMed;
	}

}
