package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSituvation5 {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//drag and drop
		driver.switchTo().frame(0);
		WebElement e1 = driver.findElement(By.id("draggable"));
		WebElement e2 = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(e1, e2).build().perform();
		Thread.sleep(5000);
		//close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
