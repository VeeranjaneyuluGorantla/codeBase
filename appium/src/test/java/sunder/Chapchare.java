package sunder;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Chapchare {

	public static void main(String[] args) throws Exception
	{
		// poin image file to get text
		
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://apechallan.org");
		Thread.sleep(10000);
		driver.findElement(By.name("rcnumber")).sendKeys("AP07ax3840");
		// find element x,y co-orinates and width and height
		WebElement e=driver.findElement(By.xpath("//*[@id='captImg']//img"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int w=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		// get full page screen shot
		File fullimg=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage full=ImageIO.read(fullimg);
		BufferedImage el=full.getSubimage(x, y, w, h);
		ImageIO.write(el, "png", fullimg);
		File f=new File("D:\\captcha.png");

		
		
		//File f=new File("D:\\w2sms.png");
		// point tess4j-3.0.0 releted librarry folder
		File fo=LoadLibs.extractTessResources("tessdata"); // default folder which can provide data to ocr
		Tesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());
		String res=obj.doOCR(f);
		Thread.sleep(2000);
		System.out.println(res);

	}

}
