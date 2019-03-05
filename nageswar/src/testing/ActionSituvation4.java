package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSituvation4 {

	public static void main(String[] args) throws InterruptedException {
		// Launch Site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://api.jquery.com/dblclick/");
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		WebElement e = driver.findElement(By.xpath("//body/div[1]"));
		Actions a = new Actions(driver);
		a.doubleClick(e).build().perform();
		Thread.sleep(5000);
		//close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
