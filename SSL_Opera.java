package testing;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL_Opera {

	public static void main(String[] args) {
		// Lanch site
		OperaOptions oo = new OperaOptions();
		oo.setBinary("C:\\Program Files\\opera\\launcher.exe");
		DesiredCapabilities dc = DesiredCapabilities.opera();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(OperaOptions.CAPABILITY,oo);
		System.setProperty("webdriver.opera.driver", "D:\\batch241\\operadriver_win64\\operadriver.exe");
		OperaDriver driver = new OperaDriver(dc);
		driver.get("https://cargo.airasia.com");
		driver.manage().window().maximize();
		driver.close();

	}

}
