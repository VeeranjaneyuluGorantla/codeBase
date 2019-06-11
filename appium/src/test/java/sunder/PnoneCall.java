package sunder;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class PnoneCall {

	public static void main(String[] args)throws Exception
	{
		// given a mobile number
		Scanner sc=new Scanner(System.in);
		System.out.println("enter mobile number");
		String mbno=sc.nextLine();
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		// get appium server
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		// provide details of app and device (AVD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
		// create driver object to launch app in avd
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
		// app automation
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='backspace']")));
			for(int i=0;i<mbno.length();i++)
			{
				char d=mbno.charAt(i);
				String w="";
				switch(d)
				{
				   case '0':
					   w="zero";
					   break;
				   case '1':
					   w="one";
					   break;
				   case '2':
					   w="two";
					   break;
				   case '3':
					   w="three";
					   break;
				   case '4':
					   w="four";
					   break;
				   case '5':
					   w="five";
					   break;
				   case '6':
					   w="six";
					   break;
				   case '7':
					   w="seven";
					   break;
				   case '8':
					   w="eight";
					   break;
				   case '9':
					   w="nine";
					   break;
				}
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='"+w+"']")));
				driver.findElement(By.xpath("//*[@content-desc='"+w+"']")).click();
			}
			// loop ending
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='dial']")));
			driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='0.10']")));
			driver.findElement(By.xpath("//*[@text='0.10']")).click();
			driver.closeApp();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
