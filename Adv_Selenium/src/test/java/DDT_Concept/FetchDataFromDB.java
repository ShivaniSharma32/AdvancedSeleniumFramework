package DDT_Concept;

import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.ResultSet;


public class FetchDataFromDB {
	
	public static void main(String[] args) throws Throwable{
	
	Driver driverRef= new Driver();// Driver coming from Mysql, It is considered as JDBC driver
	
	DriverManager.registerDriver(driverRef);// Registered the driver in DriverManager.../
 /*DriverManager is a static class in the java and component of JdbcAPI and also a memeber of the java.sql.package.
	It acts as an Interface between users and drivers. It keeps track of the drivers that are avilable and handles establishing
	a connection between database and appropriate driver.*/
	
	/* Connect the driver (which is registered in drivermanager) to the Database and give the 
     standard mysqlPath with databaseName, username, password and stored is the Connection type variable*/
	// Also Connection is the Interface
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","ShivaniSharma","Root@1234");

//Call the createStatement abstract method of Connection Interface to create the statement and stored in Statement type variable
Statement state = conn.createStatement();//create Statement sending SQL statements to the database.
//Statement is the interface.

// Write the query and stored in String type variable
String query ="Select * from qspiders";

// you can call the execute/updateQuery method by using statement refvariable and pass the refvariable where query is stored.
ResultSet result = state.executeQuery(query);
//Result set is an Object that represents a set of data returned from a data source, usually as the result of a query. 

//Loop is used to execute all the query and next is used to check whether data is present or not.
while(result.next()) {
	
	System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
}
	
// to disconnect the database	
conn.close();	
	
	
}	
	

}
