package Practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli_Execution {

	

	public static void main(String[] args) throws Throwable  {
		Screen src= new Screen();
		//Pattern p= new Pattern("C:\\Users\\dell\\OneDrive\\Pictures\\Screenshots\\MiniBar.png");
		//src.click(p);
		
		Pattern p1= new Pattern("C:\\\\Users\\\\dell\\\\OneDrive\\\\Pictures\\\\Screenshots\\GoogleIcon.png");
        src.click(p1);
        
        Thread.sleep(2000);
        Pattern p2= new Pattern("C:\\\\Users\\\\dell\\\\OneDrive\\\\Pictures\\\\Screenshots\\AppsIcon.png");
        src.click(p2);
        
        Thread.sleep(2000);
        Pattern p3= new Pattern("C:\\\\Users\\\\dell\\\\OneDrive\\\\Pictures\\\\Screenshots\\Youtube.png");
        src.click(p3);
        
        Thread.sleep(2000);
        Pattern p7= new Pattern("C:\\\\Users\\\\dell\\\\OneDrive\\\\Pictures\\\\Screenshots\\CrossButton.png");
        src.click(p7);
        
        Thread.sleep(2000);
        Pattern p4= new Pattern("C:\\\\Users\\\\dell\\\\OneDrive\\\\Pictures\\\\Screenshots\\SearchBar.png");
        src.click(p4);
        
        Thread.sleep(2000);
        src.type("Paint");
        
        Thread.sleep(2000);
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        Pattern p5= new Pattern("C:\\\\Users\\\\dell\\\\OneDrive\\\\Pictures\\\\Screenshots\\WriteMode.png");
        src.click(p5);
        Thread.sleep(2000);
        Pattern p6 = new Pattern("C:\\\\Users\\\\dell\\\\OneDrive\\\\Pictures\\\\Screenshots\\PaintPage.png");
        src.click(p6);
        src.type("Shivani");
	}

}
