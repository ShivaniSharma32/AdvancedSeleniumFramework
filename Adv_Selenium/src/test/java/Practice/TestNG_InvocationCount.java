package Practice;

import org.testng.annotations.Test;

public class TestNG_InvocationCount {

    @Test
	public void createProduct()
	{
		System.out.println("Created Product");
	}
	
	@Test(invocationCount=3)
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
