package hospital.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.Entities.Director;
import hospital.Models.DirectorDAO;

/**
 * Servlet implementation class DirectorController
 */
@WebServlet("/DirectorController")
public class DirectorController extends HttpServlet {
	     
		DirectorDAO diDAO = new DirectorDAO();
	
		Director dir = new Director();
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		if(action.equals("getDirector")) {
			dir = diDAO.getDirector();
			request.setAttribute("dir", dir);
			request.getRequestDispatcher("DirectorDetail.jsp").forward(request, response);
		} else if(action.equals("initEditDirector")) {
			
			//GET diId from request
			int diId = Integer.parseInt(request.getParameter("diId"));
			//CALL model
			dir = diDAO.getDirectorById(diId);
			request.setAttribute("dir", dir);
			request.getRequestDispatcher("EditDirector.jsp").forward(request, response);
		} else if(action.equals("SAVE")) {
			dir = new Director();
			dir.setDiId(Integer.parseInt(request.getParameter("diId")));
			dir.setDiAcc(request.getParameter("diAcc"));
			dir.setDiPass(request.getParameter("diPass"));
			dir.setDiFullName(request.getParameter("diFullName"));
			dir.setDiPhone(request.getParameter("diPhone"));
			dir.setDiContent(request.getParameter("diContent"));
			dir.setDiStatus(Boolean.parseBoolean(request.getParameter("diStatus")));
			boolean check = diDAO.updateDirector(dir);
			if(check) {
				dir = diDAO.getDirector();
				request.setAttribute("dir", dir);
				request.getRequestDispatcher("DirectorDetail.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);	
		
	}

}
