package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {

	public static void main(String[] args) 
	{
		// getAttribute(), getText(), getCssValue()
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		// Get Attribute value
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		WebElement e1=driver.findElement(By.name("mobileNo"));
		String x=e1.getAttribute("id");
		System.out.println(x);
		// get text value and css property value
		WebElement e2=driver.findElement(By.xpath("(//*[text()='Forgot password'])[1]"));
		String y=e2.getText();
		System.out.println(y);
		String z=e2.getCssValue("color");
		System.out.println(z);
		// close site
		driver.close();

	}

}
