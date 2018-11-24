

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;

/**
 * Servlet implementation class RegistrationHandler
 */
// @WebServlet("/register")
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("inside init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	String getId(String uname, String pwd) {
	//	Random random = new Random();
		int randIndex = uname.length()/2;
		String id = "";
		for(int i=0;i<uname.length();i++) {
			id += uname.charAt((i+randIndex)%uname.length());
		}
		int r1 = pwd.length()/3;
		int r2 = (pwd.length()*2)/3;
		id += (int)pwd.charAt(r1) + (int)pwd.charAt(r2); 
		return id;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Database userdb = (Database)request.getServletContext().getAttribute("userdb");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userid = getId(username,password);
		String sex = request.getParameter("sex");
		String preference = request.getParameter("preference");
		String usertable = request.getServletContext().getInitParameter("usertable");
		String sql = "insert into " + usertable + " values (\'" + userid + "\',\'" +username+ "\',\'" + password + "\',\'" + sex +"\',\'" + preference + "\');";
		System.out.println(sql);
		try {
			userdb.executeUpdate(sql);
		} catch(MySQLIntegrityConstraintViolationException e) {
			request.setAttribute("regerror", "true");
			request.getRequestDispatcher("/registerpage.jsp").forward(request, response);
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("loginpage.jsp");
	}

}
