package testing;

	import java.io.File;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Scanner;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	public class GoogleTitle_Automation {

		public static void main(String[] args)throws Exception {
			// make results file
			/*ExtentReports er = new ExtentReports("Googleres.html");
			ExtentTest et=er.startTest("Googet result title test");*/
			// get data from key board
			Scanner sc = new Scanner(System.in);
			String x = sc.nextLine();
			//launch site
			System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.google.co.in");
			/*WebDriverWait w = new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
			driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
			Thread.sleep(5000);
			while(2>1)
			{
				String t = driver.getTitle(); 
				if(!t.contains(x))
				{
					SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
					Date d = new Date();
					String fname = sf.format(d)+".png";
					File src = driver.getScreenshotAs(OutputType.FILE);
					File dest = new File(fname);
					FileHandler.copy(src,dest);
					//display results as test failed
					et.log(LogStatus.FAIL,"Google title test failed"+et.addScreenCapture(fname));
					//teriminate from loop
					break;
				}
			
			//goto next page
			try
			{
				if(driver.findElement(By.xpath("//*[text()='Next']")).isDisplayed())
				{
					driver.findElement(By.xpath("//*[text()='Next']")).click();
				}
			}
			catch(Exception ex)
			{
				et.log(LogStatus.PASS,"Google title test passed");
				break;
			}
		}//while()		
			//close site
			driver.close();
			//save results
			er.endTest(et);
			er.flush();*/
		}//main()

	}//class

