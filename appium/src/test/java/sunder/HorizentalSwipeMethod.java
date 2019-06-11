package sunder;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class HorizentalSwipeMethod {

	public static void main(String[] args) throws Exception {
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "52001c67ec74a457");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
		AndroidDriver driver;
		while (2 > 1) {
			try {
				driver = new AndroidDriver(u, dc);
				break;
			} catch (Exception ex) {

			}
		}
		// automation
		try {
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Slider']")));
			driver.findElement(By.xpath("//*[@text='Slider']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Back']")));
			WebElement e = driver.findElement(By.xpath("//*[@content-desc='slider']"));
			WebElement e2 = driver.findElement(By.xpath("//*[@content-desc='slider1']"));
			TouchAction ta1 = new TouchAction(driver);
			ta1.press(ElementOption.element(e)).moveTo(ElementOption.point(650, 0)).release().perform();
			TouchAction ta2=new TouchAction(driver);
			ta2.press(ElementOption.element(e2)).moveTo(ElementOption.point(500, 0)).release().perform();
			Thread.sleep(5000);
			MultiTouchAction ma=new MultiTouchAction(driver);
			ma.add(ta1).add(ta2).perform();
			Thread.sleep(5000);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		// close app
		driver.closeApp();
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
