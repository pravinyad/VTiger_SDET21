package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB_NON_Select {
	public static void main(String[] args) throws SQLException {
		// step1: register/load the MySql database
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				// step2: get connect to database
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
				
				// step3: create sql statement
				Statement stat=con.createStatement();
				String Query="insert into students_info(regno,firstname,middlename,lastname) values('10','jam','gowda','bassan')";
				
				// step4: execute statement query
				int result=stat.executeUpdate(Query);
				
				if(result==1) {
					System.out.println("user is created");
					
				}else {
					System.out.println("user is not created");
				}
				
				// step5: close the connection
				con.close();
	}

}
