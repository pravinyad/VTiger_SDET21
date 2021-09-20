package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcUsingTryCatchBlock {
	public static void main(String[] args) throws SQLException {
		  Connection con=null;
		  try {
		// step1: register/load the MySql database
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				// step2: get connect to database
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
				
				// step3: create sql statement
				Statement stat=con.createStatement();
				String Query="insert into students_info(regno,firstname,middlename,lastname) values('10','jam','gowda','bassan')";
				
				// step4: execute statement query
				int result=stat.executeUpdate(Query);
			
		  	
				if(result==1) {
					System.out.println("user is created");
				}
		  }
				catch(Exception e) {
					System.err.println("user is not created====Fail");
				}finally {
					// step5: close the connection
					con.close();
				}
					
				
				
				
				
				
	}

}
