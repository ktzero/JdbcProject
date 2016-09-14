package ssa;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Mainline {
	
	static Connection myconn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try{
			//1. Load properties file
			Properties prop = new Properties();
			
			prop.load(new FileInputStream("demo.properties"));
			String user = prop.getProperty("user");
			String pass = prop.getProperty("password");
			String url = prop.getProperty("dburl");
			
			myconn = DriverManager.getConnection(url, user, pass);
			stmt = myconn.createStatement();
			insert("George", "Washington", 1600, 4.0, 8);
			rs = stmt.executeQuery("select *"
					+ " from student where last_name='Washington'");
			rs.next();
			print();
			
			
			stmt.executeUpdate("update student set gpa=3.5");
			stmt.executeUpdate("update student set sat=1450");
			stmt.executeUpdate("update student set major_id=1");
			
			rs = stmt.executeQuery("select *"
					+ " from student where last_name='Washington'");
			rs.next();
			print();
			
			
			delete("Washington",1450);
			
			rs = stmt.executeQuery("select *"
					+ " from student where last_name='Washington'");
			if(!rs.next())
				System.out.println("This student does not exist");
			else
				print();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(myconn != null)
				myconn.close();
			if(stmt != null)
				stmt.close();
			if(rs != null)
				rs.close();
		}
	}
	
	public static void insert(String fName, String lName, int sat, double gpa, int major) throws SQLException
	{
		stmt.executeUpdate("insert into student(first_name, last_name, sat, gpa, major_id) values('" +
				fName + "', '" + lName + "', " + sat + ", " + gpa + ", " + major + ")");
	}
	public static void delete(String lName, int sat) throws SQLException
	{
		stmt.executeUpdate("delete from student where last_name ='" 
				+ lName + "' and sat =" + sat);
	}
	
	public static void print() throws SQLException
	{
		System.out.println("First Name                     Last Name                      Sat Score  GPA    Major");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf("%-30s %-30s %-10s %-8s %s\n\n", rs.getString("first_name"), rs.getString("last_name"), 
				rs.getString("sat"), rs.getString("gpa") , rs.getString("major_id"));
	}
	
	public static void backup()
	{
		
	}

}
