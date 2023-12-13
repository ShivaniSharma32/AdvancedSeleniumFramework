package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {
	@Test
	public void a1Test()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert s= new SoftAssert();
		 s.assertEquals(true, false);
		
		System.out.println("Step3");
		 s.assertAll();
	}

}



