package website.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HomeServlet extends HttpServlet
{
	/*
	@Override
	public void init(ServletConfig config) throws ServletException {
	   System.out.println("Initialising log4j");
	   String log4jLocation = config.getInitParameter("log4j-properties-location");

	   ServletContext sc = config.getServletContext();

	   if (log4jLocation == null) {
	      System.out.println("No log4j properites...");
	      BasicConfigurator.configure();
	   } else {
	      String webAppPath = sc.getRealPath("/");
	      String log4jProp = webAppPath + log4jLocation;
	      File output = new File(log4jProp);

	      if (output.exists()) {
	         System.out.println("Initialising log4j with: " + log4jProp);
	         PropertyConfigurator.configure(log4jProp);
	      } else {
	         System.out.println("Find not found (" + log4jProp + ").");
	         BasicConfigurator.configure();
	      }
	   }

	   super.init(config);
	}
	*/
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		PrintWriter writer = resp.getWriter();
		writer.println("<h!>Hello, World</h1>");
		logger.debug("HomeServlet.doGet()");
	}
	
}
