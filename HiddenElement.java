package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenElement {

	public static void main(String[] args) {

		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		try {
			if (driver.findElement(By.xpath("//*[@type='password']")).isDisplayed()) {
				System.out.println("password display in page");
			} else {
				System.out.println("password not display");
			}
		} catch (Exception e) {
			System.out.println(e);

		}

		// close site
		driver.close();

	}

}
