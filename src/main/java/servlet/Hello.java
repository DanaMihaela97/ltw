package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
		
		boolean newbie = true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        if (cookie.getName().equals("repeatVisitor")) {
		            
		            String value = cookie.getValue();
		            if (value.equals("yes")) {
		            	newbie = false;
		            }
		           
		        }
		    }
		}
		String title;
		if (newbie) {
		Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
		returnVisitorCookie.setMaxAge(60); // 1 minute
		response.addCookie(returnVisitorCookie);
		title = "Bine ai venit prima data!";
		out.println(docType + "<html><body><h1>Mesajul din servletul 'Hello': </h1><p>" + title + "</p></body></html>");
		} else {
		title = "Bine ai revenit!";
		out.println(docType + "<html><body><h1>Mesajul din servletul 'Hello': </h1><p>" + title + "</p></body></html>");
		}
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
