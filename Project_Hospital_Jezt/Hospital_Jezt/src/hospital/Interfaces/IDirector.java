package hospital.Interfaces;

import hospital.Entities.Director;

public interface IDirector {
	
	public Director checkLoginDirector(String diAcc, String diPass);
	
	public Director getDirectorById(int diId);
	
	public Director getDirector();
	
	public boolean updateDirector(Director dir);

}
