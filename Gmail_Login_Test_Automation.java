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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Gmail_Login_Test_Automation 
{

	public static void main(String[] args) throws Exception
	{
		// create html file
		ExtentReports er = new ExtentReports("gmailLogin.html",false);
		ExtentTest et = er.startTest("Gmail logi testing");
		//Get test data from key-board
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user id");
		String uid = sc.nextLine();
		System.out.println("enter uid criteria");
		String uidc = sc.nextLine();
		String pwd="";
		String pwdc="";
		if(uidc.equals("valid"))
		{
			System.out.println("enter pwd ");
			pwd = sc.nextLine();
			System.out.println("enter pwd Criteria");
			pwdc = sc.nextLine();
		}
		//launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		WebDriverWait w = new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		// user id testing
		driver.findElement(By.name("identifier")).sendKeys(uid);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		//object creation 
		Gmail_Login_Test_Automation obj = new Gmail_Login_Test_Automation();
		if(uid.length()==0)
		{
			try 
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Enter an email')]")));
				et.log(LogStatus.PASS,"blan uid text:passed");
			}
			catch(Exception ex)
			{
				String x=obj.screenshot(driver);
				et.log(LogStatus.FAIL,"blanked uid text:passed"+ex.getMessage()+et.addScreenCapture(x));
				
			}
		}
			else if(uid.equals("invalid"))
			{
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Google Account')])[2]")));
					et.log(LogStatus.PASS,"Invalid uid text: passed");
				}
				catch(Exception ex) 
				{
					String x = obj.screenshot(driver);
					et.log(LogStatus.FAIL,"invalid uid test : failed"+ex.getMessage()+et.addScreenCapture(x));
				}
			}
			else {
				try {
					w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
					et.log(LogStatus.PASS,"valid data text : passed");
					// password testing
					driver.findElement(By.name("password")).sendKeys(pwd);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					if(pwd.length()==0)
					{
						try {
							w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enter a password']")));
							et.log(LogStatus.PASS,"blank pwd text : passed");
						}
						catch(Exception ex)
						{
							String x = obj.screenshot(driver);
							et.log(LogStatus.FAIL,"blank pwd test : failed"+ex.getMessage()+et.addScreenCapture(x));
							
						}
					}
					else if(pwdc.equals("invalid"))
					{
						try
						{
							w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Wrong password')]")));
							et.log(LogStatus.PASS,"wrong pwd text : passed");
						}
						catch(Exception ex)
						{
							String x = obj.screenshot(driver);
							et.log(LogStatus.FAIL,"wrong pwd text : faild"+ex.getMessage()+et.addScreenCapture(x));
							
						}
					}
					else
					{
						try
						{
							w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
							et.log(LogStatus.PASS,"valid pwd test : passed");
						}
						catch(Exception ex) 
						{
							String x = obj.screenshot(driver);
							et.log(LogStatus.FAIL,"valid pwd test : failed"+ex.getMessage()+et.addScreenCapture(x));
						}
					}
				}
				catch(Exception ex)
				{
					String x = obj.screenshot(driver);
					et.log(LogStatus.FAIL,"valid uid test : Failed"+ex.getMessage()+et.addScreenCapture(x));
				}
			}
		//close site
		driver.close();
		//save results
		er.endTest(et);
		er.flush();

	}//main()
	public String screenshot(ChromeDriver driver)throws Exception
	{
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date d = new Date();
		String fname = sf.format(d)+".png";
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File(fname);
		FileHandler.copy(src, dest);
		return(fname);
	}

}
