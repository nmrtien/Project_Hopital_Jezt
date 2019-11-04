package hospital.Interfaces;

import java.util.List;

import hospital.Entities.Doctor;

public interface IDoctor {
	
	public Doctor checkLoginDoctor(String doAcc, String doPass);
	
	public List<Doctor> getAllDoctor();
	
	public Doctor getDoctorById(int doId);
	
	public boolean inserDoctor(Doctor doc);
	
	public boolean updateDoctor(Doctor doc);
	
	public boolean deleteDoctor(int doId);
	
	public List<Doctor> searchDoctorByName(String doFullName);
	
}
