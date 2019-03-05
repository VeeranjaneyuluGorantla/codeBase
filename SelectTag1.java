package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTag1 {

	public static void main(String[] args) throws InterruptedException {
		// Launc site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.name("cars"));
		Select s = new Select(e);
		if (s.isMultiple()) {
			System.out.println("Multi Select");
		} else {
			System.out.println("Single Select");
		}
		// close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
