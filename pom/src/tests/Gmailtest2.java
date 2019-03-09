package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import pages.Composepage;
import pages.Homepage;
import pages.Loginpage;

public class Gmailtest2 {

	public static void main(String[] args) throws Exception 
	{
		// open file for reading
		File f=new File("gmailtestdata.xls");
		Workbook wrb=Workbook.getWorkbook(f);
		Sheet rsh=wrb.getSheet(0);
		int nour=rsh.getRows();
		int nouc=rsh.getColumns();
		// open excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,wrb);
		WritableSheet wsh=wwb.getSheet(0);
		// create column heading for results
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date d=new Date();
		String cname=sf.format(d);
		Label l=new Label(nouc,0,cname);
		wsh.addCell(l);
		// data driven with pom
		// 1st row (index = 0) have column names
		for(int i=1;i<nour;i++)
		{
			String p=rsh.getCell(0,i).getContents();
			String pc=rsh.getCell(1,i).getContents();
			// launch site
			System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.gmail.com");
			driver.manage().window().maximize();
			// create objects to page classes
			Homepage hp=new Homepage(driver);
			Loginpage lp=new Loginpage(driver);
			Composepage cp=new Composepage(driver);
			// automation code
			WebDriverWait w=new WebDriverWait(driver,50);
			w.until(ExpectedConditions.visibilityOf(hp.uid));
			hp.filluid("g.veeru124");
			w.until(ExpectedConditions.elementToBeClickable(hp.uidnext));
			hp.uidclicknext();
			w.until(ExpectedConditions.visibilityOf(lp.pwd));
			lp.fillpwd(p);
			w.until(ExpectedConditions.elementToBeClickable(lp.pwdnext));
			lp.pwdclicknext();
			Thread.sleep(5000);
			// validations
			try
			{
				if(p.length()==0 && lp.pwdblankerr.isDisplayed())
				{
					Label l1=new Label(nouc,i,"Blank pwd test passed");
					wsh.addCell(l1);
				}
				else if(pc.equalsIgnoreCase("invalid") && lp.pwdinvaliderr.isDisplayed())
				{
					Label l2=new Label(nouc,i,"invalid password test passed");
					wsh.addCell(l2);
				}
				else if(pc.equalsIgnoreCase("valid") && cp.comp.isDisplayed())
				{
					Label l3=new Label(nouc,i,"password test passed");
					wsh.addCell(l3);
				}
				else
				{
					String fname=sf.format(d)+".png";
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					Label l4=new Label(nouc,i,"pwd test failed"+fname);
					wsh.addCell(l4);
				}
			}
			catch(Exception ex)
			{
				Label l5=new Label(nouc,i,ex.getMessage());
				wsh.addCell(l5);
				
			}
			// close site
			driver.close();
		}
		//save and close excel
		wwb.write();
		wwb.close();
		wrb.close();
	}

}

