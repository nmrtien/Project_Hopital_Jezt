package hospital.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;

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

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
	
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
		
		if(action.equals("getAllDoctor")) {			
			getAllDoctor(doDAO, request, response);			
		}
		
		else if(action.equals("Search")) {
			
			String paFullName = request.getParameter("paFullName");
			String meName = request.getParameter("meName");
			if(paFullName!="") {
				List<Patients> listPat = new ArrayList<>();
				listPat = paDAO.searchPatientsByName(paFullName);
				request.setAttribute("listPat", listPat);
				request.getRequestDispatcher("ListPatientDoctor.jsp").forward(request, response);
			} else if(meName!=""){
				List<Medicine> listMed = new ArrayList<>();
				listMed = meDAO.searchMedicineByName(meName);
				request.setAttribute("listMed", listMed);
				request.getRequestDispatcher("ListMedicineDoctor.jsp").forward(request, response);
			}
			
		}
		
		else if(action.equals("detail")) {
			int doId = Integer.parseInt(request.getParameter("doId"));
			doc = doDAO.getDoctorById(doId);
			request.setAttribute("doc", doc);
			request.getRequestDispatcher("DoctorDetail.jsp").forward(request, response);
		}
		
		else if(action.equals("initCreateDoctor")) {
			
			initCreateDoctor(doDAO, request, response);
			
		}
		
		
		else if(action.equals("CREATE")) {
			
			
			String doAcc = request.getParameter("doAcc");
			doc = doDAO.checkAccDoctor(doAcc);
			
			if(doc!=null) {
				request.setAttribute("accFail02", "Username already exists");
				initCreateDoctor(doDAO, request, response);
			} else if(doAcc=="" || doAcc.length()>10) {
				
				request.setAttribute("accFail", "Username not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc = new Doctor();
			doc.setDoAcc(doAcc);
			doc.setDoPass(request.getParameter("doPass"));
			if(doc.getDoPass()==""|| doc.getDoPass().length()>10) {
				request.setAttribute("passFail", "Password not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc.setDoFullName(request.getParameter("doFullName"));
			if(doc.getDoFullName()=="") {
				request.setAttribute("fullnameFail", "Fullname not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc.setDoPhone(request.getParameter("doPhone"));
			if(doc.getDoPhone()=="") {
				request.setAttribute("phoneFail", "Phone not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc.setDoAge(Integer.parseInt(request.getParameter("doAge")));
			if(doc.getDoAge()<=0) {
				request.setAttribute("ageFail", "Age not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc.setDoEmail(request.getParameter("doEmail"));
			if(doc.getDoEmail()=="") {
				request.setAttribute("emailFail", "Email not valid !");
				initCreateDoctor(doDAO, request, response);			}
			doc.setDoAvatar(request.getParameter("doAvatar"));
			if(doc.getDoAvatar()=="") {
				request.setAttribute("avatarFail", "Avatar not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc.setDoAddress(request.getParameter("doAddress"));
			if(doc.getDoAddress()=="") {
				request.setAttribute("addressFail", "Address not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc.setDoContent(request.getParameter("doContent"));
			
			doc.setDoStatus(Boolean.parseBoolean(request.getParameter("doStatus")));
			
			doc.setCaId(Integer.parseInt(request.getParameter("caId")));
			if(doc.getCaId()<=0) {
				request.setAttribute("caIdFail", "Username not valid !");
				initCreateDoctor(doDAO, request, response);
			}
			doc.setRollId(Integer.parseInt(request.getParameter("rollId")));
			boolean check = doDAO.inserDoctor(doc);
			if(check) {
				getAllDoctor(doDAO, request, response);
			} else {
				request.setAttribute("createDoctorFail", "Create fail");
				getAllDoctor(doDAO, request, response);
			}
		}
		
		else if(action.equals("initEdit")) {
			int doId = Integer.parseInt(request.getParameter("doId"));
			doc = doDAO.getDoctorById(doId);

			List<Category> listCat = new ArrayList<>(); 
			listCat = caDAO.getAllCategory();
			request.setAttribute("listCat", listCat);
			 
			request.setAttribute("doc", doc);
			request.getRequestDispatcher("EditDoctor.jsp").forward(request, response);
		}
		
		else if(action.equals("EDIT")) {
			doc = new Doctor();
			doc.setDoId(Integer.parseInt(request.getParameter("doId")));
			doc.setDoAcc(request.getParameter("doAcc"));			
			doc.setDoPass(request.getParameter("doPass"));
			if(doc.getDoPass()=="") {
				request.setAttribute("passFail", "Password not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setDoFullName(request.getParameter("doFullName"));
			if(doc.getDoFullName()=="") {
				request.setAttribute("fullnameFail", "Fullname not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setDoPhone(request.getParameter("doPhone"));
			if(doc.getDoPhone()=="") {
				request.setAttribute("phoneFail", "Phone not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setDoAge(Integer.parseInt(request.getParameter("doAge")));
			if(doc.getDoAge()<=0) {
				request.setAttribute("ageFail", "Age not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setDoEmail(request.getParameter("doEmail"));
			if(doc.getDoEmail()=="") {
				request.setAttribute("emailFail", "Email not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setDoAvatar(request.getParameter("doAvatar"));
			if(doc.getDoAvatar()=="") {
				request.setAttribute("avatarFail", "Avatar not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setDoAddress(request.getParameter("doAddress"));
			if(doc.getDoAddress()=="") {
				request.setAttribute("addressFail", "Address not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setDoContent(request.getParameter("doContent"));
			doc.setDoStatus(Boolean.parseBoolean(request.getParameter("doStatus")));
			doc.setCaId(Integer.parseInt(request.getParameter("caId")));
			if(doc.getCaId()<=0) {
				request.setAttribute("caIdFail", "Please choose not valid !");
				initEdit(doDAO, request, response);
			}
			doc.setRollId(Integer.parseInt(request.getParameter("rollId")));
			boolean check = doDAO.updateDoctor(doc);
			if(check) {
				getAllDoctor(doDAO, request, response);
			} else {
				request.setAttribute("updateDoctorFail", "Edit fail");
				getAllDoctor(doDAO, request, response);
			}
		}
		
		else if(action.equals("delete")) {
			int doId = Integer.parseInt(request.getParameter("doId"));
			boolean check = doDAO.deleteDoctor(doId);
			if(check) {
				getAllDoctor(doDAO, request, response);
			} else {
				request.setAttribute("deleteDoctorFail", "Delete fail");
				getAllDoctor(doDAO, request, response);
			}
		}
		
		else if(action.equals("listDoctorHome")) {
			List<Doctor> listDoc = new ArrayList<>();
			listDoc = doDAO.selectTop8Doctor();
			request.setAttribute("listDoc", listDoc);
			request.getRequestDispatcher("HomeDoctor.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void getAllDoctor(DoctorDAO doDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Doctor> listDoc = new ArrayList<>();
		
		listDoc = doDAO.getAllDoctor();
		request.setAttribute("listDoc", listDoc);
		request.getRequestDispatcher("ListDoctor.jsp").forward(request, response);
		
	}
	
	protected void initCreateDoctor(DoctorDAO doDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> listCat = new ArrayList<>();
		listCat = caDAO.getAllCategory();
	
		request.setAttribute("listCat", listCat);
		request.getRequestDispatcher("CreateDoctor.jsp").forward(request, response);
		
	}
	
	protected void initEdit(DoctorDAO doDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int doId = Integer.parseInt(request.getParameter("doId"));
		doc = doDAO.getDoctorById(doId);

		List<Category> listCat = new ArrayList<>(); 
		listCat = caDAO.getAllCategory();
		request.setAttribute("listCat", listCat);
		 
		request.setAttribute("doc", doc);
		request.getRequestDispatcher("EditDoctor.jsp").forward(request, response);
		
	}

}
