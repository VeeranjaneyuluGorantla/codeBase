package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesXpath {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com");
		driver.findElement(By.linkText("Checkboxradio")).click();
		//to frame 1
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//*[@class='ui-checkboxradio-icon-space'])[2]/preceding-sibling::*")).click();
		driver.findElement(By.xpath("(//*[@class='ui-checkboxradio-icon-space'])[7]/preceding-sibling::*")).click();
		driver.findElement(By.xpath("(//*[@class='ui-checkboxradio-icon-space'])[10]/preceding-sibling::*")).click();
		//back to page
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Demos")).click();

	}

}
