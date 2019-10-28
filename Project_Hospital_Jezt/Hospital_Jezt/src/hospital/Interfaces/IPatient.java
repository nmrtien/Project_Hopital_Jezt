package hospital.Interfaces;

import java.util.List;

import hospital.Entities.Patient;

public interface IPatient {
	
	
	public Patient checkPatient(String paAcc, String paPass);
	
	public List<Patient> getAllPatient(int doId);
	
	public Patient getPatientById(int paId);
	
	public boolean insertPatient(Patient pat);
	
	public boolean updatePatient(Patient pat);
	
	public boolean deletePatient(int paId);

}
