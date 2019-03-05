package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// open gmail
		driver.get("https://www.gmail.com");
		// login gmail
		driver.findElement(By.name("identifier")).sendKeys("anjaneyulu.nodejs");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("veeru@123");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		// click compose
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("to")).sendKeys("veeranjaneyulu.2346@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("subjectbox")).sendKeys("Wishes");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hi Veeru\nHow r u\nBye");
		driver.findElement(By.className("bBe")).click();
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		// close site
		driver.close();
	}

}
