package hospital.Interfaces;

import java.util.List;

import hospital.Entities.Medicine;

public interface IMedicine {
	
	public List<Medicine> getAllMedicine();
	
	public Medicine getMedicineById(int meId);
	
	public boolean insertMedicine(Medicine med);
	
	public boolean updateMedicine(Medicine med);
	
	public boolean deleteMedicine(int meId);
	
	public List<Medicine> searchMedicineByName(String meName);

}
