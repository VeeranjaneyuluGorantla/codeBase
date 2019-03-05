package testing;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLExampe_Chrome {

	public static void main(String[] args) {
		// Launch site
		DesiredCapabilities c = DesiredCapabilities.chrome();
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(c);
		driver.get("https://cargo.airasia.com");
		driver.manage().window().maximize();
		

	}

}
