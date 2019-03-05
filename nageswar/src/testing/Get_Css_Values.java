package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Get_Css_Values {

	public static void main(String[] args) {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		//get details before focus
		WebElement e = driver.findElement(By.xpath("(//*[text()='Gmail'])[1]"));
		String o1 = e.getCssValue("opacity");
		String td1 = e.getCssValue("text-decoration");
		//focus on element
		Actions a = new Actions(driver);
		a.moveToElement(e).clickAndHold().build().perform();
        //get details focus on element
		String o2 = e.getCssValue("opacity");
		String td2 = e.getCssValue("text-decoration");
		String lh = e.getCssValue("line-height");
		System.out.println(lh);
		//close site
		driver.close();
		System.out.println(o1+" "+o2);
		System.out.println(td1+" "+td2);
	}

}
