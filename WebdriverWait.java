package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWait {

	public static void main(String[] args) {
		// Launc site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		WebDriverWait w = new WebDriverWait(driver,10);//seconds
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='rcMainTable']/tbody")));
		//maximise browser and click and date
		driver.manage().window().maximize();
		driver.findElement(By.linkText("12")).click();
		//wait for loading completion
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		//close site
		driver.close();

	}

}
