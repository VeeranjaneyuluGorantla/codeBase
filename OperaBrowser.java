package testing;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		OperaOptions oo = new OperaOptions();
		oo.setBinary("C:\\Program Files\\opera\\launcher.exe");
		System.setProperty("webdriver.opera.driver", "D:\\batch241\\operadriver_win64\\operadriver.exe");
		OperaDriver driver = new OperaDriver(oo);
		driver.get("https://www.isro.gov.in/");
		Thread.sleep(5000);
		driver.close();
	

	}

}
