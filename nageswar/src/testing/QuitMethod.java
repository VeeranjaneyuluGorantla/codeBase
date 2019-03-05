package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitMethod {

	public static void main(String[] args) throws InterruptedException {
		
		// launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://movierulz4.desi");
		driver.findElement(By.xpath("//div[@id='wp-display-inn']//article[@id='post-35530']//div[@class='title']//h2[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@href='https://openload.co/embed/5TnZw-AgojY/']")).click();
		Thread.sleep(5000);
		// we can use quit() to close active browser window along with related browser windows or tabs
		//driver.quit();
	}

}
