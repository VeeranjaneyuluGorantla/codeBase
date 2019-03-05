/*package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Youtube_sikulix {

	public static void main(String[] args)throws Exception {
		// launch site
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
		WebDriverWait w =new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		driver.findElement(By.id("search")).sendKeys("abdul kalam sir spaches");
		driver.findElement(By.xpath("(//*[@aria-label='Search'])[2]/child::*[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Abdul Kalam in European Parliament')]")));
		// start vedio
		driver.findElement(By.xpath("//*[contains(text(),'Abdul Kalam in European Parliament')]")).click();
		//skip and if exists (sikulix)
		Thread.sleep(5000);
		Screen s=new Screen();
		if(s.exists("D:\\batch241\\selenium\\hadoop\\skipadd.png")!=null)
		{
			s.click("D:\\batch241\\selenium\\hadoop\\skipadd.png");
		}
		// pause video
		s.mouseMove(200,200); // move mouse point to video body
		s.click("D:\\batch241\\selenium\\hadoop\\pay.PNG");
		// play video
		Thread.sleep(5000);
		s.click("D:\\batch241\\selenium\\hadoop\\play.PNG");
		//decrease volume
		Thread.sleep(5000);
        s.mouseMove("D:\\batch241\\selenium\\hadoop\\volume.PNG");
        Match e=s.find("D:\\batch241\\selenium\\hadoop\\buble.PNG");
        int x=e.getX();
        int y=e.getY();
        Location l1=new Location(x-50,y);
        s.dragDrop(e,l1);
        Thread.sleep(5000);
        // increase voluem 
        Location l2=new Location(x+50,y);
        s.dragDrop(e,l2);
        Thread.sleep(5000);
        // close site
        driver.close();
	}

}
*/