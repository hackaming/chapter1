package org.smart4j.chapter1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String currentTime = dateformat.format(new Date());
		System.out.println("Current time string in servlet:"+currentTime);
		req.setAttribute("currentTime", currentTime);
		req.setAttribute("aa", "bb");
		System.out.println("in Servlet Get parameter name from URL"+req.getParameter("name"));
		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
