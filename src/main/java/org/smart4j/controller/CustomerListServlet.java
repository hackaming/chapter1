package org.smart4j.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.smart4j.business.CustomerService;
import org.smart4j.model.Customer;

@WebServlet("/customerlist")
public class CustomerListServlet extends HttpServlet{
	private CustomerService cs;
	@Override
	public void init() throws ServletException {
		this.cs = new CustomerService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Customer> list;
		list = cs.getCustomerList();
		req.setAttribute("CustomerList", list);
		req.getRequestDispatcher("/WEB-INF/jsp/customer/customer_list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
