package testing;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowReSize {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https:\\www.facebook.com");
		Thread.sleep(5000);
		//Maximize browser window
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//get size of browser window
		int w = driver.manage().window().getSize().getWidth();
		int h = driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		Thread.sleep(5000);
		//change size of browser window
		Dimension d = new Dimension(530,350); // width & height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//get position of browser window
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		Thread.sleep(5000);
		//change position of browser window
		Point p = new Point(320,523); //x,y
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//close site
		driver.close();
		

	}

}
