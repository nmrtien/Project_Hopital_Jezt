package hospital.Interfaces;

import java.util.List;

import hospital.Entities.Patients;

public interface IPatients {
	
	
	public Patients checkLoginPatients(String paAcc, String paPass);
	
	public List<Patients> getAllPatients();
	
	public List<Patients> getAllPatientsDoId(int doId);
	
	public Patients getPatientsById(int paId);
	
	public boolean insertPatients(Patients pat);
	
	public boolean updatePatients(Patients pat);
	
	public boolean deletePatients(int paId);
	
	public List<Patients> searchPatientsByName(String paFullName);
	
	public Patients checkAccPatients(String paAcc);

}
