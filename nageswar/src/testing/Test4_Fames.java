package testing;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test4_Fames {

	public static void main(String[] args) {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tag_frameset.asp");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='HTML ']")));
		List<WebElement> l = driver.findElements(By.tagName("iframe"));
		System.out.println(l.size());
		driver.findElement(By.xpath("//*[text()='Try it Yourself »']")).click();
		// switch 1st frame
		driver.switchTo().frame(0);
	    // switch to page
		driver.switchTo().defaultContent();
		//if nested frame 
		driver.switchTo().frame(1);//switch to 2nd frame
		driver.switchTo().frame(0);//1st frame in from (nested frame) in 2nd frame
		//switch to page
		driver.switchTo().defaultContent();
		//close site;
		driver.close();

	}

}
