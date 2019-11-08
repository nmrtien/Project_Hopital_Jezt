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
		
		String diAcc = request.getParameter("user");
		String diPass = request.getParameter("pass");
		String doAcc = request.getParameter("user");
		String doPass = request.getParameter("pass");
		String paAcc = request.getParameter("user");
		String paPass = request.getParameter("pass");
		
		Director dir = new Director();
		DirectorDAO diDAO = new DirectorDAO();
		
		Doctor doc = new Doctor();
		DoctorDAO doDAO = new DoctorDAO();
		
		Patients pat = new Patients();
		PatientsDAO paDAO = new PatientsDAO();
		
		
		pat = paDAO.checkLoginPatients(paAcc, paPass);
		doc = doDAO.checkLoginDoctor(doAcc, doPass);
		dir = diDAO.checkLoginDirector(diAcc, diPass);
		if(pat!=null && pat.getRollId()==3) {
			HttpSession session = request.getSession();
			session.setAttribute("pat", pat);
			request.getRequestDispatcher("Patients.jsp").forward(request, response);
		}
		else if(doc!=null && doc.getRollId()==2) {
			HttpSession session = request.getSession();
			session.setAttribute("doc", doc);
			request.getRequestDispatcher("Doctor.jsp").forward(request, response);
		}
		else if(dir!=null && dir.getRollId()==1) {
			HttpSession session = request.getSession();
			session.setAttribute("dir", dir);
			request.getRequestDispatcher("Director.jsp").forward(request, response);
		}
		else if(pat==null && doc==null && dir==null) {
			request.setAttribute("message", "Account not valid !");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
