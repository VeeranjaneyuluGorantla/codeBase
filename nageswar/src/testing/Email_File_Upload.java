package testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Email_File_Upload {

	public static void main(String[] args) throws Exception {
		// Launch site gmail site(sed)
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		// maximize window
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, 50);
		// login gmail
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("anjaneyulu.nodejs");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("veeru@123");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		// compose mail
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		driver.findElement(By.xpath("//*[contains(text(),'Compose')]")).click();
		// close notification
		driver.findElement(By.xpath("//*[@role='button'][@class='bBe']")).click();
		// fill compose box with data
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		driver.findElement(By.name("to")).sendKeys("veeranjaneyulu.2346@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Sample Text");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hi Veeru\nHow R u");
		driver.findElement(By.xpath("//*[@name='Filedata']/preceding::div[2]")).click();
		//automate file upload window
		Thread.sleep(1000);
		StringSelection x = new StringSelection("D:\\potos\\frd's pts\\Cute baby.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
		Robot r = new Robot();
		if(System.getProperty("os.name").contains("Windows"))
		{
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
		r.keyPress(KeyEvent.VK_META);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_META);
		Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Windows"))
		{
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		}
		else {
			System.out.println("Unknown os");
			System.exit(0);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		// wait until file upload to start
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='vq']")));
		// wait until complete upload
		w.until(ExpectedConditions.attributeContains(By.xpath("//*[@class='vq']"),"role","button"));
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[contains(text(),'Message sent.')]"));
		driver.findElement(By.xpath("//*[@role='button'][@class='bBe']")).click();
		driver.findElement(By.xpath("//*[contains(@class,'gbii')]")).click();
		
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        //close site
		driver.close();
	}

}
