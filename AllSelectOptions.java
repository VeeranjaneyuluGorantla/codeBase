package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AllSelectOptions {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		// maximize window
		driver.manage().window().maximize();
		// switchTo frame
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.name("cars"));
		Select s = new Select(e);
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).click(s.getOptions().get(1)).click(s.getOptions().get(2)).build().perform();
		Thread.sleep(5000);
		// display Selected iteams
		List<WebElement> l = s.getAllSelectedOptions();
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getText());
		}
		//close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
