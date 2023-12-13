package Practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class TestNG_DataProvider_ByExcel {
	@Test(dataProvider="getdataproviderbyExcel")
	public  void bookTickets(String src, String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest+"");
	}
	
	@DataProvider
	public Object[][] getdataproviderbyExcel() throws IOException, Throwable
	{
		Excel_Utility e= new Excel_Utility();
		
		Object[][] value = e.getDataProvider("Sheet1");
		return value;
	}
	
}


