package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonXpath {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		//maximize window size
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//get count of push buttons
		List<WebElement> l = driver.findElements(By.xpath("(//button)|(//input[@type='button'])"));
		System.out.println(l.size());
		Thread.sleep(5000);
		//close site
		driver.close();

	}

}
