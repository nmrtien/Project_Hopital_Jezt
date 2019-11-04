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
import hospital.Models.CategoryDAO;
import hospital.Models.DirectorDAO;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	
		Category cat = new Category();
		
		Doctor doc = new Doctor();
		
		Medicine med = new Medicine();
		
		Director dir = new Director();
		
		DirectorDAO diDAO = new DirectorDAO();
		
		CategoryDAO caDAO = new CategoryDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("getAllCategory")) {
			getAllCategory(caDAO, diDAO, request, response);
			
		} 
		
		else if(action.equals("getDoctorWithCaId")) {
			//GET caId from request
			int caId = Integer.parseInt(request.getParameter("caId"));
			List<Doctor> listDoc = new ArrayList<>();
			//CALL MODELS
			listDoc = caDAO.getDoctorWithCaId(caId);
			dir = diDAO.getDirector();
			request.setAttribute("dir", dir);
			request.setAttribute("listDoc", listDoc);
			request.getRequestDispatcher("CategoryDetail.jsp").forward(request, response);
		} 
		
		else if(action.equals("CREATE")) {
			cat = new Category();
			cat.setCaName(request.getParameter("caName"));
			cat.setCaContent(request.getParameter("caContent"));
			cat.setCaStatus(Boolean.parseBoolean(request.getParameter("caStatus")));
			boolean check = caDAO.insertCategory(cat);
			if(check) {
				getAllCategory(caDAO, diDAO, request, response);
			} else {
				request.setAttribute("createFail", "Create Category fail !");
				request.getRequestDispatcher("CreateCategory.jsp").forward(request, response);
			}
		} 
		
		else if(action.equals("delete")) {
			int caId = Integer.parseInt(request.getParameter("caId"));
			boolean check = caDAO.deleteCategory(caId);
			if(check) {
				getAllCategory(caDAO, diDAO, request, response);
			} else {
				request.setAttribute("deleteFail", "Delete fail !");
				getAllCategory(caDAO, diDAO, request, response);
			}
		} 
		
		else if(action.equals("initEdit")) {
			int caId = Integer.parseInt(request.getParameter("caId"));
			cat = caDAO.getCategoryById(caId);
			dir = diDAO.getDirector();
			request.setAttribute("dir", dir);
			request.setAttribute("cat", cat);
			request.getRequestDispatcher("EditCategory.jsp").forward(request, response);
		} 
		
		else if(action.equals("SAVE")) {
			cat = new Category();
			cat.setCaId(Integer.parseInt(request.getParameter("caId")));
			cat.setCaName(request.getParameter("caName"));
			cat.setCaContent(request.getParameter("caContent"));
			cat.setCaStatus(Boolean.parseBoolean(request.getParameter("caStatus")));
			boolean check = caDAO.updateCategory(cat);
			if(check) {
				getAllCategory(caDAO, diDAO, request, response);
			} else {
				request.setAttribute("editFail", "Edit fail !");
				getAllCategory(caDAO, diDAO, request, response);
			}		
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	public void getAllCategory(CategoryDAO caDAO, DirectorDAO diDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> listCat = new ArrayList<>();
		listCat = caDAO.getAllCategory();
		dir = diDAO.getDirector();
		request.setAttribute("dir", dir);
		request.setAttribute("listCat", listCat);
		request.getRequestDispatcher("Category.jsp").forward(request, response);
		
		}

}
