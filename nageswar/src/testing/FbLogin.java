package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbLogin {

	public static void main(String[] args) throws InterruptedException {
         
	    System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
	    ChromeDriver driver = new ChromeDriver();
	    driver.get("https://www.facebook.com");
	    // login automation
	    driver.findElement(By.name("email")).sendKeys("veeranjaneyulu.2346@gmail.com");
	    driver.findElement(By.name("pass")).sendKeys("veerusiri");
	    driver.findElement(By.xpath("//*[@type='submit']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[text()='Veeru']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[text()='Home']")).click();
	    driver.findElement(By.xpath("//*[text()='Account Settings']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']//a[@class='_54nc']//span//span[@class='_54nh']")).click();
	    //Thread.sleep(5000);
	    //driver.findElement(By.xpath("//*[text()='Veeru Gorantla']")).click();
	    //driver.findElement(By.className("_54nh")).click();
	}

}
