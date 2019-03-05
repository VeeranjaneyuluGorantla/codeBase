package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImgXpath {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(5000);
		//Maximize window
		driver.manage().window().maximize();
		//get count of images in 2nd column in 3rd row in 4th table
		List<WebElement> l = driver.findElements(By.xpath("(//table)[4]/tbody/tr[3]/td[2]/img"));
		System.out.println(l.size());
		Thread.sleep(5000);
		//colse site
		driver.close();

	}

}
