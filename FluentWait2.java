package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWait2 {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		driver.get("https://www.telerik.com/products/aspnet-ajax.aspx");
		FluentWait f = new FluentWait(driver).pollingEvery(5, TimeUnit.SECONDS).withTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='optanon-alert-box-button optanon-button-allow']/div/a")).click();
		driver.findElement(By.xpath("//*[@class='Chat']/div[2]/a/img")).click();

	}

}
