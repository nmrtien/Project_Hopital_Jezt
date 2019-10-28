package hospital.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.Entities.Director;
import hospital.Entities.Doctor;
import hospital.Entities.Patient;
import hospital.Models.DirectorDAO;
import hospital.Models.DoctorDAO;
import hospital.Models.PatientDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		Patient pat = new Patient();
		PatientDAO patDAO = new PatientDAO();
		
		if(action.equals("patient")) {
			pat = patDAO.checkPatient(paAcc, paPass);
			if(pat!=null) {
				request.setAttribute("paAcc", paAcc);
				request.setAttribute("paPass", paPass);
				request.getRequestDispatcher("Patient.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Erorr.jsp").forward(request, response);
			}
			
		} else if(action.equals("doctor")) {
			doc = docDAO.checkDoctor(doAcc, doPass);
			if(doc!=null) {
				request.setAttribute("doAcc", doAcc);
				request.setAttribute("doPass", doPass);
				request.getRequestDispatcher("Doctor.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Erorr.jsp").forward(request, response);
			}
		} else if(action.equals("director")) {
			dir = dirDAO.checkDirector(diAcc, diPass);
			if(dir!=null) {
				request.setAttribute("diAcc", diAcc);
				request.setAttribute("diPass", diPass);
				request.getRequestDispatcher("Director.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Erorr.jsp").forward(request, response);
			}
		}
	}

}
