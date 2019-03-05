package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleDroupDown {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		driver.manage().window().maximize();
		WebElement e = driver.findElement(By.name("nights"));
		Select s = new Select(e);
		// select item in single droup down list
		//s.selectByIndex(6);
		s.selectByVisibleText("12Nights+13Days");
		s.selectByValue("11Nights / 2Days");
		Thread.sleep(5000);
		// close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
