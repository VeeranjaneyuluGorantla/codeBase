package testing;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Anjularjs2 {

	public static void main(String[] args) {
		// Launch site
		Scanner sc = new Scanner(System.in);
		System.out.println("enter any name");
		String x=sc.nextLine();
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://angularjs.org/");
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='yourName']")));
		//maximize window and fill data to text box
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@ng-model='yourName']")).sendKeys(x);
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//*[contains(text(),'Hello')])[2]"), "Hello"+x+"!"));
		//close site
		driver.close();

	}

}
