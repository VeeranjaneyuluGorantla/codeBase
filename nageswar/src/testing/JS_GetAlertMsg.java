package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_GetAlertMsg {

	public static void main(String[] args) throws InterruptedException {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//get itmes(invisible) of a droup-down without open
		List<WebElement> il=driver.findElements(By.xpath("(//*[@class='ui fluid selection dropdown'])[1]/div[2]/div"));
		System.out.println(il.size());
		for(int i=0;i<il.size();i++) {
			System.out.println(il.get(i).getText());
			driver.executeScript("var x=arguments[0].textContent;window.alert(x);", il.get(i));
			String y=driver.switchTo().alert().getText();
			System.out.println(y);
			Thread.sleep(5000);
			driver.switchTo().alert().dismiss();
		}
		Thread.sleep(5000);
		//close site
		driver.close();
	}
    

}
