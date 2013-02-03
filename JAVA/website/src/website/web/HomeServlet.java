package website.web;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;



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
	
	private RequestDispatcher homeJsp;
	
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		//PrintWriter writer = resp.getWriter();
		//writer.println("<h!>Hello, World</h1>");
		//logger.debug("HomeServlet.doGet()");
		//req.setAttribute("message", "bye");
		//homeJsp.forward(req, resp);
		
		/* reading rss */
		logger.debug("Retriving yahoo news feed");
		URL url = new URL("http://rss.news.yahoo.com/rss/entertainment");
		SyndFeedInput syndInputFeed = new SyndFeedInput();
		SyndFeed syndFeed = null;
		XmlReader xmlReader = new XmlReader(url);
		try
		{
			syndFeed = syndInputFeed.build(xmlReader);
		}
		catch (IllegalArgumentException e)
		{
			logger.error("", e);
		}
		catch (FeedException e)
		{
			logger.error("", e);
		}
		
		logger.debug("Forwarding to home.jsp");
		req.setAttribute("SyndFeed", syndFeed);
		homeJsp.forward(req, resp);
		
	}
	
}
