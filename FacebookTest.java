package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTest {

	public static void main(String[] args) throws InterruptedException {
     
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys("veeranjaneyulu");
		driver.findElement(By.name("password")).sendKeys("gorantla");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		driver.close();
		
	}

}
