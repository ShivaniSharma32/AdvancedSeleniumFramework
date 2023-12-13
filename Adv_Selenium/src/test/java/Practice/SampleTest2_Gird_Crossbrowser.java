package Practice;


import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.BaseClassForGrid;

class SampleTest2_Gird_Crossbrowser extends BaseClassForGrid {

		@Test
		public void m2Test(){
			
			driver.get("https://www.facebook.com/");
		}

	}



