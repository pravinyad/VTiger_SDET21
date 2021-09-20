package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB {
	public static void main(String[] args) throws SQLException {

		// step1: register/load the MySql database/database driver
		Driver driverRef = new Driver();// Driver is provided by database vendor so it get loaded as it provide
										// implementation to jdbc API
		DriverManager.registerDriver(driverRef);

		// step2: get connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

		// step3: create sql statement
		Statement stat = con.createStatement();
		String Query = "Select * from students_info";

		// step4: execute statement query
		ResultSet result = stat.executeQuery(Query);

		while (result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
					+ result.getString(4));
		}

		// step5: close the connection
		con.close();
	}

}
