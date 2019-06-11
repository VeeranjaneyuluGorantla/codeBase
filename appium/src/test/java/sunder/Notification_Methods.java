package sunder;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;

public class Notification_Methods {

	public static void main(String[] args)throws Exception {
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","52001c67ec74a457");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage","com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
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
		// get connection details (wifi,data,airplane) related to device
		ConnectionState con=driver.getConnection();
		// about WIFI
		if(con.isWiFiEnabled())
		{
			System.out.println("wifi is in on");
		}
		else
		{
			System.out.println("wifi is in off");
		}
		if(con.isDataEnabled())
		{
			System.out.println("data is in on");
		}
		else
		{
			System.out.println("data is in off");
		}
		if(con.isAirplaneModeEnabled())
		{
			System.out.println("Airpalne mode in on");
		}
		else
		{
			System.out.println("Airplane mobe in off");
		}
		// off wife when in on
		driver.toggleWifi();
		Thread.sleep(3000);
		//on wife
		driver.toggleWifi();
		Thread.sleep(3000);
		// off data whem in on
		driver.toggleData();
		Thread.sleep(3000);
		
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
