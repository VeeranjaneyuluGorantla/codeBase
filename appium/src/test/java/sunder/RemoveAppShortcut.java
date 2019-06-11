package sunder;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;

public class RemoveAppShortcut {

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
				dc.setCapability("appPackage", "com.vodqareactnative");
				dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
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
				try
				{
					// automation
					Thread.sleep(5000);
					KeyEvent k=new KeyEvent(AndroidKey.HOME);
					driver.pressKey(k);
					Thread.sleep(5000);
					// long press  on crickbuzz
					WebElement e=driver.findElement(By.xpath("//*[@text='Cricbuzz']"));
					TouchAction ta=new TouchAction(driver);
					ta.longPress(ElementOption.element(e)).perform();
					Thread.sleep(5000);
					//operate an item in context menu
					driver.findElement(By.xpath("//*[@text='Remove from Home']")).click();
					Thread.sleep(5000);
					// back to work with app specified in capabilities
					driver.resetApp();
					driver.closeApp();
					
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				// stop appium
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
