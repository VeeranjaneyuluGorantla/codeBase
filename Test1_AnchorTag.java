package testing;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_AnchorTag {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com");
		driver.manage().window().maximize();
		List<WebElement> l = driver.findElements(By.tagName("a"));
		System.out.println(l.size());
		for (int i = 0; i < l.size(); i++) {
			String x = l.get(i).getText();
			System.out.println(x);
		}
		Collections.sort((List) l);
		// Let us print the sorted list
		System.out.println("List after the use of" + " Collection.sort() :\n" + l);

		// close site
		driver.close();

	}

}
