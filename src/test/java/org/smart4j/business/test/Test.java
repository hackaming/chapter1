package org.smart4j.business.test;

import java.io.IOException;

import org.smart4j.Helper.DBHelper;

public class Test {
	public static void main(String[] argv) throws IOException{
		DBHelper db = new DBHelper();
		CustomerServiceTest cst = new CustomerServiceTest();
		db.executeQuery("select * from customer");

	}

}
