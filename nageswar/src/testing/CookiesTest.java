package testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesTest {

	public static void main(String[] args) throws InterruptedException {
		// open browser
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// delete all cookies
		driver.manage().deleteAllCookies();
		// launch site
		driver.get("https:\\www.facebook.com");
		Thread.sleep(5000);
		// cookies testing
		if (driver.manage().getCookies().size() != 0) {
			System.out.println("Cookies Test passed");
		} else {
			System.out.println("Cookies Test Failed");
		}
		// close site
		driver.close();
	}

}
