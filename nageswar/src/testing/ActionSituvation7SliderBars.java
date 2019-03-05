package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSituvation7SliderBars {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		Thread.sleep(5000);
		//Horizontal slider
		driver.switchTo().frame(0);
		WebElement e1 = driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions a = new Actions(driver);
		a.dragAndDropBy(e1, 150, 0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1, -100, 0).build().perform();
		Thread.sleep(5000);
		//Vertical slider
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Vertical slider")).click();;
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		WebElement e2 = driver.findElement(By.xpath("//*[@id='slider-vertical']/span"));
		a.dragAndDropBy(e2, 0, 135).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e2, 0, -200).build().perform();
		Thread.sleep(5000);
		//close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
