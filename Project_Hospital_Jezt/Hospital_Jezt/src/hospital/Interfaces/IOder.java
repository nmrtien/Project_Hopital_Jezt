package hospital.Interfaces;

import java.util.List;

import hospital.Entities.Oder;

public interface IOder {
	
	public boolean inserOder(Oder od);
	public List<Oder> getAllOder();
	public int getOderId();
	public List<Oder> searchOderById(int odId);
	public boolean deleteOder(int odId);
	
}
