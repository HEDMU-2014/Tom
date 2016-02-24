package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Greeting
 */
@WebServlet("/Greeting")
public class Greeting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setBufferSize(8192);
		try (PrintWriter out = response.getWriter()) {
			out.println(printDefaultPage());
			out.println("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			out.println(printDefaultPage());
			String username = request.getParameter("username");
			if (username != null && username.length() > 0) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Response");
				if (dispatcher != null) {
					dispatcher.include(request, response);
//					dispatcher.forward(request, response);
//					response.sendRedirect("Response");
					
				}
			}
			out.println("</body></html>");
		}
	}
	
	private String printDefaultPage() {
		return  "<html lang=\"en\">" + "<head><title>Servlet Hello</title></head>"
				+ "<body bgcolor=\"#ffffff\">" + "<img src=\"resource\\images\\duke.waving.gif\" "
				+ "alt=\"Duke waving his hand\">" + "<form method=\"post\">"
				+ "<h2>Hello, my name is Duke. What's yours?</h2>" + "<input title=\"My name is: \"type=\"text\" "
				+ "name=\"username\" size=\"25\">" + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
				+ "<input type=\"reset\" value=\"Reset\">" + "</form>";
	}

}