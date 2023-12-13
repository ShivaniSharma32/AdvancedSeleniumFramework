package Practice;

import org.testng.annotations.Test;

public class TestNG_Priority {

	@Test(priority=0)
	
	public void createProduct()
	{
		System.out.println("Product Created");
	}
	
	@Test(priority= 1)
	public void modifyProduct()
	{
		System.out.println("Product Modified");
	}
	
	@Test(priority =2)
	
	public void deleteProduct()
	{
		System.out.println("Product Deleted");
		
	}

}
