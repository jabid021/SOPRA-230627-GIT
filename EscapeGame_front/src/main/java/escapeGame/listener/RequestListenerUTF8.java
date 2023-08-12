package escapeGame.listener;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class RequestListenerUTF8 implements ServletRequestListener {

   
    public void requestDestroyed(ServletRequestEvent sre)  { 
         
    }

	
    public void requestInitialized(ServletRequestEvent sre)  { 
    	try {
			sre.getServletRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }
	
}
