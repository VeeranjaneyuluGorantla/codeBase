package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWait2 {

	public static void main(String[] args) {
		// Launc site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx?skin=BlackMetroTouch");
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='rcMainTable']/tbody")));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("11"));
		//wait for loading completion
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		//click clear selected dates button
		driver.findElement(By.xpath("//*[@type='submit']/span")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		//close site
		driver.close();

	}

}
