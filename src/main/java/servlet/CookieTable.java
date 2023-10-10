package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTable
 */
@WebServlet("/CookieTable")
public class CookieTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTable() {
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
				"Transitional//EN\">\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<style>\r\n"
				+ "table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>";
		  Cookie[] cookies = request.getCookies();
	        Cookie  persistent1 = null,
	                persistent2 = null,
	                session1 = null,
	                session2 = null;

	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("persistent1")) {
	                persistent1 = cookie;
	               
	            } else if (cookie.getName().equals("persistent2")) {
	                persistent2 = cookie;
	                
	            } else if (cookie.getName().equals("session1")) {
	                session1 = cookie;
	            } else if (cookie.getName().equals("session2")) {
	                session2 = cookie;
	            }
	        }

	        if (persistent1 == null) {
	            persistent1 = new Cookie("persistent1", "yes");
	            persistent1.setMaxAge(60 * 3);
	            response.addCookie(persistent1);
	        }
	        if (persistent2 == null) {
	            persistent2 = new Cookie("persistent2", "yes");
	            persistent2.setMaxAge(60 * 3);
	            response.addCookie(persistent2);
	        }
	        if (session1 == null) {
	            session1 = new Cookie("session1", "yes");
	            response.addCookie(session1);
	        }
	        if (session2 == null) {
	            session2 = new Cookie("session2", "yes");
	            response.addCookie(session2);
	        }
	        
	        cookies = request.getCookies();

	       
		
		if (cookies.length == 0) {
		out.println("<p>No cookies</p>");
		} else {
			out.println(docType + "<table>"
					+ "<TR>" 
					+ "<TH>" + "nume cookie" + "</TH>"
							+ "<TH>" + "valoare cookie" + "</TH>"
									+ "</TR>");
			
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("accessCount")) {
				cookie.setMaxAge(0);
			} else {
		out.println
		(" <TR><TD>" + cookie.getName() + "</TD> " +
			" <TD>" + cookie.getValue() + "</TD></TR>");
				}}
		out.println("</table>"); 
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
