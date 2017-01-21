package org.smart4j.business.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.business.CustomerService;
import org.smart4j.model.Customer;

public class CustomerServiceTest {
	private final CustomerService customerService = new CustomerService();

	public void CustomerServiceTest(){
	}
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void getCustomerTest(){
		Customer c = customerService.getCustomer(1);
		Assert.assertNotNull(c);
	}
	
	@Test
	public void getCustomerListTest(){
		List<Customer> list = customerService.getCustomerList();
		Assert.assertEquals(2, list.size());
	}
	@Test
	public void createCustomerTest(){
		Customer c = new Customer();
		c.setContact("");
		c.setEmail("");
		c.setName("");
		c.setRemark("");
		c.setTelephone("");
		c.setId(3);
		boolean result = customerService.createCustomer(c);
		Assert.assertEquals(true, result);
	}
	@Test
	public void updateCustomerTest(){
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("name", "xianming");
		long id = 1;
		Boolean result = customerService.updateCustomer(id, m);
		Assert.assertEquals(true, result);
	}
	@Test
	public void deleteCustomerTest(){
		long id = 1;
		Boolean result = customerService.delCustomer(id);
		Assert.assertEquals(true, result);
	}
	
	
	@After
	public void destroy(){
		
	}

}
