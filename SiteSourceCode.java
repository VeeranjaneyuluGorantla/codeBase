package testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class SiteSourceCode {

	public static void main(String[] args) {
		// lanch browser 
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		//we can use getPageSource() to get source code of active browser window page
		String x = driver.getPageSource();
		System.out.println(x);

	}

}
