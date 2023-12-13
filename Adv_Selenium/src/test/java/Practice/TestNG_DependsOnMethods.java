package Practice;

import org.testng.annotations.Test;

public class TestNG_DependsOnMethods {
	
	@Test
	
	public void createProduct()
	{
		System.out.println("Created Product");
	}
	
	@Test(dependsOnMethods="createProduct")
	public void modifyProduct()
	{
		System.out.println("Modified Product");
	}
	
	@Test(dependsOnMethods="createProduct")
	public void deleteProduct()
	{
		System.out.println("Deleted Product");
	}

}
