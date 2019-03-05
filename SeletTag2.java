package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeletTag2 {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.name("cars"));
		Select s = new Select(e);
		List<WebElement> l = s.getOptions();
		System.out.println(l.size());
		Thread.sleep(5000);
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getText());
		}
		// close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
