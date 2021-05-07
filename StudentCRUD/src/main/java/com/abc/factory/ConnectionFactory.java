package com.abc.factory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {
	
	private static Connection connection;
	
   static {
	   
	   try {
		   MysqlDataSource dataSource = new MysqlDataSource();
		  
		 Properties properties = new Properties();
		 properties.load(new FileInputStream("src/main/resources/connection.properties")); 
		 
		 String url=properties.getProperty("mysql.url");
		 String userID=properties.getProperty("mysql.user");
		 String pass=properties.getProperty("mysql.password");
		 
		 dataSource.setURL(url);
		 dataSource.setUser(userID);
		 dataSource.setPassword(pass);
		   
		 connection = dataSource.getConnection();
		   
		
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
	
	public static Connection getConnectionToDB() {
		return connection;
	}
	   
	   

}
