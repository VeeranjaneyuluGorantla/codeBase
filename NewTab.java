package testing;

import java.util.ArrayList;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class NewTab {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Browser Name");
		String x = sc.nextLine();
		WebDriver driver = null;
		// Launch site
		if (x.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (x.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\batch241\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (x.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "F:\\batch241\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (x.equals("opera")) {
			OperaOptions oo = new OperaOptions();
			oo.setBinary("C:\\Program Files\\opera\\launcher.exe");
			System.setProperty("webdriver.opera.driver", "F:\\batch241\\operadriver_win64\\operadriver.exe");
			driver = new OperaDriver(oo);
		} else {
			System.out.println("Unknown Browser");
			System.exit(0);
		}
		driver.get("http://www.sentia.in/");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[contains(@src,'pay_online.jpg')]")).click();
		// new tab window
		driver.findElement(By.xpath("(//*[contains(@href,'transportfeesentia1')])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[contains(@href,'paymentOptionsGroup')])[3]")).click();
		Thread.sleep(5000);
		ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		//switch to 2nd window and close
		driver.switchTo().window(a.get(1));
		driver.close();
		Thread.sleep(5000);
		//switch to 1st window and close
		driver.switchTo().window(a.get(0));
		driver.close();
		Thread.sleep(5000);
		//switch to 3rd window and close
		driver.switchTo().window(a.get(2));
		driver.close();
	}

}
