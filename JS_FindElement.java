package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_FindElement {

	public static void main(String[] args) throws Exception{
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		//click on an element
		JavascriptExecutor js=driver;
		//js.executeScript("document.getElementById('lst-ib').value='mindq';");
		Thread.sleep(5000);
		WebElement e = driver.findElement(By.name("q"));
	    js.executeScript("arguments[0].value='mindq';",e);
	    Thread.sleep(5000);
	    js.executeScript("arguments[0].click();",e);
	   
		

	}

}
