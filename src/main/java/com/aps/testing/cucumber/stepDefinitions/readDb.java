package com.aps.testing.cucumber.stepDefinitions;

import java.sql.*;

public class readDb {
	static ResultSet rs;
	
	static String dbFirstName;
	static String dbLastName;
	static String dbNickName;
	static int dbSalary;
	public static void main(String[] args) throws Exception {
		try {
			//Create our mysql db connection
			String myDriver="org.gjt.mm.mysql.Driver";
			String myUrl="jdbc:mysql://localhost/3306/company";
			Class.forName(myDriver);
			Connection conn =DriverManager.getConnection(myUrl,"root","admin321");
			
			//Select query
			String query="select * from staff;";
			
			//Create the java statement
			Statement st=conn.createStatement();
			
			//Execute the query and get a result set
			rs=st.executeQuery(query);
			System.out.println(rs);
			//Iterate through resultSet
			//try {
				while(rs.next()) {
					dbFirstName=rs.getString("firstName");
					dbLastName=rs.getString("lastName");
					dbNickName=rs.getString("nickName");
					dbSalary=rs.getInt("salary");
					System.out.format("%s, %s, %s, %s\n", dbFirstName,dbLastName, dbNickName,dbSalary);
					
					
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
		}
		
	} catch (SQLException e) {
		System.err.println("Got an exception.");
		System.err.println(e.getMessage());
	    System.out.println("SQLState: " + e.getSQLState());
	    System.out.println("VendorError: " + e.getErrorCode());
	}

	}

}
