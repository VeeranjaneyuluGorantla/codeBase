package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3_CheCkedCheckbox {

	public static void main(String[] args) {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/checkbox.html");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Make my profile visible']")));
		List<WebElement> l = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(l.size());
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).isSelected()) {
				System.out.println(l.get(i).getAttribute("type"));
			}
		}

		//close site
		driver.close();
	}

}
