package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObserveMethods {

	public static void main(String[] args) throws InterruptedException {
		// Launch site 
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(5000);
		// validate radio button
		driver.findElement(By.partialLinkText("Flight")).click();
		try {
			WebElement e = driver.findElement(By.xpath("(//*[@value='S'])[1]"));
			if(e.isDisplayed()) {
				System.out.println("Displayed");
				if(e.isEnabled()) {
					System.out.println("Enabled");
					if(e.isSelected()) {
						System.out.println("Selected");
					}else {
						System.out.println("not selected");
					}
				}else {
					System.out.println("Disabled");
				}
			}else {
				System.out.println("Hidden");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		//close site
		driver.close();
        
	}

}
