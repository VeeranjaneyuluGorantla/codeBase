package testing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		// launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.mindqsystems.com/");
		Thread.sleep(5000);
		// find elements and set x,y,width,height
		List<WebElement> l = driver.findElements(By.tagName("select"));
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).isDisplayed()) {
				int x = l.get(i).getLocation().getX();
				int y = l.get(i).getLocation().getY();
				int w = l.get(i).getSize().getWidth();
				int h = l.get(i).getSize().getHeight();
				// get page screenshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				BufferedImage fullimg = ImageIO.read(src);
				BufferedImage elescreenshot = fullimg.getSubimage(x, y, w, h);
				ImageIO.write(elescreenshot, "png", src);
				// save element screenshort
				File dest = new File("ElementScreenshot" + i + ".png");
				FileUtils.copyFile(src, dest);
			}
		}
		// close site
		driver.close();

	}

}
