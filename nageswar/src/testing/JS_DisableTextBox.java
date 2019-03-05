package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_DisableTextBox {

	public static void main(String[] args) throws InterruptedException {
		// Launch Site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		JavascriptExecutor js=driver;
		WebElement e=driver.findElement(By.name("q"));
		js.executeScript("arguments[0].setAttribute('disabled','true');", e);
		Thread.sleep(5000);
		js.executeScript("arguments[0].removeAttribute('disabled');", e);
		Thread.sleep(5000);

	}

}
