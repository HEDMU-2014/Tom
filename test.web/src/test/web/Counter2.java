package test.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.ejb.CounterBeanLocal;
import test.ejb.CounterSingletonBeanRemote;

@WebServlet("/Counter2")
public class Counter2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    @EJB CounterBeanLocal counter;
    @EJB CounterSingletonBeanRemote singleCounter;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int c = counter.Count();
		response.getWriter().append("Count2: " + c + "\n");

		int sc = singleCounter.Count();
		response.getWriter().append("SingletonCount2: " + sc);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}