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

public class Gmail_Pwd_DDT {

	public static void main(String[] args) {
	    ArrayList<String> pwd=new ArrayList<String>();
	    ArrayList<String> cs=new ArrayList<String>();
	    Scanner sc=new Scanner(System.in);
	    System.out.println("enter pwd size");
	    int noi=Integer.parseInt(sc.nextLine());
	    for(int i=0;i<noi;i++)
	    {
	    	System.out.println("enter pwd data");
	    	pwd.add(sc.nextLine());
	    	System.out.println("enter criteria");
	    	cs.add(sc.nextLine());
	    }
	    // html report file
	    ExtentReports er=new ExtentReports("GmailpwdDDT.html",false);
	    ExtentTest et=er.startTest("gmail pwd testing");
	    ChromeDriver driver=null;
	    //data driven testing
	    for(int i=0;i<noi;i++)
	    {
	    	try
	    		{
	    		//launch site
	    		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
	    		driver=new ChromeDriver();
	    		driver.manage().window().maximize();
	    		driver.get("http://www.gmail.com");
	    		WebDriverWait w=new WebDriverWait(driver,20);
	    		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
	    		driver.findElement(By.name("identifier")).sendKeys("g.veeru124");
	    		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
	    		driver.findElement(By.xpath("//*[text()='Next']")).click();
	    		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	    		driver.findElement(By.name("password")).sendKeys(pwd.get(i));
	    		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
	    		driver.findElement(By.xpath("//*[text()='Next']")).click();
	    		Thread.sleep(5000);
	    		if(pwd.get(i).length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
	    		{
	    			et.log(LogStatus.PASS,"Blank pwd test passed");
	    		}
	    		else if(cs.get(i).equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
	    		{
	    			et.log(LogStatus.PASS,"Wrong pwd test passed");
	    		}
	    		else if(cs.get(i).equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='Compose']")).isDisplayed())
	    		{
	    			et.log(LogStatus.PASS,"Valid pwd test passed");
	    		}
	    		else
	    		{
	    			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
	    			Date d=new Date();
	    			String fname=sf.format(d)+".png";
	    			File src=driver.getScreenshotAs(OutputType.FILE);
	    			File dest=new File(fname);
	    			FileHandler.copy(src,dest);
	    			et.log(LogStatus.FAIL,"pwd testing failed"+et.addScreenCapture(fname));
	    		}
	    		// close site
	    		driver.close();
	    	}//try
	    	catch(Exception ex)
	    	{
	    		et.log(LogStatus.ERROR,ex.getMessage());
	    		driver.close();
	    		
	    	}
	    }//for
	    // save reports
	    er.endTest(et);
	    er.flush();

	}//main()

}//class
