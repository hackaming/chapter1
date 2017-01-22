package org.smart4j.Helper;

import java.io.IOException;

public class DBHelperTest {
	public static void main(String[] argv) throws IOException{
		DBHelper db = new DBHelper();
		db.getConnection();
		//CustomerServiceTest cst = new CustomerServiceTest();
		//cst.init();
		db.executeQuery("select * from customer");
	}
}
