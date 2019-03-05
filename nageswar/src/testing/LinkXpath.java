package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkXpath {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		//Maximize window size
		driver.manage().window().maximize();
		//click on 2nd link in 4th column in 3rd row in 2nd table in page
		
		List<WebElement> l = driver.findElements(By.xpath("(//table)[2]/tbody/tr[3]/td[4]/a[2]"));
		System.out.println(l.size());
		Thread.sleep(5000);
		//close site
		driver.close();
	}

}
