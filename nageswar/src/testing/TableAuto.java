package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAuto {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		// login to gmail
		driver.findElement(By.name("identifier")).sendKeys("anjaneyulu.nodejs");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("veeru@123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		List<WebElement> rl = driver.findElements(By.xpath("(//table)[4]/tbody/tr"));
		int x = rl.size();
		System.out.println(x);
		Thread.sleep(5000);
		List<WebElement> cl = rl.get(0).findElements(By.tagName("td"));
		int y = cl.size();
		System.out.println(y);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account:')]/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		// close site
		driver.close();

	}

}
