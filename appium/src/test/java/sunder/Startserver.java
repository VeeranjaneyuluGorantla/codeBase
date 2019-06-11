package sunder;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Startserver {

	public static void main(String[] args)throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		Thread.sleep(5000);
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
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
				System.out.println(ex);
			}
		}
		System.out.println(driver.getPageSource());
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
		Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
	}

}
