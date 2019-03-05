package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindXpath1 {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		// maximum size
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// get count of rows in 2nd table in page
		List<WebElement> tl = driver.findElements(By.tagName("table"));
		int x = tl.size();
		System.out.println(x);
		WebElement tb = tl.get(1).findElement(By.tagName("tbody"));
		List<WebElement> tr = driver.findElements(By.tagName("tr"));
		System.out.println(tr.size());

		// Find the direct xpath
		/*
		 * List<WebElement> td = driver.findElements(By.xpath("(//table)[2]/tbody/tr"));
		  System.out.println(td.size());
		 */

		// close site
		driver.close();

	}

}
