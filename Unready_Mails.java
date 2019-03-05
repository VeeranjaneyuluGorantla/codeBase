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

public class Unready_Mails {

	public static void main(String[] args)throws Exception 
	{
		ExtentReports er=new ExtentReports("UnreadMails.html",false);
		ExtentTest et=er.startTest("unread mails count test");
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("gottipati.prasad9");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9494478104");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table)[4]")));
		//close notification 
		//driver.findElement(By.xpath("//*[@class='bBe']")).click();
		int enourm=0;
		do
		{
			WebElement mbt=driver.findElement(By.xpath("(//table)[4]/tbody"));
			List<WebElement> mail=mbt.findElements(By.tagName("tr"));
			int nourm = mail.size();
			System.out.println("total no of mails "+nourm);
			for(int i=1;i<=nourm;i++)
			{
				WebElement e=driver.findElement(By.xpath("(//table)[4]/tbody/tr["+i+"]/td[5]/div[1]"));
				driver.executeScript("var v=arguments[0].textContent; window.alert(v);",e);
				String x=driver.switchTo().alert().getText();
				driver.switchTo().alert().dismiss();
				if(x.contains("unread,"))
				{
					enourm=enourm+1;
				}
				Thread.sleep(2000);
			}
			//go to next page
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
				Thread.sleep(1000);
			}
			
		}while(2>1);
		System.out.println("Expected no.of unread mails "+enourm);
		//get actuval count of unreadmails
		String a=driver.findElement(By.xpath("//*[contains(@data-tooltip,'Inbox')]")).getAttribute("data-tooltip");
		String b=a.substring(7,a.length()-1);
		int anourm=Integer.parseInt(b);
		System.out.println("achuval no.of unread mails "+anourm);
		//validation
		if(enourm==anourm)
		{
			et.log(LogStatus.PASS,"uread mails count test passed");
			System.out.println("uread mails count test passed");
		}
		else
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			Date d=new Date();
			String fname=sf.format(d)+".png";
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(fname);
			FileHandler.copy(src,dest);
			et.log(LogStatus.FAIL,"unread mails count test failed");
			System.out.println("unread mails count test failed");
		}
		//Do logout
		driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']")));
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		// close site
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.close();
		//save reports
		er.endTest(et);
		er.flush();
	}//main()

}//class
