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
			
				initEdit(diDAO, request, response);
			} else if(action.equals("SAVE")) {
				dir = new Director();
				dir.setDiId(Integer.parseInt(request.getParameter("diId")));
				dir.setDiAcc(request.getParameter("diAcc"));
				if(dir.getDiAcc()=="" || dir.getDiAcc().length()>10) {
				
					request.setAttribute("accFail", "Username not valid !");
					initEdit(diDAO, request, response);
				}
				dir.setDiPass(request.getParameter("diPass"));
				if(dir.getDiPass()=="" || dir.getDiPass().length()>10) {
					
					request.setAttribute("passFail", "Password not valid !");
					initEdit(diDAO, request, response);
				}
				dir.setDiFullName(request.getParameter("diFullName"));
				if(dir.getDiFullName()=="") {
					
					request.setAttribute("fullNameFail", "Fullname not valid !");
					initEdit(diDAO, request, response);
				}
				dir.setDiPhone(request.getParameter("diPhone"));
				if(dir.getDiPhone()=="" || dir.getDiAcc().length()>10) {
					
					request.setAttribute("phoneFail", "Phone not valid !");
					initEdit(diDAO, request, response);
				}
				dir.setDiContent(request.getParameter("diContent"));
				dir.setDiStatus(Boolean.parseBoolean(request.getParameter("diStatus")));
				dir.setRollId(Integer.parseInt(request.getParameter("rollId")));
				boolean check = diDAO.updateDirector(dir);
				if(check) {
					dir = diDAO.getDirector();
					request.setAttribute("dir", dir);
					request.getRequestDispatcher("DirectorDetail.jsp").forward(request, response);
				}else {
					
					request.setAttribute("message", "Edit Fail !");
					initEdit(diDAO, request, response);
				}
			}
		}

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);	
		
		}
		
		protected void initEdit(DirectorDAO diDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//GET diId from request
			int diId = Integer.parseInt(request.getParameter("diId"));
			//CALL model
			dir = diDAO.getDirectorById(diId);
			request.setAttribute("dir", dir);
			request.getRequestDispatcher("EditDirector.jsp").forward(request, response);				
		}

}
