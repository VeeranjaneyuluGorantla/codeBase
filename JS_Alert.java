package testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class JS_Alert {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.mindqsystems.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.executeScript("window.alert('Hai veeru......');");
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
