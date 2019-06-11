package sunder;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ChromeBrowser {

	public static void main(String[] args)throws Exception {
      // start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u =new URL("http://127.0.0.1:4723");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
		dc.setCapability("deviceName","52001c67ec74a457");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","8.1.0");
		// launch chrome in ARD through appium server
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
		// context for hybrid appium
		Thread.sleep(3000);
		Set s1=driver.getContextHandles(); // get all possible
		System.out.println(s1);
		String x=driver.getContext();
		System.out.println(x);
		driver.context("NATIVE_APP");// change context
		String y=driver.getContext();
		System.out.println(y);
		if(driver.isBrowser())
		{
			driver.close();
		}
		else
		{
			driver.closeApp();
		}
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
