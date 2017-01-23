package org.smart4j.controller;

import org.smart4j.business.CustomerService;

@Controller
public class CustomerController {
	@Inject
	private CustomerService customerService;
	private int testIntforGitChange;
	
	@Action("get:/customer")
	public View index(Param param){
		List<Customer> customerList = customerService.getCustomerList();
		return new View("customer_list.jsp").addModel("customerList",customerList);
	}
	
	@Action("get:/customer_show")
	public View show(Param param){
		Long id = param.getLong("id");
		Customer customer = customerService.getCustomer(id);
		return new View("customer_show.jsp").addModel("customer",customer);
	}
	
	@Action("get:/customer_create")
	public View create(Param param){
		return new View("Customer_create.jsp");
	}
	@Action("post:/customer_create")
	public Data createSubmit(Param param){
		Map<String,Object> fieldMap = new param.getMap();
		boolean result = customerService.createCustomer(fieldMap);
		return new Data(result);
	}
	@Action("get:/customer_edit")
	public View edit(Param param){
		long id=param.getLong("id");
		Customer customer = customerService.getCustomer(id);
		return new View("customer_edit.jsp").addModel("customer",customer);
	}
	
	@Action("put:/customer_edit")
	public Data editSubmit(Param param){
		long id = param.getLong("id");
		Map<String,Object> fieldMap = param.getMap();
		boolean result = customerService.updateCustomer(id, fieldMap);
		return new Data(result);
	}
	@Action("delete:customer_delete")
	public Data delete(Param param){
		long id = param.getLong("id");
		boolean result = customerService.delCustomer(id);
		return new Data(result);
	}
}
