package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSituvation6 {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/");
		//Right click on element
		WebElement e = driver.findElement(By.xpath("//*[text()='Download']"));
		Actions a = new Actions(driver);
		a.contextClick(e).build().perform();
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
