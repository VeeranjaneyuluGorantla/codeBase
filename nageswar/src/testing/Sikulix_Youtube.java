package testing;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Sikulix_Youtube {

	public static void main(String[] args) throws Exception {
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		WebDriverWait w = new WebDriverWait(driver, 100);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("search")));
		driver.findElement(By.id("search")).sendKeys("abdul kalam speeches");
		driver.findElement(By.xpath("(//button[@aria-label='Search'])[2]/child::*[1]")).click();
		// open video link
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Kalam in European Parliament')])[1]")));
		driver.findElement(By.xpath("(//*[contains(text(),'Kalam in European Parliament')])[1]")).click();
		// skip adds if exists(sikulix)
		Thread.sleep(10000);
		Screen s = new Screen();
		if (s.exists("skipadd.png") != null) {
			s.click("skipadd");
		}
		// pause video (sikulix)
		s.mouseMove(250, 250); // move mouse point to video body
		s.click("play.png");
		// play video
		Thread.sleep(5000);
		s.mouseMove(150, 150);// move mouse point to video body
		s.click("pause1.png");
		// decrese volume
		Thread.sleep(5000);
		s.mouseMove(10, 10);
		s.mouseMove("volume.png");
		// Thread.sleep(5000);
		Match e = s.find("bobble.png");
		int x = e.getX();
		int y = e.getY();
		Location l1 = new Location(x - 50, y);
		s.dragDrop(e, l1);
		Thread.sleep(5000);
		// increase volume
		Location l2 = new Location(x + 50, y);
		s.dragDrop(e, l2);
		Thread.sleep(5000);
		s.mouseMove(1, 1);
		s.click("settings.png");
		// JavaRobot
		Thread.sleep(5000);
		Robot r = new Robot();
		for (int i = 0; i < 4; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(5000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		for (int j = 0; j < 3; j++) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
			Thread.sleep(5000);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		s.mouseMove(5,5);
		s.click("settings.png");
		Thread.sleep(1000);
		//close site
		driver.close();

	}

}
