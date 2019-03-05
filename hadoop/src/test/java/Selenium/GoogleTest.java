package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("happest minds",Keys.ENTER);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='hb2Smf']")));
		Thread.sleep(5000);
		driver.close();

	}

}
