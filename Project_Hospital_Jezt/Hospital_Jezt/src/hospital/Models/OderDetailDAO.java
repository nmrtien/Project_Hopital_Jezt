package hospital.Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hospital.Connections.ConnectionDB;
import hospital.Entities.OderDetail;
import hospital.Interfaces.IOderDetail;

public class OderDetailDAO implements IOderDetail{

	@Override
	public List<OderDetail> getOderDetail(int odId) {
		Connection conn = null;
		CallableStatement callst = null;
		List<OderDetail> listOdd = null;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call getOderDetail(?)}");
			callst.setInt(1, odId);
			ResultSet rs = callst.executeQuery();
			listOdd = new ArrayList<>();
			while(rs.next()) {
				OderDetail odd = new OderDetail();
				odd.setOddId(rs.getInt("OddId"));
				odd.setOddMeName(rs.getString("OddMeName"));
				odd.setOddMeQuantity(rs.getInt("OddMeQuantity"));
				odd.setOddMePrice(rs.getFloat("OddMePrice"));
				odd.setOddAmount(rs.getFloat("OddAmount"));
				odd.setOdId(rs.getInt("OdId"));
				listOdd.add(odd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionDB.closeAll(conn, callst);
		}
		return listOdd;	
	}

	@Override
	public boolean inserOderDetail(OderDetail odd) {
		Connection conn = null;
		CallableStatement callst = null;
		boolean check = true;
		try {
			conn = ConnectionDB.openConection();
			callst = conn.prepareCall("{call insertOderDetail(?,?,?,?,?)}");
			callst.setString(1, odd.getOddMeName());
			callst.setInt(2, odd.getOddMeQuantity());
			callst.setFloat(3, odd.getOddMePrice());
			callst.setFloat(4, odd.getOddAmount());
			callst.setInt(5, odd.getOdId());
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
