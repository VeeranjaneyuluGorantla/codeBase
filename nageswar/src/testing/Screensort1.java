package testing;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.chrome.ChromeDriver;

public class Screensort1 {

	public static void main(String[] args) throws IOException {
		// launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@id='hplogo']/descendant::*[2]"));
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("Screenshot.png");
		FileUtils.copyFile(src,dest);
		//close site
		driver.close();

	}

}
