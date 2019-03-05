package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbRegistar {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("firstname")).sendKeys("Seeta");
		driver.findElement(By.name("lastname")).sendKeys("Gorantla");
		driver.findElement(By.name("reg_email__")).sendKeys("6589786589");
		driver.findElement(By.name("reg_passwd__")).sendKeys("veeru@123");
		// date droup-down
		WebElement e = driver.findElement(By.name("birthday_day"));
		Select s=new Select(e);
		s.selectByVisibleText("19");
		// month droup-down
		WebElement e1 = driver.findElement(By.name("birthday_month"));
		Select s1=new Select(e1);
		s1.selectByVisibleText("Jan");
		// year droup-down
		WebElement e2= driver.findElement(By.name("birthday_year"));
		Select s2=new Select(e2);
		s2.selectByVisibleText("1994");
		//radio button select
		driver.findElement(By.xpath("//*[text()='Female']")).click();
		// submit application
		driver.findElement(By.name("websubmit")).click();
		

	}

}
