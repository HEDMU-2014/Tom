package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter()) {
			out.println(printDefaultPage());
			out.println("</body></html>");
			request.setAttribute("test", null);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter()) {
			System.out.println("input=" + request.getParameter("input"));
			out.println(printDefaultPage());
			out.println(printTable(request));
			out.println("</body></html>");
		}
	}

	private String printTable(HttpServletRequest request) {
		return "<table style=\"width:50%; border=1px solid\">" + "<tr>" + "<td>Input</td>" + "<td>" + request.getParameter("input")
		+ "</td>" + "</tr>" + "</table>";
	}

	private String printDefaultPage() {
		return "<html lang=\"en\">" + "<head><title>Servlet Hello</title></head>" + "<body bgcolor=\"#ffffff\">"
				+ "<form method=\"post\">" + "<input title=\"input: \"type=\"text\" " + "name=\"input\" size=\"25\">"
				+ "<p></p>" + "<input type=\"submit\" value=\"Submit\">" + "<input type=\"reset\" value=\"Reset\">"
				+ "</form>";
	}

}
