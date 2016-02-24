package counter.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.ejb.CounterBeanLocal;

@WebServlet("/JNDICounter")
public class JNDICounter extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@EJB(lookup="java:global/test/test.ejb/CounterBean!test.ejb.CounterBean") CounterBeanLocal counter;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Count: " + counter.Count());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
