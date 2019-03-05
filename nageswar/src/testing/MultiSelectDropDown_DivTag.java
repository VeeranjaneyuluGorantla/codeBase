package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiSelectDropDown_DivTag {

	public static void main(String[] args) throws InterruptedException {
		// Launc Site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		// open multi drop-down (developed using <div>tag)
		WebElement e = driver.findElement(By.xpath("//*[contains(@class,'ui fluid dropdown selection multiple')]"));
		Actions a = new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		// get iteams and display
		List<WebElement> l = driver.findElements(By.xpath("//*[contains(@class,'menu transition visible')]/child::*"));
		System.out.println("No: iteams is " + l.size());
		for(int i=0;i<l.size();i++) {
			
			System.out.println(l.get(i).getText());
		}
		a.click(l.get(1)).click(l.get(3)).click(l.get(5)).click(l.get(12)).build().perform();
		Thread.sleep(5000);
		// close the selected iteams
		List<WebElement> l2 = driver.findElements(By.xpath("//*[contains(@class,'ui label transition visible')]/child::*"));
		System.out.println("selected items "+l2.size());
		
		a.click(l2.get(1)).click(l2.get(2)).build().perform();
		Thread.sleep(5000);
          //close site
		driver.close();
	}

}
