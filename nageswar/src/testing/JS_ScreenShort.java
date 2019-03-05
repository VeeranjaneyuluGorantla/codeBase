package testing;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_ScreenShort {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.mindqsystems.com/");
		driver.manage().window().maximize();
		WebElement e = driver.findElement(By.xpath("//*[@class='box-services green']"));
		int x = e.getLocation().getX();
		int y = e.getLocation().getY();
		int w = e.getSize().getWidth();
		int h = e.getSize().getHeight();
		System.out.println(x + " " + y + " " + w + " " + h);
		// fill border an element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px yellow dashed';", e);
		Thread.sleep(5000);
		// scroll to specific element
		WebElement e1 = driver.findElement(By.xpath("//*[@class='box-services green']"));
		js.executeScript("arguments[0].scrollIntoView();", e1);
		Thread.sleep(5000);
		// get page screenshot
		File ss = driver.getScreenshotAs(OutputType.FILE);
		// save element screen short
		File dest = new File("ss1.png");
		FileUtils.copyFile(ss, dest);
		// close site
		driver.close();
	}

}
