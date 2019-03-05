package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSituvation3 {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		// move mouse point to target element
		WebElement e1 = driver.findElement(By.xpath("//*[@id='container']/following::button[1]"));
		WebElement e2 = driver.findElement(By.xpath("//*[text()='Women']"));
		Actions a = new Actions(driver);
		a.click(e1);
		a.moveToElement(e2).build().perform();
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
