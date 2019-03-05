package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FirstSelectOption {

	public static void main(String[] args) throws InterruptedException {
		//Launc site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		// maximize window 
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement e = driver.findElement(By.name("cars"));
		Select s = new Select(e);
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).click(s.getOptions().get(2)).click(s.getOptions().get(3)).click(s.getOptions().get(0)).build().perform();
		// first selected itme in multi droup down list
		String x=s.getFirstSelectedOption().getText();
		System.out.println(x);
		Thread.sleep(5000);
		//close site
		driver.switchTo().defaultContent();
		driver.close();

	}

}
