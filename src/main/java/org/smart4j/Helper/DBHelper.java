package org.smart4j.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.util.PropsUtil;

public final class DBHelper {
	private static final String DRIVER;
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final Logger logger = LoggerFactory.getLogger(DBHelper.class);
	private Connection conn = null;

	static {
		Properties prop = PropsUtil.loadProperties("DB.properties");
		DRIVER = prop.getProperty("jdbc.driver");
		URL = prop.getProperty("jdbc.url");
		USER = prop.getProperty("jdbc.user");
		PASSWORD = prop.getProperty("jdbc.password");
	}

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			logger.error("JDBC Driver initializing failed");
		}
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			logger.error("Can't get connection with " + URL);
		}
		return conn;
	}

	public static void closeConnection() {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("Can't close the connection");
			}
		}
	}

}
