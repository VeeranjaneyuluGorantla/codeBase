package sunder;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Test146 {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a mobile number");
		String mbno=sc.nextLine();
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		// maintain details for app and avd
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","52001c67ec74a457");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage","com.samsung.android.contacts");
		dc.setCapability("appActivity","com.android.dialer.DialtactsActivity");
		// launch app in ARD through appium sever
		AndroidDriver driver;
		while(2>1)
		{
			try {
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Keypad']")));
			driver.findElement(By.xpath("//*[@content-desc='Keypad']")).click();
			for(int i=0;i<mbno.length();i++)
			{
				char d=mbno.charAt(i);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+d+"']")));
				driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
			}
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='SIM card 1 call']")));
			driver.findElement(By.xpath("//*[@content-desc='SIM card 2 call']")).click();
			Thread.sleep(100000);
			// get ScreenShot and close app
			File fullimg=driver.getScreenshotAs(OutputType.FILE);
			driver.closeApp();
			// apply ocr on screenshot to get text
			File fo=LoadLibs.extractTessResources("tessdata");
			Tesseract obj=new Tesseract();
			obj.setDatapath(fo.getAbsolutePath());
			String res=obj.doOCR(fullimg);
			Thread.sleep(2000);
			System.out.println(res);
			if(res.contains("call forwarded"))
			{
				System.out.println("test passed");
			}
			else {
				System.out.println("test failed");
			}
		}
		catch(Exception ez)
		{
			System.out.println(ez.getMessage());
		}
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
