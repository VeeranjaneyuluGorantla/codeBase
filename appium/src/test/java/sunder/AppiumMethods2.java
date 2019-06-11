package sunder;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumMethods2 {

	public static void main(String[] args) throws Exception {
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u = new URL("http://127.0.0.1:4723/wd/hub");
		// maintain details base for ard device
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "52001c67ec74a457");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.samsung.android.app.notes");
		dc.setCapability("appActivity", "com.samsung.android.app.notes.memolist.MemoListActivity");
		// launch app in ARD through appium server
		AndroidDriver driver;
		while (2 > 1) {
			try {
				driver = new AndroidDriver(u, dc);
				break;
			} catch (Exception ex) {

			}
		}
		// oparate Ard
		String x=driver.getOrientation().name();
		System.out.println(x);
		if(x.equalsIgnoreCase("PORTRAIT"))
		{
			driver.rotate(ScreenOrientation.LANDSCAPE);
		}
		Thread.sleep(5000);
		String y=driver.getOrientation().name();
		System.out.println(y);
		if(y.equalsIgnoreCase("LANDSCAPE"))
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		Thread.sleep(5000);
		// operate app specifed in capabilities
		WebDriverWait w=new WebDriverWait(driver,20);
		//w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Next']")));
		//driver.findElement(By.xpath("//*[@content-desc='Next']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Create']")));
		driver.findElement(By.xpath("//*[@content-desc='Create']")).click();
		if(driver.isKeyboardShown())
		{
			driver.hideKeyboard();
			Thread.sleep(5000);
		}
		// come to home screen without closing app
		KeyEvent k=new KeyEvent(AndroidKey.HOME);
		driver.pressKey(k);
		// back to work with app specified in capabilities
		driver.launchApp();
		driver.closeApp();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
