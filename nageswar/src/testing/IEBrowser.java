package testing;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {

	public static void main(String[] args) {
     
		System.setProperty("webdriver.ie.driver", "D:\\batch241\\IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
	}

}
