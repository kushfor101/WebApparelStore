

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletListener
 *
 */
@WebListener
public class MyServletListener implements ServletContextListener {


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub\
    	
    	ServletContext sc = event.getServletContext();
    	
    	String url = sc.getInitParameter("url");
    	String user_name = sc.getInitParameter("user_name");
    	String password = sc.getInitParameter("password");
    	String userdatabase = sc.getInitParameter("database");
    	String itemdatabase = sc.getInitParameter("itemdatabase");
    	Database userdb = new Database(url + userdatabase, user_name, password);
    	//Database itemdb = new Database(url + itemdatabase, user_name, password);
    	//System.out.println("in the listener!!");
    	sc.setAttribute("userdb", userdb);
    	//sc.setAttribute("itemdb", itemdb);
    	System.out.println("leaving listener");
    }
	
}
