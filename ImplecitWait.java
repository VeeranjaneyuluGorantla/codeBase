package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplecitWait {

	public static void main(String[] args) throws InterruptedException {
		//open browser
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//launch site
		driver.get("https:\\www.gmail.com");
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		driver.findElement(By.name("identifier")).sendKeys("veeranjaneyulu.2346");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("veerusiri");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		//close site
		driver.close();

	}

}
