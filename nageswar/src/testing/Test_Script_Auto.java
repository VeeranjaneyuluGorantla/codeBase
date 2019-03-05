package testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Script_Auto {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Mobile No");
		String mbno = sc.nextLine();
		System.out.println("Enter criteria");
		String mbnoc = sc.nextLine();
		System.out.println("Enter password");
		String pwd = sc.nextLine();
		System.out.println("Enter criteria");
		String pwdc = sc.nextLine();
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.way2sms.com/");
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		driver.findElement(By.name("mobileNo")).sendKeys(mbno);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1]")).click();
		/*---- w.until(temp -> driver.executeScript("return document.readyState;").equals("complete"));  */
		Thread.sleep(5000);
		// validations(observations)
		if (mbno.length() == 0
				&& driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed()) {
			System.out.println("mobile no blank test : passed");
		} else if (mbno.length() < 10
				&& driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed()) {
			System.out.println("wrong size mobile no test : passed");
		} else if (pwd.length() == 0
				&& driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed()) {
			System.out.println("password blank test : passed");
		} else if (mbnoc.equals("invalid")
				&& driver.findElement(By.xpath("//*[text()='Invalid Mobile Number']")).isDisplayed()) {
			System.out.println("mobile number invalid test: passed");
		} else if (pwdc.equals("invalid")
				&& driver.findElement(By.xpath("(//*[contains(text(),'Try Again')])[1]")).isDisplayed()) {
			System.out.println("password invalid test: passed");
		} else if (mbnoc.equals("valid") && pwdc.equals("valid")
				&& driver.findElement(By.xpath("(//*[contains(text(),'SendSMS')])[1]")).isDisplayed()) {
			System.out.println("valid data test passed");
		} else {
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			Date d = new Date();
			String fname = sf.format(d) + ".png";
			File src = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File(fname);
			FileHandler.copy(src, dest);
			System.out.println("login test failed");
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SendSMS']")));
		//driver.findElement(By.xpath("//*[@class='fa icon-user']")).click();
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[text()='Reddy']")).click();
		//driver.findElement(By.xpath(""))
		// close site
		//driver.close();
	}

}
