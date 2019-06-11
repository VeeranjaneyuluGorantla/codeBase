package sunder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.lept4j.util.LoadLibs;
import net.sourceforge.tess4j.Tesseract;

public class Test148 {
	public static void main(String[] args) throws Exception {
		// Site is common for computer and mobile
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter platform like computer/mobile");
		String p = sc.nextLine();
		// Objects declarations
		WebDriver driver = null;
		// Objects creation
		if (p.equalsIgnoreCase("computer")) {
			System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else {
			// Start appium server and form url for it
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
			URL u = new URL("http://127.0.0.1:4723/wd/hub");
			// Maintain details base for browser and ARD
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			dc.setCapability("deviceName", "52001c67ec74a457");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "8.1.0");
			// Launch chrome in ARD through appium server
			while (2 > 1) {
				try {
					driver = new AndroidDriver(u, dc);
					break;
				} catch (Exception ex) {
				}
			}
		}
		// Launch site using chrome
		driver.get("https://apechallan.org");
		Thread.sleep(5000);
		driver.findElement(By.name("rcnumber")).sendKeys("AP07ax3840");
		// find element x,y co-orinates and width and height
		WebElement e=driver.findElement(By.xpath("//*[@id='captImg']//img"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		// get full page screen shot
		File fullimg=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage full=ImageIO.read(fullimg);
		BufferedImage el=full.getSubimage(x, y, w, h);
		ImageIO.write(el, "png", fullimg);
		File f=new File("D:\\captcha1.png");
		FileHandler.copy(fullimg, f);
		// get text from element
		File fo=LoadLibs.extractNativeResources("tessdata");
		Tesseract obj=new Tesseract(); 
		obj.setDatapath(fo.getAbsolutePath());
		String res=obj.doOCR(fullimg);
		Thread.sleep(20000);
		// fill captcha
		driver.findElement(By.xpath("//*[@id='captcha_code']")).sendKeys(res);
		Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Search']")).click();
        if(p.equalsIgnoreCase("computer"))
        {
        	// close site
        	driver.close();
        }
        else {
        	// close site
        	driver.close();
        	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        	Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
        }

	}
}
