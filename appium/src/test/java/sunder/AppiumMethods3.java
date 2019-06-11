package sunder;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumMethods3 {

	public static void main(String[] args)throws Exception {
		// start appium server
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		// maintain details base for app and AVD
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","52001c67ec74a457");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage","com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
		// launch app in ARD through appium server
		Thread.sleep(5000);
		AndroidDriver driver;//=new AndroidDriver(u,dc);
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
			// came to home, open notifications and click clear
			Thread.sleep(5000);
			KeyEvent k=new KeyEvent(AndroidKey.HOME);
			driver.pressKey(k);
			Thread.sleep(5000);
			driver.openNotifications();
			Thread.sleep(5000);
			WebElement e=driver.findElement(By.xpath("//*[@text='CLEAR']"));
			String s=e.getAttribute("enabled");
			if(s.equals("true"))
			{
				e.click();
				driver.pressKey(k);// goto home
			}
			else
			{
				driver.pressKey(k); //back to home
			}
			Thread.sleep(5000);
			// get details of device
			String x=driver.getRemoteAddress().getProtocol();
			System.out.println(x);
			String y=driver.getRemoteAddress().getHost();
			System.out.println(y);
			String z=driver.getRemoteAddress().getPath();
			System.out.println(z);
			int w=driver.getRemoteAddress().getPort();
			System.out.println(w);
			long a=driver.getDisplayDensity();
			System.out.println(a);
			String b=driver.getPlatformName();
			System.out.println(b);
			// get device lock divece
			if(driver.isDeviceLocked()==false)
			{
				driver.lockDevice();
				Thread.sleep(5000);
				driver.unlockDevice();
			}
			// back to work with app specified in capabilities
			driver.resetApp();
			Thread.sleep(2000);
			driver.closeApp();
			// stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}

	}


