package quest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import quest.context.Singleton;

@WebListener
public class LaunchServ implements ServletContextListener {

 
    public void contextDestroyed(ServletContextEvent sce)  { 
     
    	Singleton.getInstance().getEmf().close();
    }
    
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Singleton.getInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
}
