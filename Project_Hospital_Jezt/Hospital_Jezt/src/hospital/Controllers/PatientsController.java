package hospital.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.Entities.Category;
import hospital.Entities.Director;
import hospital.Entities.Doctor;
import hospital.Entities.Medicine;
import hospital.Entities.Patients;
import hospital.Models.CategoryDAO;
import hospital.Models.DirectorDAO;
import hospital.Models.DoctorDAO;
import hospital.Models.MedicineDAO;
import hospital.Models.PatientsDAO;


@WebServlet("/PatientsController")
public class PatientsController extends HttpServlet {
	
		Doctor doc = new Doctor();
	
		DoctorDAO doDAO = new DoctorDAO();

		Director dir = new Director();

		DirectorDAO diDAO = new DirectorDAO();

		Category cat = new Category();

		CategoryDAO caDAO = new CategoryDAO();

		Patients pat = new Patients();
	
		PatientsDAO paDAO = new PatientsDAO();
	
		Medicine med = new Medicine();
	
		MedicineDAO meDAO = new MedicineDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("getAllPatients")) {
			getAllPatients(paDAO, request, response);
		}
		
		else if(action.equals("getAllPatientsDoId")) {
			int doId = Integer.parseInt(request.getParameter("doId"));
			List<Patients> listPat = new ArrayList<>();
			listPat = paDAO.getAllPatientsDoId(doId);
			request.setAttribute("listPat", listPat);
			request.getRequestDispatcher("ListPatientsDoctor.jsp").forward(request, response);
		}
		
		else if(action.equals("Search")) {
			
			String paFullName = request.getParameter("paFullName");
			List<Patients> listPat = new ArrayList<>();
			listPat = paDAO.searchPatientsByName(paFullName);
			request.setAttribute("listPat", listPat);
			request.getRequestDispatcher("ListPatientsDoctor.jsp").forward(request, response);
			
			} 
			
		}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void getAllPatients(PatientsDAO paDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Patients> listPat = new ArrayList<>();
		listPat = paDAO.getAllPatients();
		request.setAttribute("listPat", listPat);
		request.getRequestDispatcher("ListPatientsDirector.jsp").forward(request, response);
		
	}

}
