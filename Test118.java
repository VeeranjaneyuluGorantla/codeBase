package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test118 {

	public static void main(String[] args) throws Exception
	{
		File f=new File("way2sms.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		// create html reports
		ExtentReports er=new ExtentReports("w2sms.html",false);
		ExtentTest et=er.startTest("w2sms login testing");
		// data driven testing
		ChromeDriver driver=null;
		String l="";
		while((l=br.readLine())!=null)
		{ 
			String[] p=l.split(",");
			try {
				// disabled chrome notification
				ChromeOptions o=new ChromeOptions();
				o.addArguments("--disable-notifications");
				// launch site
				System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
				driver=new ChromeDriver(o);
				driver.get("http://www.way2sms.com");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				// do login
				driver.findElement(By.name("mobileNo")).sendKeys(p[0]);
				driver.findElement(By.name("password")).sendKeys(p[2]);
				driver.findElement(By.xpath("(//*[contains(text(),'Login')])[2]")).click();
				Thread.sleep(5000);
				// validations
				if(p[0].length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank mobile no test passed");
					
				}
				else if(p[0].length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"wrong size mobile number test passed");
				}
				else if(p[2].length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"blank pwd test passed");
				}
				else if(p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Your mobile number is not register with us.']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"invalid mobile no test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Incorrect number or password! Try Again.']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"wrong pwd test passed");
				}
				else if(p[1].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"valid data test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					et.log(LogStatus.FAIL,"login test failed"+et.addScreenCapture(fname));
					
				}
				// close site
				driver.close();
			}catch(Exception ex) {
				driver.close();
				et.log(LogStatus.ERROR,ex.getMessage());
			}
			
		}
		br.close();
		fr.close();
		// save results file
		er.endTest(et);
		er.flush();

	}

}
