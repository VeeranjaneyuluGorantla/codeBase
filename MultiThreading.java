package testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class MultiThreading extends Thread{
      public void run() {
    	  try {
    		  Thread.sleep(10000);
    		  Robot r = new Robot();
    		  StringSelection x = new StringSelection("veeru");
    		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
    		  r.keyPress(KeyEvent.VK_CONTROL);
    		  r.keyPress(KeyEvent.VK_V);
    		  r.keyRelease(KeyEvent.VK_V);
    		  r.keyRelease(KeyEvent.VK_CONTROL);
    		  Thread.sleep(5000);
    		  r.keyPress(KeyEvent.VK_TAB);
    		  r.keyRelease(KeyEvent.VK_TAB);
    		  Thread.sleep(5000);
    		  StringSelection y = new StringSelection("veeru123");
    		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y, null);
    		  r.keyPress(KeyEvent.VK_CONTROL);
    		  r.keyPress(KeyEvent.VK_V);
    		  r.keyRelease(KeyEvent.VK_V);
    		  r.keyRelease(KeyEvent.VK_CONTROL);
    		  Thread.sleep(5000);
    		  r.keyPress(KeyEvent.VK_TAB);
    		  r.keyRelease(KeyEvent.VK_TAB);
    		  Thread.sleep(5000);
    		  r.keyPress(KeyEvent.VK_ENTER);
    		  r.keyRelease(KeyEvent.VK_ENTER);
    	  }catch(Exception e) {
    		  System.out.println(e);
    	  }
      }
	public static void main(String[] args) {
		MultiThreading mt = new MultiThreading();
		mt.start();
		// Launch site
		System.setProperty("webdriver.chrome.driver", "F:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://eforms.agility.com");
		

	}

}
