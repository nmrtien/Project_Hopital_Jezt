package hospital.Controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 * Servlet implementation class MedicineController
 */
@WebServlet("/MedicineController")
public class MedicineController extends HttpServlet {
	
		Director dir = new Director();
	
		Doctor doc = new Doctor();
	
		Patients pat = new Patients();
	
		Medicine med = new Medicine();
	
		DoctorDAO doDAO = new DoctorDAO();
	
		PatientsDAO paDAO = new PatientsDAO();
	
		DirectorDAO diDAO = new DirectorDAO();
	
		MedicineDAO meDAO = new MedicineDAO();
	
		Category cat = new Category();
	
		CategoryDAO caDAO = new CategoryDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		if(action.equals("getAllMedicine")) {
			getAllMedicine(diDAO, meDAO, request, response);
		}
		
		else if(action.equals("detail")) {
			int meId = Integer.parseInt(request.getParameter("meId"));
			med = meDAO.getMedicineById(meId);
			dir = diDAO.getDirector();
			request.setAttribute("med", med);
			request.setAttribute("dir", dir);
			request.getRequestDispatcher("MedicineDetailDirector.jsp").forward(request, response);
		}
		
		else if(action.equals("detailDoctor")) {
			int meId = Integer.parseInt(request.getParameter("meId"));
			med = meDAO.getMedicineById(meId);
			dir = diDAO.getDirector();
			request.setAttribute("med", med);
			request.setAttribute("dir", dir);
			request.getRequestDispatcher("MedicineDetailDoctor.jsp").forward(request, response);
		}
		
		else if(action.equals("initEdit")) {
			int meId = Integer.parseInt(request.getParameter("meId"));
			med = meDAO.getMedicineById(meId);
			dir = diDAO.getDirector();
			List<Category> listCat = new ArrayList<>(); 
			listCat = caDAO.getAllCategory();
			request.setAttribute("listCat", listCat);
			request.setAttribute("med", med);
			request.setAttribute("dir", dir);
			request.getRequestDispatcher("EditMedicine.jsp").forward(request, response);
		}
		
		else if(action.equals("EDIT")) {
			med = new Medicine();
			med.setMeId(Integer.parseInt(request.getParameter("meId")));
			med.setMeName(request.getParameter("meName"));
			med.setMePrice(Float.parseFloat(request.getParameter("mePrice")));
			med.setMeProducer(request.getParameter("meProducer"));
			med.setMeTitle(request.getParameter("meTitle"));
			med.setMeContent(request.getParameter("meContent"));
			try {
				med.setMeDateOfManufacture(sdf.parse(request.getParameter("meDateOfManufacture").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				med.setMeExpirationDate(sdf.parse(request.getParameter("meExpirationDate").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			med.setMeImage(request.getParameter("meImage"));
			med.setMeStatus(Boolean.parseBoolean(request.getParameter("meStatus")));
			med.setCaId(Integer.parseInt(request.getParameter("caId")));
			boolean check = meDAO.updateMedicine(med);
			if(check) {
				getAllMedicine(diDAO, meDAO, request, response);
			} else {
				getAllMedicine(diDAO, meDAO, request, response);
			}
		}
		
		else if(action.equals("initCreateMedicine")) {
			List<Category> listCat = new ArrayList<>();
			listCat = caDAO.getAllCategory();
			dir = diDAO.getDirector();
			request.setAttribute("dir", dir);
			request.setAttribute("listCat", listCat);
			request.getRequestDispatcher("CreateMedicine.jsp").forward(request, response);
		}
		
		else if(action.equals("CREATE")) {
			med = new Medicine();
			med.setMeName(request.getParameter("meName"));
			med.setMePrice(Float.parseFloat(request.getParameter("mePrice")));
			med.setMeProducer(request.getParameter("meProducer"));
			med.setMeTitle(request.getParameter("meTitle"));
			med.setMeContent(request.getParameter("meContent"));
			try {
				med.setMeDateOfManufacture(sdf.parse(request.getParameter("meDateOfManufacture").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				med.setMeExpirationDate(sdf.parse(request.getParameter("meExpirationDate").toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			med.setMeImage(request.getParameter("meImage"));
			med.setMeStatus(Boolean.parseBoolean(request.getParameter("meStatus")));
			med.setCaId(Integer.parseInt(request.getParameter("caId")));
			boolean check = meDAO.insertMedicine(med);
			if(check) {
				getAllMedicine(diDAO, meDAO, request, response);
			} else {
				getAllMedicine(diDAO, meDAO, request, response);
			}
		}
		
		else if(action.equals("delete")) {
			int meId = Integer.parseInt(request.getParameter("meId"));
			boolean check = meDAO.deleteMedicine(meId);
			if(check) {
				getAllMedicine(diDAO, meDAO, request, response);
			}else {
				getAllMedicine(diDAO, meDAO, request, response);
			}
		}
		
		else if(action.equals("Search")) {
			String meName = request.getParameter("meName");
			List<Medicine> listMed = new ArrayList<>();
			listMed = meDAO.searchMedicineByName(meName);
			
			request.setAttribute("listMed", listMed);
			request.getRequestDispatcher("ListMedicineDoctor.jsp").forward(request, response);
		}
		
		else if(action.equals("getMedicineWithCaId")) {
			int caId = Integer.parseInt(request.getParameter("caId"));
			
			List<Medicine> listMed = new ArrayList<>();
			listMed = meDAO.getMedicineWithCaId(caId);
			
			request.setAttribute("listMed", listMed);
			request.getRequestDispatcher("ListMedicineDoctor.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void getAllMedicine(DirectorDAO diDAO ,MedicineDAO meDAO ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dir = diDAO.getDirector();
		List<Medicine> listMed = new ArrayList<>();
		listMed = meDAO.getAllMedicine();
		
		request.setAttribute("dir", dir);
		request.setAttribute("listMed", listMed);
		request.getRequestDispatcher("ListMedicineDirector.jsp").forward(request, response);
		
	}

}
