package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDown_DivTag {

	public static void main(String[] args) throws Exception {
		// launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		// maximize window size
		driver.manage().window().maximize();
		// open drop-down (developed using <div>tag)
		WebElement e = driver.findElement(By.xpath("(//*[contains(@class,'ui selection dropdown')])[1]"));
		Actions a = new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		// get iteams and display
		List<WebElement> il = driver.findElements(By.xpath("(//*[contains(@class,'ui selection dropdown')])[1]/child::*[4]/div"));
		System.out.println("No: iteams is " + il.size());
		for (int i = 0; i < il.size(); i++) {
			
			System.out.println(il.get(i).getText());

		}
		a.click(il.get(0)).build().perform();
		Thread.sleep(5000);
		// close site
		driver.close();

	}

}
