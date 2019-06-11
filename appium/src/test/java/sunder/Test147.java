package sunder;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

public class Test147 {
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
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);

		// Click register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		// Fill registration page
		driver.findElement(By.name("firstName")).sendKeys("abdul");
		driver.findElement(By.name("lastName")).sendKeys("kalam");
		driver.findElement(By.name("phone")).sendKeys("9000624323");
		driver.findElement(By.name("userName")).sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("address1")).sendKeys("Mosque street");
		driver.findElement(By.name("address2")).sendKeys("Dhanushkoti road");
		driver.findElement(By.name("city")).sendKeys("Rameshwaram");
		driver.findElement(By.name("state")).sendKeys("Tamilnadu");
		driver.findElement(By.name("postalCode")).sendKeys("600032");
		// Drop-down automation
		WebElement e = driver.findElement(By.name("country"));
		Select s = new Select(e);
		s.selectByVisibleText("INDIA");
		// Automate further elements
		driver.findElement(By.name("email")).sendKeys("apj11");
		driver.findElement(By.name("password")).sendKeys("batch241");
		driver.findElement(By.name("confirmPassword")).sendKeys("batch241");
		driver.findElement(By.name("register")).click();
		Thread.sleep(5000);
		if (p.equalsIgnoreCase("computer")) {
			// Close site
			driver.close();
		} else {
			// Close site
			driver.close();
			// Stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
	}
}
