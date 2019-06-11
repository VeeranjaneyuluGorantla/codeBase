package sunder;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;

public class Test144 {
	public static void main(String[] args) throws Exception {
		// Get data from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter expected color name");
		String str = sc.nextLine();
		str = str.toLowerCase();
		Color ec = null;
		switch (str) {
		case "red":
			ec = Color.RED;
			break;
		case "green":
			ec = new Color(0, 128, 0);
			// Color.GREEN means lime
			break;
		case "blue":
			ec = Color.BLUE;
			break;
		case "black":
			ec = Color.BLACK;
			break;
		default:
			System.out.println("Wrong color name");
			System.exit(0); // stop execution forcibly
		}
		// Start appium server and form url for it
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
		URL u = new URL("http://127.0.0.1:4723/wd/hub");
		// Maintain details base for app and ARD
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "52001c67ec74a457");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "8.1.0");
		dc.setCapability("appPackage", "com.vodqareactnative");
		dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
		// Launch app in ARD through appium server
		AndroidDriver driver;
		while (2 > 1) {
			try {
				driver = new AndroidDriver(u, dc);
				break;
			} catch (Exception ex) {
			}
		}
		// Automation
		try {
			// login
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			TouchAction ta = new TouchAction(driver);
			// swipe for "Wheel Picker" option (bottom to top)
			while (2 > 1) {
				try {
					driver.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
					break;
				} catch (Exception ex) {
					ta.press(ElementOption.point(400, 1000)).moveTo(ElementOption.point(400, 600)).release().perform();
				}
			}
			// open spinner
			driver.findElement(By.xpath("//*[@class='android.widget.Spinner']")).click();
			// Select item
			driver.findElement(By.xpath("//*[@text='" + str + "']")).click();
			// goto color area element
			WebElement e = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup'][@instance='2']"));
			int x = e.getLocation().getX();
			int y = e.getLocation().getY();
			int w = e.getSize().getWidth();
			int h = e.getSize().getHeight();
			// Get screenshot of full screen
			File fullimg = driver.getScreenshotAs(OutputType.FILE);
			BufferedImage bfull = ImageIO.read(fullimg);
			// Get screenshot of color area element
			BufferedImage bele = bfull.getSubimage(x, y, w, h);
			int count = 0;
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					Color ac = new Color(bele.getRGB(i, j));
					if (ac.getRed() == ec.getRed() && ac.getGreen() == ec.getGreen() && ac.getBlue() == ec.getBlue()) {
						count = count + 1;
					}
				}
			}
			System.out.println(w * h);
			System.out.println(count);
			double percentage = count * 100.0 / (w * h);
			System.out.println(percentage);
			if (percentage >= 90) {
				System.out.println("Test passed");
			} else {
				System.out.println("Test failed");
			}
		} catch (Exception ez) {
			System.out.println(ez.getMessage());
		}

		// close app
		driver.closeApp();
		// Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
