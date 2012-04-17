package edu.utep.trustlab.services.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoaderListener;
import edu.utep.trustlab.toolkitOperators.util.*;
public class ContextListener implements ServletContextListener {

	private ContextLoaderListener springListener;
	
	public ContextListener(){
		springListener = new ContextLoaderListener();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		springListener.contextDestroyed(event);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		springListener.contextInitialized(event);
		ServletContext context = event.getServletContext();
		String serverURL = context.getInitParameter("server-url");
		
		FileUtils.setDataOutputDir("output/");
		FileUtils.setScripts("scripts/");
		FileUtils.setServerURL(serverURL);
	}
}
