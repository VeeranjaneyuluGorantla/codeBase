package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Text2_SelectBox {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		// all select droup-down
		Thread.sleep(5000);
		List<WebElement> l = driver.findElements(By.xpath("(//select)|(//input[@type='select'])"));
		System.out.println(l.size());
		WebElement e = driver.findElement(By.xpath("//*[contains(@class,'ui fluid dropdown selection multiple')]"));
		Actions a = new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		// get iteams and display
		List<WebElement> l1 = driver.findElements(By.xpath("//*[contains(@class,'menu transition visible')]/child::*"));
		System.out.println("No: iteams is " + l1.size());
		for (int i = 0; i < l1.size(); i++) {
			System.out.println(l1.get(i).getText());
		}
		// close site
		driver.close();

	}

}
