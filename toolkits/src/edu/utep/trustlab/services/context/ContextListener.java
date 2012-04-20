package edu.utep.trustlab.services.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.utep.trustlab.toolkitOperators.util.*;
public class ContextListener implements ServletContextListener {

	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String serverURL = context.getInitParameter("server-url");
		
		FileUtils.setDataOutputDir("output/");
		FileUtils.setScripts("scripts/");
		FileUtils.setServerURL(serverURL);
	}
}