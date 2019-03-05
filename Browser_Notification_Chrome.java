package testing;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser_Notification_Chrome {

	public static void main(String[] args) {
		// Launch site
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver(o);
		driver.get("https://in.bookmyshow.com/");

	}

}
