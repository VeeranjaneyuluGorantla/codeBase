package testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Gmail_Mails_Automation
{
	public static void main(String[] args) throws Exception
	{
		//create Extend Reports
		ExtentReports er = new ExtentReports("GmailMails.html",false);
		ExtentTest et = er.startTest("Gamail mail count test");
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		WebDriverWait w = new WebDriverWait(driver,50);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("g.veeru124");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();;
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("veeru@123");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[4]")));
		// close notifications
		driver.findElement(By.xpath("//*[@class='bBe']")).click();
		// get expected count of mails
		int enoam=0;
		do
		{
			WebElement e = driver.findElement(By.xpath("(//table)[4]"));
			List<WebElement> mail=e.findElements(By.tagName("tr"));
	        int nomp=mail.size();
	        // add count of mails in current page to total count
	        enoam=enoam+nomp;
	        // go to next page
	        try
	        {
	        if(driver.findElement(By.xpath("//*[@data-tooltip='Older']")).getAttribute("aria-disabled").equals("true"))
	        {
	        	break;
	        }
	      }
	      catch(Exception ex)
	        {
	    	  driver.findElement(By.xpath("//*[@data-tooltip='Older']")).click();
	    	  Thread.sleep(5000);
	        }
			
		}while(2>1);//infinite loop
		String temp = driver.findElement(By.xpath("//*[@data-tooltip='Newer']/preceding::span[1]")).getText();
		int anoam=Integer.parseInt(temp);
		// validation
		System.out.println(enoam+" "+anoam);
		if(enoam==anoam)
		{
			et.log(LogStatus.PASS,"Mails Count Test : passed");
		}
		else
		{
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			Date d = new Date();
			String fname = sf.format(d)+".png";
			File src = driver.getScreenshotAs(OutputType.FILE);	
			File dest = new File(fname);
			FileHandler.copy(src,dest);
			et.log(LogStatus.FAIL,"Mails count test : Falied"+et.addScreenCapture(fname));
		}
		// do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']")));
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		// close site
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.close();
		// save reports
		er.endTest(et);
		er.flush();
	}//main()

}//class
