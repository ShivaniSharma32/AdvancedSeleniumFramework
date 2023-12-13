package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	public String getKeyAndValue(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleniumCommonData.properties");
		
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
