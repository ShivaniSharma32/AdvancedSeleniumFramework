package Generic_Utilities;

import java.util.Random;

public class Java_Utility {

	public int getRandomNum()
	{
         Random rc= new Random();
         int ranNum = rc.nextInt(1000);
         return ranNum;
	}

}
