package DDT_Concept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class InsertDataUsingDB {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef= new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","ShivaniSharma","Root@1234");
		
		Statement state = conn.createStatement();
	
		String query = "insert into qspiders(first_name,last_name,address)values('Ram','Sharma','Goa')";
		
		int result= state.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("Data is updated");
		}
		else
		{
			System.out.println("Data is not updated");
		}
		conn.close();
	}

}
