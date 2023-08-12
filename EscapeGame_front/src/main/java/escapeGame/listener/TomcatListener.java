package escapeGame.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class TomcatListener implements ServletContextListener {

   
    
	 public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("Tomcat a start");
	    }
	 
	 
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Tomcat est close");
    }


   
	
}
