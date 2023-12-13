package Practice;

import org.testng.annotations.Test;

public class TestNG_Enabled_True_False {
	@Test
	public void createProduct()
	{
		System.out.println("Created Product");
	}
	
	@Test(enabled=false)
	public void modifyProduct()
	{
		System.out.println("Modified Product");
	}
	
	@Test
	public void deleteProduct()
	{
		System.out.println("Deleted Product");
	}

}
