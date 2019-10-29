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

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	
		Category cat = new Category();
		
		Doctor doc = new Doctor();
		
		CategoryDAO caDAO = new CategoryDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("getAllCategory")) {
			List<Category> listCat = new ArrayList<>();
			listCat = caDAO.getAllCategory();
			request.setAttribute("listCat", listCat);
			request.getRequestDispatcher("Department.jsp").forward(request, response);
		} else if(action.equals("getDoctorWithCaId")) {
			//GET caId from request
			int caId = Integer.parseInt(request.getParameter("caId"));
			List<Doctor> listDoc = new ArrayList<>();
			//CALL MODELS
			listDoc = caDAO.getDoctorWithCaId(caId);
			request.setAttribute("listDoc", listDoc);
			request.getRequestDispatcher("DepartmentDetail.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
