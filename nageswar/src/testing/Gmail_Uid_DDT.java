package testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class Gmail_Uid_DDT 
{
	public static void main(String[] args)throws Exception
	{
		ArrayList<String> uid=new ArrayList<String>();
		ArrayList<String> cs=new ArrayList<String>();
		// take an array
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Array Size");
		int noi=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("Enter uid data");
			uid.add(sc.nextLine());
			System.out.println("Enter Criteria");
			cs.add(sc.nextLine());
		}
		// Extend Reports
		ExtentReports er=new ExtentReports("EmailUidDDT.html",false);
		ExtentTest et=er.startTest("Gmail uid Testing");
		ChromeDriver driver=null;
		//data driven testing
		for(int i=0;i<noi;i++)
		{
			try {
				// launch site
				System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://www.gmail.com");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
				driver.findElement(By.name("identifier")).sendKeys(uid.get(i));
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(2000);
				//w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
				//validations
				if(uid.get(i).length()==0 && driver.findElement(By.xpath("//*[text()='Enter an email or phone number']")).isDisplayed())
				{
					et.log(LogStatus.PASS,"Blank test passed");
				}
				else if(cs.get(i).equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),'find your Google Account')])[2]")).isDisplayed())
				{
					et.log(LogStatus.PASS,"invalid uid test passed");
				}
				else if(cs.get(i).equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
				{
					et.log(LogStatus.PASS,"valid uid test passed");
				}
				else
				{
					SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mmss");
					Date d=new Date();
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					et.log(LogStatus.FAIL,"uid test failed"+et.addScreenCapture(fname));
				}
				//close site
				driver.close();
			}//try
			catch(Exception ex)
			{
				et.log(LogStatus.ERROR,ex.getMessage());
				driver.close();
			}
		}//for
		//save reports
		er.endTest(et);
		er.flush();
	}//main()
}//class
