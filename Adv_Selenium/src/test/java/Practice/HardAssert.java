package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	@Test
	public void aTest()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, true);
		System.out.println("Step3");
	}

}
