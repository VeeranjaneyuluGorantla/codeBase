package sunder;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class PayStore {

	public static void main(String[] args)throws Exception 
	{
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "52001c67ec74a457");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.android.vending");
		dc.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
				
			}
		}
		// paystore app 2nd frame layout
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Recommended for you']")));
		TouchAction ta=new TouchAction(driver);
		// HorizentalSwipe (right to left)
		while(2>1)
		{
			List<MobileElement> l1=driver.findElements(By.xpath("(//*[@resource-id='com.android.vending:id/cluster_content'])[2]/child::*"));
			if(l1.get(l1.size()-1).getAttribute("className").equals("android.view.View"))
			{
				break;
			}
			else
			{
				ta.press(ElementOption.point(650,990)).moveTo(ElementOption.point(150,990)).release().perform();
			}
		}
		// Horizental swipe (left to right)
		Thread.sleep(5000);
		while(2>1)
		{
			List<MobileElement> l2=driver.findElements(By.xpath("(//*[@resource-id='com.android.vending:id/cluster_content'])[2]/child::*"));
			if(l2.get(0).getAttribute("className").equals("android.view.View"))
			{
				break;
			}
			else
			{
				ta.press(ElementOption.point(150,990)).moveTo(ElementOption.point(650,990)).release().perform();
			}
		}
		// close app
		driver.closeApp();
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
