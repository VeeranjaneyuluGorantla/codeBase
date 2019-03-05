package testing;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/js_popup.asp");
		driver.findElement(By.xpath("(//*[text()='Try it Yourself »'])[3]")).click();
		ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		driver.switchTo().window(a.get(1));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//*[text()='Try it']")).click();
		Thread.sleep(5000);
		// send data to alert
		driver.switchTo().alert().sendKeys("veeru gorantla");
		Thread.sleep(5000);
		// Capturing alert message.
		String x = driver.switchTo().alert().getText();
		System.out.println(x);
		Thread.sleep(5000);
		// clik on alert
		driver.switchTo().alert().accept();
		//back to page
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		// close site
		 driver.quit();

	}

}
