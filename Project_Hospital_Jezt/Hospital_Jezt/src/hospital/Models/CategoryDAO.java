package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.Category;
import hospital.Entities.Doctor;
import hospital.Interfaces.ICategory;

public class CategoryDAO implements ICategory{

	@Override
	public List<Category> getAllCategory() {
		Connection conn = null;
		CallableStatement callst = null;
		List<Category> listCat = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getAllCategory()}");
			ResultSet rs = callst.executeQuery();
			listCat = new ArrayList<>();
			while(rs.next()) {
				Category cat = new Category();
				cat.setCaId(rs.getInt("CaId"));
				cat.setCaName(rs.getString("CaName"));
				cat.setCaContent(rs.getString("CaContent"));
				cat.setCaStatus(rs.getBoolean("CaStatus"));
				cat.setCaImage(rs.getString("CaImage"));
				listCat.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCat;
	}

	@Override
	public boolean insertCategory(Category cat) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call insertCategory(?,?,?,?)}");
			callst.setString(1, cat.getCaName());
			callst.setString(2,cat.getCaContent());
			callst.setBoolean(3, cat.isCaStatus());
			callst.setString(4, cat.getCaImage());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public boolean updateCategory(Category cat) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call updateCategory(?,?,?,?,?)}");
			callst.setInt(1, cat.getCaId());
			callst.setString(2, cat.getCaName());
			callst.setString(3,cat.getCaContent());
			callst.setBoolean(4, cat.isCaStatus());
			callst.setString(5, cat.getCaImage());
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	@Override
	public Category getCategoryById(int caId) {
		Connection conn = null;
		CallableStatement callst = null;
		Category cat = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getCategoryById(?)}");
			callst.setInt(1, caId);
			ResultSet rs = callst.executeQuery();
			if(rs.next()) {
				cat = new Category();
				cat.setCaId(rs.getInt("CaId"));
				cat.setCaName(rs.getString("CaName"));
				cat.setCaContent(rs.getString("CaContent"));
				cat.setCaStatus(rs.getBoolean("CaStatus"));
				cat.setCaImage(rs.getString("CaImage"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cat;
	}
	
	@Override
	public List<Doctor> getDoctorWithCaId(int caId) {
		Connection conn = null;
		CallableStatement callst = null;
		List<Doctor> listDoc = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getDoctorWithCaId(?)}");
			callst.setInt(1, caId);
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
				listDoc.add(doc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDoc;
	}

	@Override
	public boolean deleteCategory(int caId) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call deleteCategory(?)}");
			callst.setInt(1, caId);			
			callst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

}
