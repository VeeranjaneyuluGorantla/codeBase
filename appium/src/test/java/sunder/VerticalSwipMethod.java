package sunder;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class VerticalSwipMethod {

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
				System.out.println(ex.getMessage());
			}
		}
		// automation
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		TouchAction ta = new TouchAction(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// swipe for "Web View" text(buttom, top)
		while (2 > 1) {
			try {
				if (driver.findElement(By.xpath("//*[@text='Web View']")).isDisplayed()) {
					break;
				}

			} catch (Exception ex) {
				ta.press(ElementOption.point(400, 1000)).moveTo(ElementOption.point(400, 600)).release().perform();
			}
		}
		// swipe for "Native View" text (top to bottom)
		while (2 > 1) {
			try {
				if (driver.findElement(By.xpath("//*[@text='Native View']")).isDisplayed()) {
					break;
				}
			} catch (Exception ex) {
				ta.press(ElementOption.point(400, 600)).moveTo(ElementOption.point(400, 1000)).release().perform();
			}
		}
		// close app
		driver.closeApp();
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
