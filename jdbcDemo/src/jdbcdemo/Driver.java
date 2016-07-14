package jdbcdemo;

import java.sql.*;


public class Driver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		try 
		{
			//1) get a connection to database
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "@football123");
			
			//2) Create a statement 
			Statement myStat = myCon.createStatement();
			
			
			//3) execute SQL query 
			//to get
			ResultSet myRes = myStat.executeQuery("select * from employee");
			//to store
			/*String sql = " Insert into employee " + " (id, last_name, first_name, email)" + " values('8','john' , 'Doe', 'jd@gmail.com') ";
			myStat.executeUpdate(sql);
			System.out.println("Insert Complete");
			*/
			//4) Process result set.
			while(myRes.next())
			{
				System.out.println(myRes.getString("last_name")+ " " + myRes.getString("first_name") );
			}
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		
	}

}
