package testing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Screenshot3 {

	public static void main(String[] args) throws Exception {
		// Launch site
		
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		// find element and set x,y,w,h
		WebElement e = driver.findElement(By.xpath("//*[@id='hplogo']"));
		int x = e.getLocation().getX();
		int y = e.getLocation().getY();
		int w = e.getSize().getWidth();
		int h = e.getSize().getHeight();

		// get page screenshot
		File ss = driver.getScreenshotAs(OutputType.FILE);
		BufferedImage fullimg = ImageIO.read(ss);
		BufferedImage eleimg = fullimg.getSubimage(x, y, w, h);
		ImageIO.write(eleimg, "png", ss);
		// save element screen short
		File dest = new File("google.png");
		FileUtils.copyFile(ss, dest);
		// close site
		driver.close();

	}

}
