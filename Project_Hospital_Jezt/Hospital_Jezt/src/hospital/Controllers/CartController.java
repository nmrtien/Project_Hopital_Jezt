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

import hospital.Entities.Cart;
import hospital.Entities.Medicine;
import hospital.Entities.Patients;
import hospital.Models.MedicineDAO;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	
		Cart cart = new Cart();
		
		Patients pat = new Patients();
		
		Medicine med = new Medicine();
		
		MedicineDAO meDAO = new MedicineDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		int meId = Integer.parseInt(request.getParameter("meId"));
		//Get session from patients
		HttpSession session = request.getSession();
		
		
		
		if(action.equals("addToCart")) {
			//get Cart from session
			List<Cart> listCart = (List<Cart>)session.getAttribute("listCart"); 
			
			if(listCart==null) {
				//if patient doesn't have a cart
				//initialization object  list cart
				listCart = new ArrayList<>();
				//get medicine information from meId
				Medicine med = meDAO.getMedicineById(meId);
				//Initialization object cart
				cart = new Cart(1, med);
				//add into listcart
				listCart.add(cart);
			}else {
				//if patients have a cart
				boolean check = false;
				for (int i = 0; i < listCart.size(); i++) {
					if(listCart.get(i).getMed().getMeId()==meId) {
						//Medicini in listCart
						//Plus quantity
						listCart.get(i).setQuantity(listCart.get(i).getQuantity()+1);
						check = true;
						break;
					}
				} if(!check) {
					//if Medicine does'nt had in patients
					//get medicine information from meId
					Medicine med = meDAO.getMedicineById(meId);
					//Initialization object cart
					cart = new Cart(1, med);
					//add into listcart
					listCart.add(cart);
				}
			}
			//Add lisrtCart into Session
			session.setAttribute("listCart", listCart);
			//add total into session
			session.setAttribute("totalAmount",totalAmount(listCart));
			session.setAttribute("totalQuantity",totalQuantity(listCart));
			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected float totalAmount(List<Cart> listCart) {
		float totalAmount = 0;
		for (Cart cart : listCart) {
			totalAmount += cart.getQuantity()*cart.getMed().getMePrice();
		}
		return totalAmount;
	}
	
	protected int totalQuantity(List<Cart> listCart) {
		int totalQuantity = 0;
		for (Cart cart : listCart) {
			totalQuantity += cart.getQuantity();
		}
		return totalQuantity;
	}

}
