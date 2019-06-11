package sunder;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class TapMethod {

	public static void main(String[] args) throws Exception{
		// start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u=new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","52001c67ec74a457");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage","com.vodqareactnative");
		dc.setCapability("appActivity","com.vodqareactnative.MainActivity");
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
				System.out.println(ex.getMessage());
			}
		}
		
		try
		{
			// automation
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Native View']")));
			// tap on an element
			WebElement e=driver.findElement(By.xpath("//*[@text='Native View']"));
			TouchAction ta=new TouchAction(driver);
			ta.tap(ElementOption.element(e)).perform();
			// wait and validation out come
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			try
			{
				if(driver.findElement(By.xpath("//*[@text='Native View Demo']")).isDisplayed())
				{
					System.out.println("Test passed");
				}
				else
				{
					System.out.println("Test Failed");
				}
			}
			catch(Exception ey)
			{
				System.out.println(ey.getMessage());
			}
		}
		catch(Exception ez)
		{
			System.out.println(ez.getMessage());
			
		}
		// close app
		driver.closeApp();
		// stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
