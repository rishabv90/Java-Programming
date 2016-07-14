package jdbcdemo;

import java.sql.*;


public class DriverUsingPreparedStatements {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		PreparedStatement myStat = null; //for prepared statements.
		ResultSet myRes = null; //result set
		int i = 0;//counter
		
		try 
		{
			//1) get a connection to database
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "@football123");
			
			//2) Create a statement 
			myStat = myCon.prepareStatement("select email from employee where salary > ? and department = ?");
			
			//3)parameter for prepare statements.
			myStat.setDouble(1, 90);
			myStat.setString(2, "ENGR");
			
			
			//4) execute SQL query 
			myRes = myStat.executeQuery();
			
			//4) Process result set.
			while(myRes.next())
			{
				i++;
				System.out.println(myRes.getString("email"));//myRes.getString("first_name")+ " " + myRes.getString("last_name") );
			}
			System.out.println("Total number of people in above condition = " + i);
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		
	}

}
