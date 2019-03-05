package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSituvation1 {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		WebElement e1 = driver.findElement(By.name("email"));
		WebElement e2 = driver.findElement(By.name("pass"));
		WebElement e3 = driver.findElement(By.xpath("//*[@type='submit'][1]"));
		Actions a = new Actions(driver);
		a.sendKeys(e1,"veeranjaneyulu.2346@gmail.com").build().perform();
		a.sendKeys(e2,"veerusiri").build().perform();
		a.click(e3).build().perform();
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
