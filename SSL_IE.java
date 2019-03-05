package testing;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL_IE {

	public static void main(String[] args) {
		// Launch site
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.ie.driver", "D:\\batch241\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver(dc);
		driver.get("https://cargo.airasia.com");
		driver.close();

	}

}
