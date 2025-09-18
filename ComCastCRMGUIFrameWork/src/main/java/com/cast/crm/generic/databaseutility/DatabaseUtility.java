package com.cast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	Connection con = null;

	public void getDatabaseConnection(String url, String username, String password) {

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {

		}
	}


	public void getDatabaseConnection() {

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
		} catch (Exception e) {

		}
	}

	//close connection
	public void closeDatabaseConnection() {
		try {
			con.close();
		} catch (Exception e) {

		}
	}

	//select query
	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {

		}

		return result;

	}

	//non select query
	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {

		}

		return result;

	}

}