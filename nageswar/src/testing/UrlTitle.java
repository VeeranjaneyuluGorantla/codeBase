package testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class UrlTitle {

	public static void main(String[] args) {
		// lanch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		// we can use the getTitle() to get title of the active browser window
		String x = driver.getTitle();
		System.out.println(x);
	}

}
