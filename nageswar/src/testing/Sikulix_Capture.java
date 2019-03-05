package testing;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Sikulix_Capture {

	public static void main(String[] args) throws Exception{
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//capture the full screen screen-short (sikulix)
		File f1 = new File("F:\\batch241\\selenium\\nageswar\\fullscreen.png");
		Screen s = new Screen();
		ScreenImage si1 = s.capture();
		BufferedImage bi1 = si1.getImage();
		ImageIO.write(bi1,"png", f1);
		//capture the partscreen 
		File f2 = new File("F:\\batch241\\selenium\\nageswar\\partscreen.png");
		Region r = new Region(250,250,450,550);
		ScreenImage si2 = s.capture(r);
		BufferedImage bi2 = si2.getImage();
		ImageIO.write(bi2, "png", f2);
		// close site
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyDown(Key.F4);
		s.keyDown(Key.ALT);
		

	}

}
