package com.jdb.php.myadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class ApexConnectJDBC {

	public static void main(String[] args) throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = null;
			/*
			 * Server: sql6.freemysqlhosting.net Name: sql6121862 Username:
			 * sql6121862 Password: 6ijPFV7YDu Port number: 3306
			 */
			connection = DriverManager.
					getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6121862", "sql6121862",
					"6ijPFV7YDu");
			System.out.println("DB connecting fine :) ");
			System.out.println("--");

			String sqlFetch = "SELECT * FROM AddressBook LIMIT 4";

			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery(sqlFetch);
			System.out.println(" Does this print ?" + sqlFetch);
			System.out.println();
			int count = 0;

			while (result.next()) {
				String address = result.getString("Address");
				System.out.println("*****");
				System.out.println();
				System.out.println(" Residence is @ -->" + address);
				System.out.println();
				System.out.println("*****");

				count++;
			}
			System.out.println("Total records are ----"+count);
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.print("Could not connect to DB - Error:");
		}

	}

}
