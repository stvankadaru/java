package com.cart.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(
		
		urlPatterns = "/WelcomeServlet",
		initParams = {
			@WebInitParam(name="welcomeMessage" , value=" Welcome to Online Shopping!")
		}
		)
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String greet;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		greet = config.getInitParameter("welcomeMessage");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String storeName = context.getInitParameter("storeName");
		
		// cookie for user name 
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("txt1");
		String password = request.getParameter("txt2");
		                
		
		
		if (username.equals("Admin") && password.equals("admin123"))
		{
			
			Cookie userCookie = new Cookie("username" ,username );
			userCookie.setMaxAge(60*60); 
			response.addCookie(userCookie);
			
			Cookie[] cookies = request.getCookies();
			String uname = null;
//			if(cookies!=null)
//			{
//				for(Cookie co : cookies)
//				{
//					if("uname".equals(co.getName()))
//					uname = co.getValue();
//					
//				}
//			}
			response.getWriter().println("<h1> " + greet + " " +  uname + " " +  storeName + "</h1>");
			// If you want to dispatch the request to another html page or servlet
			response.getWriter().println("<a href='index.jsp'>Click here to shop </a>" );
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request, response);
		
		}
		else
		{
			
			pw.println("Bad Request");
		}
		
	}

}
