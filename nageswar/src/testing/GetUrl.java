package testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetUrl {

	public static void main(String[] args) {
		// launch Browser
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.way2sms.com");
		String x = driver.getCurrentUrl();
		System.out.println(x);
		if(x.contains("https"))
		{
			System.out.println("site is secured");
		}else {
			System.out.println("site is not secured");
		}

	}

}
