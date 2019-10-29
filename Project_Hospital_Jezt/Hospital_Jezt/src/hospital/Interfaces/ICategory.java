package hospital.Interfaces;

import java.util.List;

import hospital.Entities.Category;
import hospital.Entities.Doctor;;

public interface ICategory {
	
	public List<Category> getAllCategory();
	
	public boolean insertCategory(Category cat);
	
	public boolean updateCategory(Category cat);
	
	public Category getCategoryById(int caId);
	
	public boolean deleteCategory(int caId);
	
	public List<Doctor> getDoctorWithCaId(int caId);
}
