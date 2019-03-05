package testing;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Browser_Notification_Firefox {

	public static void main(String[] args) {
		// Launch site
		FirefoxProfile f = new FirefoxProfile();
		f.setPreference("dom.webnotifications.enabled", false);
		System.setProperty("webdriver.gecko.driver", "D:\\batch241\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();//f is orgument
		driver.get("https://www.bookmyshow.com/");

	}

}
