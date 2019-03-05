package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class ToolTip_Title {

	public static void main(String[] args) throws Exception{
		// launch site
		
		System.setProperty("webdriver.opera.driver", "D:\\batch241\\operadriver_win64\\operadriver.exe");
		OperaOptions oo = new OperaOptions();
		oo.setBinary("C:\\Program Files\\opera\\launcher.exe");
		OperaDriver driver = new OperaDriver(oo);
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		//maximize window size
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Get tool tip via Title Attribute
		
        WebElement e1 =driver.findElement(By.linkText("JAVASCRIPT"));
        String x=e1.getAttribute("title");
        System.out.println(x);
        Thread.sleep(5000);
        // move tomouse point an element by tool tip
        WebElement e2 =driver.findElement(By.xpath("(//*[@class='tooltip'])[1]"));
        Actions a = new Actions(driver);
        a.moveToElement(e2).clickAndHold().build().perform();
        Thread.sleep(5000);
        WebElement e3 = driver.findElement(By.xpath("(//*[@class='tooltip'])[1]/span"));
        String y=e3.getText();
        System.out.println(y);
        a.release().build().perform();
        Thread.sleep(5000);
        //colse site
        driver.close();
	}

}
