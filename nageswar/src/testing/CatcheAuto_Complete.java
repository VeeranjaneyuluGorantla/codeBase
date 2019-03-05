package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CatcheAuto_Complete {

	public static void main(String[] args) throws Exception{
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		Thread.sleep(5000);
		//fill text box with data to get auto complete
		WebElement e = driver.findElement(By.name("q"));
		Actions a = new Actions(driver);
		a.sendKeys("kalam").build().perform();
		Thread.sleep(5000);
		//select 5th iteam in cache
		for(int i=1;i<6;i++) {
		a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
		}
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
