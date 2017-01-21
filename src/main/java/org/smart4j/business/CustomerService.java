package org.smart4j.business;

import java.util.List;
import java.util.Map;

import org.smart4j.model.Customer;
/**
 * 
 * @author xianming
 *
 */
public class CustomerService {
	/**
	 * 
	 * @return
	 */
	public List<Customer> getCustomerList(){
		return null;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomer(long id){
		return null;
	}
	/**
	 * 
	 * @param id
	 */
	public boolean delCustomer(long id){
		return false;
	}
	/**
	 * 
	 * @param customer
	 */
	public boolean updateCustomer(Customer customer){
		return false;
	}
	/**
	 * 
	 * @param id
	 * @param fileMap
	 */
	public boolean updateCustomer(long id,Map<String, Object> fileMap){
		return false;
	}
	public boolean createCustomer(Customer c){
		return false;
	}
	
}
