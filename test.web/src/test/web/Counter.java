package test.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.ejb.CounterBeanLocal;
import test.ejb.CounterSingletonBeanRemote;

@WebServlet("/Counter")
public class Counter extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@EJB
	CounterSingletonBeanRemote singleCounter;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CounterBeanLocal counter;
		HttpSession session = request.getSession();

		try {
			if (session.getAttribute("Counter") == null)
				session.setAttribute("Counter",
						new InitialContext().lookup("java:global/test/test.ejb/CounterBean!test.ejb.CounterBean"));

			counter = (CounterBeanLocal) session.getAttribute("Counter");
			response.getWriter().append("Count: " + counter.Count() + "\n");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		int sc = singleCounter.Count();
		response.getWriter().append("SingletonCount: " + sc);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}