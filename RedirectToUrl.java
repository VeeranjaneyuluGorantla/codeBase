package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedirectToUrl {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.mindqsystems.com/");
		Thread.sleep(5000);
		// Maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// goto another site
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(5000);
		// re direct to previous site
		driver.navigate().back();
		Thread.sleep(5000);
		// goto fb site
		driver.navigate().forward();
		Thread.sleep(5000);
		// refresh the site
		driver.navigate().refresh();
		Thread.sleep(5000);
		// close site
		driver.close();

	}

}
