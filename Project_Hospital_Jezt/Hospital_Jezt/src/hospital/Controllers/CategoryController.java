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
			GetAllCategory(caDAO, request, response);
			
		} 
		
		else if(action.equals("getDoctorWithCaId")) {
			//GET caId from request
			int caId = Integer.parseInt(request.getParameter("caId"));
			List<Doctor> listDoc = new ArrayList<>();
			//CALL MODELS
			listDoc = caDAO.getDoctorWithCaId(caId);
			request.setAttribute("listDoc", listDoc);
			request.getRequestDispatcher("DepartmentDetail.jsp").forward(request, response);
		} 
		
		else if(action.equals("CREATE")) {
			cat = new Category();
			cat.setCaName(request.getParameter("caName"));
			cat.setCaContent(request.getParameter("caContent"));
			cat.setCaStatus(Boolean.parseBoolean(request.getParameter("caStatus")));
			boolean check = caDAO.insertCategory(cat);
			if(check) {
				GetAllCategory(caDAO, request, response);
			} else {
				request.setAttribute("createFail", "Create Category fail !");
				request.getRequestDispatcher("CreateCategory.jsp").forward(request, response);
			}
		} 
		
		else if(action.equals("delete")) {
			int caId = Integer.parseInt(request.getParameter("caId"));
			boolean check = caDAO.deleteCategory(caId);
			if(check) {
				GetAllCategory(caDAO, request, response);
			} else {
				request.setAttribute("deleteFail", "Delete fail !");
				GetAllCategory(caDAO, request, response);
			}
		} 
		
		else if(action.equals("initEdit")) {
			int caId = Integer.parseInt(request.getParameter("caId"));
			cat = caDAO.getCategoryById(caId);
			request.setAttribute("cat", cat);
			request.getRequestDispatcher("EditCategory.jsp").forward(request, response);
		} 
		
		else if(action.equals("EDIT")) {
			cat = new Category();
			cat.setCaId(Integer.parseInt(request.getParameter("caId")));
			cat.setCaName(request.getParameter("caName"));
			cat.setCaContent(request.getParameter("caContent"));
			cat.setCaStatus(Boolean.parseBoolean(request.getParameter("caStatus")));
			boolean check = caDAO.updateCategory(cat);
			if(check) {
				GetAllCategory(caDAO, request, response);
			} else {
				request.setAttribute("editFail", "Edit fail !");
				GetAllCategory(caDAO, request, response);
			}
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	public void GetAllCategory(CategoryDAO caDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> listCat = new ArrayList<>();
		listCat = caDAO.getAllCategory();
		request.setAttribute("listCat", listCat);
		request.getRequestDispatcher("Department.jsp").forward(request, response);
		}

}
