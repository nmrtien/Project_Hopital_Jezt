package hospital.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hospital.Entities.Director;
import hospital.Entities.Doctor;
import hospital.Entities.Patients;
import hospital.Models.DirectorDAO;
import hospital.Models.DoctorDAO;
import hospital.Models.PatientsDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		String diAcc = request.getParameter("diAcc");
		String diPass = request.getParameter("diPass");
		String doAcc = request.getParameter("doAcc");
		String doPass = request.getParameter("doPass");
		String paAcc = request.getParameter("paAcc");
		String paPass = request.getParameter("paPass");
		
		Director dir = new Director();
		DirectorDAO dirDAO = new DirectorDAO();
		
		Doctor doc = new Doctor();
		DoctorDAO docDAO = new DoctorDAO();
		
		Patients pat = new Patients();
		PatientsDAO patDAO = new PatientsDAO();
		
		if(action.equals("patients")) {
			pat = patDAO.checkLoginPatients(paAcc, paPass);
			if(pat!=null) {
				request.setAttribute("paAcc", paAcc);
				request.setAttribute("paPass", paPass);
				request.getRequestDispatcher("Patients.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Login fail !");
				request.getRequestDispatcher("PatientsLogin.jsp").forward(request, response);
			}
			
		} else if(action.equals("doctor")) {
			doc = docDAO.checkLoginDoctor(doAcc, doPass);
			if(doc!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("doc", doc);
				
				request.getRequestDispatcher("Doctor.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Login fail !");
				request.getRequestDispatcher("DoctorLogin.jsp").forward(request, response);
			}
		} else if(action.equals("director")) {
			dir = dirDAO.checkLoginDirector(diAcc, diPass);
			Director di = dirDAO.getDirector();
			if(dir!=null) {
				request.setAttribute("di", di);
				request.setAttribute("diAcc", diAcc);
				request.setAttribute("diPass", diPass);
				request.getRequestDispatcher("Director.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Login fail !");
				request.getRequestDispatcher("DirectorLogin.jsp").forward(request, response);
			}
		}
	}

}
