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
		setServerURL(context);
	
		String serverBasePath = context.getInitParameter("server-base-path");
		setDataOutputDir(serverBasePath);
		setScriptsDir(serverBasePath);
	}
	
	private static void setDataOutputDir(String basePath){
		FileUtils.setDataOutputDir(basePath + "output/");
	}
	
	private static void setScriptsDir(String basePath){
		FileUtils.setScripts(basePath + "scripts/");
	
	}
	
	private static void setServerURL(ServletContext context){
		String serverURL = context.getInitParameter("server-url");
		FileUtils.setServerURL(serverURL);		
	}
}