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
		
		else if(action.equals("getDetailPatients")) {
			
			int doId = Integer.parseInt(request.getParameter("doId"));
			
			doc = doDAO.getDoctorById(doId);
			request.setAttribute("doc", doc);
			request.getRequestDispatcher("Patients.jsp").forward(request, response);
		}
		
		else if(action.equals("Search")) {
			
			String paFullName = request.getParameter("paFullName");
			List<Patients> listPat = new ArrayList<>();
			listPat = paDAO.searchPatientsByName(paFullName);
			request.setAttribute("listPat", listPat);
			request.getRequestDispatcher("ListPatientsDoctor.jsp").forward(request, response);
			
			}
		
		else if(action.equals("initEdit")) {
			initEdit(paDAO, request, response);
		}
		
		else if(action.equals("getPatientsByIdDoctor")) {
			int paId = Integer.parseInt(request.getParameter("paId"));
			pat = paDAO.getPatientsById(paId);
			request.setAttribute("pat", pat);
			request.getRequestDispatcher("PatientsDetailDoctor.jsp").forward(request, response);
		}
		
		else if(action.equals("getPatientsByIdDirector")) {
			int paId = Integer.parseInt(request.getParameter("paId"));
			pat = paDAO.getPatientsById(paId);
			request.setAttribute("pat", pat);
			request.getRequestDispatcher("PatientsDetailDirector.jsp").forward(request, response);
		}
		
		else if(action.equals("EDIT")) {
			pat = new Patients();
			pat.setPaId(Integer.parseInt(request.getParameter("paId")));
			pat.setPaAcc(request.getParameter("paAcc"));
			pat.setPaPass(request.getParameter("paPass"));
			pat.setPaFullName(request.getParameter("paFullName"));
			pat.setPaPhone(request.getParameter("paPhone"));
			pat.setPaAge(Integer.parseInt(request.getParameter("paAge")));
			pat.setPaEmail(request.getParameter("paEmail"));
			pat.setPaAvatar(request.getParameter("paAvatar"));
			pat.setPaAddress(request.getParameter("paAddress"));
			pat.setPaContent(request.getParameter("paContent"));
			pat.setPaStatus(Boolean.parseBoolean(request.getParameter("paStatus")));
			pat.setDoId(Integer.parseInt(request.getParameter("doId")));
			pat.setRollId(Integer.parseInt(request.getParameter("rollId")));
			boolean check = paDAO.updatePatients(pat);
			if(check) {
				request.setAttribute("pat", pat);
				getAllPatientsDoctor(paDAO, request, response);
			} else {
				request.setAttribute("message", "Edit Fail");
				
				initEdit(paDAO, request, response);
			}
		}
		
		else if(action.equals("CREATE")) {
			
			String paAcc = request.getParameter("paAcc");
			pat = paDAO.checkAccPatients(paAcc);
			if(pat!=null) {
				request.setAttribute("accFail02", "Username already exists");
				request.getRequestDispatcher("CreatePatients.jsp").forward(request, response);
			} else if(paAcc=="" || paAcc.length()>10) {
				
				request.setAttribute("accFail", "Username not valid !");
				request.getRequestDispatcher("CreatePatients.jsp").forward(request, response);
			}
			
			pat = new Patients();
			pat.setPaAcc(request.getParameter("paAcc"));
			
			pat.setPaPass(request.getParameter("paPass"));
			pat.setPaFullName(request.getParameter("paFullName"));
			pat.setPaPhone(request.getParameter("paPhone"));
			pat.setPaAge(Integer.parseInt(request.getParameter("paAge")));
			pat.setPaEmail(request.getParameter("paEmail"));
			pat.setPaAvatar(request.getParameter("paAvatar"));
			pat.setPaAddress(request.getParameter("paAddress"));
			pat.setPaContent(request.getParameter("paContent"));
			pat.setPaStatus(Boolean.parseBoolean(request.getParameter("paStatus")));
			pat.setDoId(Integer.parseInt(request.getParameter("doId")));
			pat.setRollId(Integer.parseInt(request.getParameter("rollId")));
			boolean check = paDAO.insertPatients(pat);
			if(check) {
				System.out.println("come in");
				request.setAttribute("pat", pat);
				getAllPatientsDoctor(paDAO, request, response);
			} else {
				request.setAttribute("message", "Create Fail");
				
				request.getRequestDispatcher("CreatePatients.jsp").forward(request, response);
			}
		}
		
		else if(action.equals("delete")) {
			int paId = Integer.parseInt(request.getParameter("paId"));
			boolean check = paDAO.deletePatients(paId);
			if(check) {
				getAllPatients(paDAO, request, response);
			} else {
				request.setAttribute("message", "Delete Fail");
				getAllPatients(paDAO, request, response);
			}
		
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
	
	protected void getAllPatientsDoctor(PatientsDAO paDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int doId = Integer.parseInt(request.getParameter("doId"));
		List<Patients> listPat = new ArrayList<>();
		listPat = paDAO.getAllPatientsDoId(doId);
		request.setAttribute("listPat", listPat);
		request.getRequestDispatcher("ListPatientsDoctor.jsp").forward(request, response);
		
	}
	
	protected void initEdit(PatientsDAO paDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int paId = Integer.parseInt(request.getParameter("paId"));
		pat = paDAO.getPatientsById(paId);
		request.setAttribute("pat", pat);
		request.getRequestDispatcher("EditPatients.jsp").forward(request, response);
		
	}

}
