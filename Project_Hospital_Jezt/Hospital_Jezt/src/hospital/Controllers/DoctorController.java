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
import hospital.Entities.Doctor;
import hospital.Models.CategoryDAO;
import hospital.Models.DoctorDAO;

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
	
	Doctor doc = new Doctor();
	
	DoctorDAO doDAO = new DoctorDAO();
	
	Category cat = new Category();
	
	CategoryDAO caDAO = new CategoryDAO();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("getAll")) {			
			getAllDoctor(doDAO, request, response);			
		}
		
		else if(action.equals("detail")) {
			int doId = Integer.parseInt(request.getParameter("doId"));
			doc = doDAO.getDoctorById(doId);
			request.setAttribute("doc", doc);
			request.getRequestDispatcher("DoctorDetail.jsp").forward(request, response);
		}
		
		
		else if(action.equals("CREATE")) {
			doc = new Doctor();
			doc.setDoAcc(request.getParameter("doAcc"));
			doc.setDoPass(request.getParameter("doPass"));
			doc.setDoFullName(request.getParameter("doFullName"));
			doc.setDoPhone(request.getParameter("doPhone"));
			doc.setDoAge(Integer.parseInt(request.getParameter("doAge")));
			doc.setDoEmail(request.getParameter("doEmail"));
			doc.setDoAvatar(request.getParameter("doAvatar"));
			doc.setDoAdress(request.getParameter("doAdress"));
			doc.setDoContent(request.getParameter("doContent"));
			doc.setDoStatus(Boolean.parseBoolean(request.getParameter("doStatus")));
			doc.setCaId(Integer.parseInt(request.getParameter("caId")));
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

			List<Category> listCat = new ArrayList<>(); listCat = caDAO.getAllCategory();
			request.setAttribute("listCat", listCat);
			 
			request.setAttribute("doc", doc);
			request.getRequestDispatcher("EditDoctor.jsp").forward(request, response);
		}
		
		else if(action.equals("EDIT")) {
			doc = new Doctor();
			doc.setDoId(Integer.parseInt(request.getParameter("doId")));
			doc.setDoAcc(request.getParameter("doAcc"));
			doc.setDoPass(request.getParameter("doPass"));
			doc.setDoFullName(request.getParameter("doFullName"));
			doc.setDoPhone(request.getParameter("doPhone"));
			doc.setDoAge(Integer.parseInt(request.getParameter("doAge")));
			doc.setDoEmail(request.getParameter("doEmail"));
			doc.setDoAvatar(request.getParameter("doAvatar"));
			doc.setDoAdress(request.getParameter("doAdress"));
			doc.setDoContent(request.getParameter("doContent"));
			doc.setDoStatus(Boolean.parseBoolean(request.getParameter("doStatus")));
			doc.setCaId(Integer.parseInt(request.getParameter("caId")));
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

}
