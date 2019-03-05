package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MercuryTourSite {

	public static void main(String[] args) throws InterruptedException {
		// launch chrome broswer
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		// click register link
		driver.findElement(By.linkText("REGISTER")).click();
		// fill the register page
		driver.findElement(By.name("firstName")).sendKeys("abdul");
		driver.findElement(By.name("lastName")).sendKeys("kalam");
		driver.findElement(By.name("phone")).sendKeys("9000624323");
		driver.findElement(By.name("userName")).sendKeys("abj@abdulkalam.com");
		driver.findElement(By.name("address1")).sendKeys("mosque street");
		driver.findElement(By.name("address2")).sendKeys("Dhanushkoti road");
		driver.findElement(By.name("city")).sendKeys("ramesvaram");
		driver.findElement(By.name("state")).sendKeys("Tamilanadu");
		driver.findElement(By.name("postalCode")).sendKeys("600032");
		//drop-down automation
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		//automation another
		driver.findElement(By.name("email")).sendKeys("apj11");
		driver.findElement(By.name("password")).sendKeys("batch241");
		driver.findElement(By.name("confirmPassword")).sendKeys("batch241");
		driver.findElement(By.name("register")).click();
		//Thread.sleep(5000);
		
		//click support link
		driver.findElement(By.linkText("sign-in")).click();
		//driver.findElement(By.linkText("CONTACT")).click();
		//driver.close();

	}

}
