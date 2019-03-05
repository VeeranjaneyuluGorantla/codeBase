package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CssSelectors {

	public static void main(String[] args) throws InterruptedException {
		// launch site
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(o);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		driver.findElement(By.cssSelector("input#email")).sendKeys("veeranjaneyulu.2346@gmail.com");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("veerusiri");
		driver.findElement(By.cssSelector("input[type=submit]")).click();
		driver.findElement(By.cssSelector("div#userNavigationLabel")).click();;
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']//a[@class='_54nc']//span//span[@class='_54nh']")).click();

	}

}
