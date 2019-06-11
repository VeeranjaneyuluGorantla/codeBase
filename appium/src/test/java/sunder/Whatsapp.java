package sunder;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Whatsapp {

	public static void main(String[] args)throws Exception {
		// get a mobile number
				/*Scanner sc=new Scanner(System.in);
				System.out.println("enter a mobile number");
				String mbno=sc.nextLine()*/;
				// start appium server
				Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
				URL u=new URL("http://127.0.0.1:4723/wd/hub");
				// maintain details for app and avd
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME,"");
				dc.setCapability("deviceName","52001c67ec74a457");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion","8.1.0");
				dc.setCapability("appPackage","com.whatsapp");
				dc.setCapability("appActivity","com.whatsapp.HomeActivity");
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
				//app automation
				try
				{
					WebDriverWait wait=new WebDriverWait(driver,20);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='CHATS']")));
					driver.findElement(By.xpath("//*[@text='CHATS']")).click();
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Type a message']")));
					driver.findElement(By.xpath("//*[@text='Type a message']")).sendKeys("Hi,this message send to automation testing programe not mannuvall typing");
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Send']")));
					driver.findElement(By.xpath("//*[@content-desc='Send']")).click();
					// close app
					driver.closeApp();
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				// stop appium server
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
