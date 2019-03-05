package testing;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser {

	public static void main(String[] args) {
     
	System.setProperty("webdriver.gecko.driver", "D:\\batch241\\geckodriver.exe");
	FirefoxDriver driver = new FirefoxDriver();

	}

}
