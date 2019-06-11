package sunder;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class AppiumMethods {

	public static void main(String[] args) throws Exception{
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		// maintain details base for ard device
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","52001c67ec74a457");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage","com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
		// launch app in ARD through appium server
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
		// get details of spcified app in capabilities
		System.out.println(driver.getCurrentPackage());
		System.out.println(driver.currentActivity());
		// work with ohter app
		if(driver.isAppInstalled("com.samsung.android.contacts"))
		{
			System.out.println("phone app is ready");
			driver.activateApp("com.samsung.android.contacts");
		}
		else
		{
			driver.installApp("path of phone app .apk");
			System.out.println("phone is ready");
			driver.activateApp("com.samsung.android.contacts");
		}
		Thread.sleep(10000);
		//get status of other app
		ApplicationState as=driver.queryAppState("com.samsung.android.contacts");
		System.out.println(as.toString());
		// get other lauched app
		System.out.println(driver.getCurrentPackage());
		System.out.println(driver.currentActivity());
		//close that other app
		driver.terminateApp("com.samsung.android.contacts");
		// back to work with app specified in capabilities
		driver.launchApp();
		driver.runAppInBackground(Duration.ofSeconds(10));
		driver.closeApp();
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
