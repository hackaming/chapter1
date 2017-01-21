package org.smart4j.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.util.PropsUtil;

public final class DBHelper {
	private static final String DRIVER;
	private static final String URL;
	private static final String USER;
	private static final String PASSWORD;
	private static final Logger logger = LoggerFactory.getLogger(DBHelper.class);
	private static Connection conn = null;
	private static final QueryRunner QUERY_RUNNER = new QueryRunner();
	private static final ThreadLocal<Connection> CONNECTION_HOLDER=new ThreadLocal<Connection>();
	
	static {
		Properties prop = PropsUtil.loadProperties("DB.properties");
		DRIVER = prop.getProperty("jdbc.driver");
		URL = prop.getProperty("jdbc.url");
		USER = prop.getProperty("jdbc.user");
		PASSWORD = prop.getProperty("jdbc.password");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			logger.error("JDBC Driver initializing failed");
		}
	}

	public static Connection getConnection() {
		Connection conn = CONNECTION_HOLDER.get();
		if (null == conn){
			try {
				conn = DriverManager.getConnection(URL,USER,PASSWORD);
			} catch (SQLException e) {
				logger.error("Can't get connection with " + URL);
				throw new RuntimeException();
			}finally{
				CONNECTION_HOLDER.set(conn);				
			}
		}
		return conn;
	}

	public static void closeConnection() {
		conn = CONNECTION_HOLDER.get();
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("Can't close the connection");
				throw new RuntimeException();
			} finally{
				CONNECTION_HOLDER.remove();
			}
		}
	}

	public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
		List<T> entityList = null;
		try {
			conn = DBHelper.getConnection();
			entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
		} catch (SQLException e) {
			logger.error("SQL query error!");
			throw new RuntimeException();
		} finally {
			closeConnection();
		}
		return entityList;
	}
	
	public static <T> T queryEntity(Class<T> entityClass,String sql,Object...params){
		Connection con = CONNECTION_HOLDER.get();
		T entity;
		try{
			entity = QUERY_RUNNER.query(conn, sql,new BeanHandler<T>(entityClass),params);
		} catch(SQLException e){
			logger.error("Can't finish the query");
			throw new RuntimeException();
		}finally{
			closeConnection();
		}
		return entity;
	}
	public static List<Map<String,Object>> executeQuery(String sql,Object ... params){
		Connection conn = CONNECTION_HOLDER.get();
		List<Map<String,Object>> result;
		try{
			result = QUERY_RUNNER.query(sql, new MapListHandler(), params);
		} catch (SQLException e){
			logger.error("execute query error");
			throw new RuntimeException();
		}
		return result;
	}
	
	
}
