package testing;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReports1 {

	public static void main(String[] args) throws Exception{
		// 
		ExtentReports er = new ExtentReports("google.html",false);
		ExtentTest et = er.startTest("google");
		
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		String fname = f.format(d)+"png";
		File src = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(fname);
		FileHandler.copy(src, dest);
		if(driver.getTitle().equals("Google")) {
			et.log(LogStatus.PASS, "Text case Passed");
		}else {
			et.log(LogStatus.FAIL, "TextCase Failed"+et.addScreenCapture(fname));
		}
		er.flush();
		driver.close();

	}

}
