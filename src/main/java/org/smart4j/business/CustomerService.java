package org.smart4j.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.Helper.DBHelper;
import org.smart4j.model.Customer;

/**
 * 
 * @author xianming
 *
 */
public class CustomerService {
	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

	/**
	 * 
	 * @return
	 */
	public List<Customer> getCustomerList() {
		String query = "Select * from customer";
		return DBHelper.queryEntityList(Customer.class,query);
	}

	/**
	 * 
	 * @return
	 */
	public List<Customer> getCustomerList1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList();
		conn = DBHelper.getConnection();
		String sql = "select * from customer";
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			logger.error("create prepared statement error");
		}
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setContact(rs.getString("contact"));
				c.setId(rs.getLong("id"));
				c.setEmail(rs.getString("email"));
				c.setName(rs.getString("name"));
				c.setTelephone(rs.getString("telephone"));
				c.setRemark(rs.getString("remark"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			logger.debug("Can't execute the sql");
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DBHelper.closeConnection();
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomer(long id) {
		String sql = "select * from Customer where id="+id;
		return DBHelper.queryEntity(Customer.class, sql);
	}

	/**
	 * 
	 * @param id
	 */
	public boolean delCustomer(long id) {
		return DBHelper.deleteEntity(Customer.class, id);
	}

	/**
	 * 
	 * @param customer
	 */
	public boolean updateCustomer(Customer customer) {
		return false;
	}

	/**
	 * 
	 * @param id
	 * @param fileMap
	 */
	public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
		return DBHelper.updateEntity(Customer.class, id, fieldMap);
	}

	public boolean createCustomer(Map<String,Object> fieldMap) {
		return DBHelper.insertEntity(Customer.class, fieldMap);
	}

}
