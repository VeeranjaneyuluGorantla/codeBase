package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_ScollPage {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// scroll to bottom
		driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		// scrol to top
		driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(5000);
		WebElement e = driver.findElement(By.xpath("//*[@class='ui fluid search selection dropdown']"));
		driver.executeScript("arguments[0].scrollIntoView();", e);
		Thread.sleep(5000);

	}

}
