package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) {
		// launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		WebElement e =driver.findElement(By.name("identifier"));
		String x = e.getAttribute("type"); 
		System.out.println(x);	
		WebElement e2=driver.findElement(By.xpath("//*[@class='RveJvd snByac'][1]"));
		String y=e2.getText();
		System.out.println(y);
		String z=e2.getCssValue("color");
		System.out.println(z);
		
// close site
		driver.close();
	}

}
