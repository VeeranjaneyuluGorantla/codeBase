package testing;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class CrossBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Browser name");
		String x=sc.nextLine();
		WebDriver driver = null;
		if(x.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		else if(x.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "F:\\batch241\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		else if(x.equals("ie")){
			System.setProperty("webdriver.ie.driver", "F:\\batch241\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(x.equals("opera")){
			OperaOptions oo = new OperaOptions();
			oo.setBinary("C:\\Program Files\\opera\\launcher.exe");
			System.setProperty("webdriver.opera.driver", "F:\\batch241\\operadriver_win64\\operadriver.exe");
			driver = new OperaDriver(oo);
		}else {
			System.out.println("Unknown Browser");
			System.exit(0);
		}
		
		// lanch gmail
		driver.get("https://www.gmail.com");
		
		// login gmail
		driver.findElement(By.name("identifier")).sendKeys("anjaneyulu.nodejs");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("veeru@123");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		
		// click compose
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("to")).sendKeys("veeranjaneyulu.2346@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.name("subjectbox")).sendKeys("Wishes");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hi Veeru\nHow r u\nBye");
		driver.findElement(By.className("bBe")).click();
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		Thread.sleep(5000);
		
		//sign out
		driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		
		// close site
		driver.close();

		

	}

}
