package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Angular {

	public static void main(String[] args) {
		// Launch site
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://angularjs.org/");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='yourName']")));
		driver.findElement(By.xpath("//*[@ng-model='yourName']")).sendKeys("Veeru Gorantla");
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//*[contains(text(),'Hello')])[2]"), "Veeru Gorantla"));
		//close site
		driver.close();
		

	}

}
