package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindXpath2 {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		//Maximize window size
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//get count of columns in 3rd row in 4th table
		List<WebElement> td = driver.findElements(By.xpath("(//table)[4]/tbody/tr[3]/td"));
		System.out.println(td.size());
		//close site
		driver.close();

	}

}
