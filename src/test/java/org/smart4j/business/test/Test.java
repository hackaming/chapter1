package org.smart4j.business.test;

import java.io.IOException;
import java.util.List;

import org.smart4j.business.CustomerService;
import org.smart4j.model.Customer;

public class Test {
	public static void main(String[] argv) throws IOException{
		CustomerService cs = new CustomerService();
		List<Customer>list = cs.getCustomerList();
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i).getName());
		}
	}
}
