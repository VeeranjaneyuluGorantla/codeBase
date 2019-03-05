package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CacheAuto_Complete2 {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Fiil text Box with data to get cache/auto-complete
		driver.findElement(By.name("q")).sendKeys("steve jobs");
		Thread.sleep(5000);
		// get count iteams in cache
		List<WebElement> l = driver.findElements(By.xpath("//*[@role='listbox']/li"));
		int cs = l.size() - 2; // last 2 iteams are buttons
		// select 6 th iteam in cache
		Actions a = new Actions(driver);
		int flag = 0;
		for(int i=1;i<l.size();i++) {
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
			String x=driver.findElement(By.name("q")).getAttribute("value");
			System.out.println(x);
			if(x.equalsIgnoreCase("steve jobs book")) {
				a.sendKeys(Keys.ENTER).build().perform();
				flag =1;
				break;
			}
		}
		if(flag==0) {
			System.out.println("No item selected");
		}else {
			System.out.println("Iteam found and selected");
		}
		Thread.sleep(5000);
		//close site
		driver.close();
		

	}

}
