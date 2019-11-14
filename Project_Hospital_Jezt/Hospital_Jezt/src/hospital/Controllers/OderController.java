package hospital.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hospital.Entities.Oder;
import hospital.Entities.OderDetail;
import hospital.Models.OderDAO;
import hospital.Models.OderDetailDAO;

/**
 * Servlet implementation class OderController
 */
@WebServlet("/OderController")
public class OderController extends HttpServlet {
	
		Oder od = new Oder();
		
		OderDetail odd = new OderDetail();
		
		OderDAO odDAO = new OderDAO();
		
		OderDetailDAO oddDAO = new OderDetailDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("Pay")) {
			od = new Oder();
			od.setOdName(request.getParameter("odName"));
			od.setOdAddress(request.getParameter("odAddress"));
			od.setOdPhone(request.getParameter("odPhone"));
			boolean check = odDAO.inserOder(od);
			if(check) {
				int jezt = odDAO.getOderId();
				HttpSession session = request.getSession();
				session.setAttribute("jezt", jezt);
				session.setAttribute("od", od);
				request.getRequestDispatcher("SubmitCart.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
			}
		}
		
		else if(action.equals("Submit")) {
			odd = new OderDetail();
			odd.setOddMeName(request.getParameter("oddMeName"));
			odd.setOddMeQuantity(Integer.parseInt(request.getParameter("oddMeQuantity")));
			odd.setOddMePrice(Float.parseFloat(request.getParameter("oddMePrice")));
			odd.setOddAmount(Float.parseFloat(request.getParameter("oddAmount")));
			odd.setOdId(Integer.parseInt(request.getParameter("odId")));
			boolean check = oddDAO.inserOderDetail(odd);
			if(check) {
				request.getRequestDispatcher("SubmitCart.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}
		
		else if(action.equals("getAllOder")) {
			List<Oder> listOd = new ArrayList<>();
			listOd = odDAO.getAllOder();
			request.setAttribute("listOd", listOd);
			request.getRequestDispatcher("ListOder.jsp").forward(request, response);
		}
		
		else if(action.equals("Search")) {
			int odId = Integer.parseInt(request.getParameter("odId"));
			List<Oder> listOd = odDAO.searchOderById(odId);
			request.setAttribute("listOd", listOd);
			request.getRequestDispatcher("ListOder.jsp").forward(request, response);
		}
		
		else if(action.equals("delete")) {
			int odId = Integer.parseInt(request.getParameter("odId"));
			boolean check = odDAO.deleteOder(odId);
			if(check) {
				getAllOder(odDAO, request, response);
			}
			else {
				getAllOder(odDAO, request, response);
			}
		}
		
		else if(action.equals("getOderDetail")) {
			int odId = Integer.parseInt(request.getParameter("odId"));
			List<OderDetail> listOdd = oddDAO.getOderDetail(odId);
			request.setAttribute("listOdd", listOdd);
			request.getRequestDispatcher("OderDetail.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void getAllOder(OderDAO odDAO,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Oder> listOd = new ArrayList<>();
		listOd = odDAO.getAllOder();
		request.setAttribute("listOd", listOd);
		request.getRequestDispatcher("ListOder.jsp").forward(request, response);
	}

}
