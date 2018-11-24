

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.*;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/login")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
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
		Database userdb = (Database)request.getServletContext().getAttribute("userdb");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertable = request.getServletContext().getInitParameter("usertable");
		String sql = "select * from " + usertable + " where username = \'" + username + "\' and password = \'" + password + "\';";
		System.out.println(sql);
		String pref="",sex="";
		try {
			ResultSet rSet = userdb.runQuery(sql);
			if(!rSet.next()) {
				request.setAttribute("loginerror", "true");
				request.getRequestDispatcher("/loginpage.jsp").forward(request, response);
				return;
			}
			else {
				rSet = userdb.runQuery(sql);
				pref="";
				sex="";
				while(rSet.next()) {
					sex = rSet.getString(4);
					pref = rSet.getString(5);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<Product> discountedProducts = new ArrayList<>();
		ArrayList<Product> newProducts = new ArrayList<>();
		
		String itemtable = request.getServletContext().getInitParameter("itemtable");
		String sql1 = "select * from " + itemtable + " where productType=\'Discounted\' and forSex=\'" + sex +"\';";
		String sql2 = "select * from " + itemtable + " where productType=\'New Arrival\' and forSex=\'" + sex +"\';";
		System.out.println(sql1);
		System.out.println(sql2);
		
		try {
		ResultSet disRes = userdb.runQuery(sql1);
		System.out.println("discounted::");
		while(disRes.next()) {
			Product product = new Product(disRes.getString(1),disRes.getString(2),disRes.getString(3),disRes.getString(4),disRes.getString(5),disRes.getString(6));
			System.out.println(product);
			discountedProducts.add(product);
		}
		System.out.println("new ::");
		ResultSet newRes = userdb.runQuery(sql2);
		while(newRes.next()) {
			Product product = new Product(newRes.getString(1),newRes.getString(2),newRes.getString(3),newRes.getString(4),newRes.getString(5),newRes.getString(6));
			System.out.println(product);
			newProducts.add(product);
		}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		ArrayList<Product> productsChoiceList = new ArrayList<>();
		if(pref.equals("new_pref")) {
			productsChoiceList.addAll(newProducts);
			productsChoiceList.addAll(discountedProducts);
		}
		else {
			productsChoiceList.addAll(discountedProducts);
			productsChoiceList.addAll(newProducts);
		}
				
		request.setAttribute("productlist", productsChoiceList);
		request.getRequestDispatcher("productpage.jsp").forward(request, response);
	}

}
