package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetElements1 {

	public static void main(String[] args) throws InterruptedException {
		// launch site
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		WebDriver obj = new ChromeDriver();
		obj.get("https:\\www.google.co.in");
		//find tags
		List<WebElement> l = obj.findElements(By.tagName("a"));
		int count = l.size();
		System.out.println(count);
		l.get(51).click();
		Thread.sleep(5000);
		
		//close site
		obj.close();

	}

}
