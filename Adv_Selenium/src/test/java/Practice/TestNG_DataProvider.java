package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider {

	@Test(dataProvider="dataprovider_bookTicketTest")
	public  void bookTickets(String src, String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest+"");
	}
	
	@DataProvider
	public Object[][] dataprovider_bookTicketTest()
	{
		Object[][] obj= new Object[2][2];
		obj[0][0]="banglaore";
		obj[0][1]="goa";
		obj[1][0]="banglore";
		obj[1][1]="Mumbai";
		return obj;
	}
	
}
