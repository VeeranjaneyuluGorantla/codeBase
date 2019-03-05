package testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class W2sms_XLS_File {

	public static void main(String[] args) throws Exception
	{
		// open .xls file for test data reading
		File f= new File("w2sms.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0); // 0 means 1st sheet
		int nour=rsh.getRows(); // count of used row results
		// open save excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0); // 0 means 1st sheet
		// create results column whis is next to last used column
		int nouc=rsh.getColumns();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date dt=new Date();
		String colname=sf.format(dt)+".png";
		Label l=new Label(nouc,0,colname);
		wsh.addCell(l);
		// data driven testing
		// 1st row(index is 0) have column names
		ChromeDriver driver=null;
		WritableFont wf=null;
		WritableCellFormat cf=null;
		// ccommon declaration for test passed
		wf=new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
		wf.setColour(Colour.GREEN);
		cf=new WritableCellFormat(wf);
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		for(int i=1;i<nour;i++)
		{
			String mbno=rsh.getCell(0,i).getContents();
			String mbnoc=rsh.getCell(1,i).getContents();
			String pwd=rsh.getCell(2,i).getContents();
			String pwdc=rsh.getCell(3,i).getContents();
			try
			{
				// launch site
				System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get("http://www.way2sms.com");
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				driver.manage().window().maximize();
				// do login
				driver.findElement(By.name("mobileNo")).sendKeys(mbno);
				driver.findElement(By.name("password")).sendKeys(pwd);
				driver.findElement(By.xpath("(//button[contains(text(),'Login')] )[1]")).click();
				Thread.sleep(5000);
				// validations
				if(mbno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
					Label l1=new Label(nouc,i,"Blank mobile number test passed");
					l1.setCellFormat(cf);
					wsh.addCell(l1);
				}
				else if(mbno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed())
				{
					Label l2=new Label(nouc,i,"mobile number length wrong test passed");
					l2.setCellFormat(cf);
					wsh.addCell(l2);
				}
				else if(pwd.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
				{
					Label l3=new Label(nouc,i,"blank password test passed");
					l3.setCellFormat(cf);
					wsh.addCell(l3);
				}
				else if(mbnoc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Your mobile number is not register with us.']")).isDisplayed())
				{
					Label l4=new Label(nouc,i,"wrong mobile number test passed");
					l4.setCellFormat(cf);
					wsh.addCell(l4);
				}
				else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Incorrect number or password! Try Again.']")).isDisplayed())
				{
					Label l5=new Label(nouc,i,"wrong password test passed");
					l5.setCellFormat(cf);
					wsh.addCell(l5);
				}
				else if(mbnoc.equalsIgnoreCase("valid") && pwdc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed()) 
				{
					
					Label l6=new Label(nouc,i,"valid data test passed");
					l6.setCellFormat(cf);
					wsh.addCell(l6);
				}
				else
				{
					// get screenshot
					String fname=sf.format(dt)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src, dest);
					// separate decorations for test failed
					Label l7=new Label(nouc,i,"login test failed"+fname);
					wf=new WritableFont(WritableFont.COURIER,20,WritableFont.BOLD);
					wf.setColour(Colour.RED);
					cf=new WritableCellFormat(wf);
					cf.setAlignment(Alignment.JUSTIFY);
					cf.setWrap(true);
					l7.setCellFormat(cf);
					wsh.addCell(l7);
				}
				// close site
				driver.quit();
			}
			catch(Exception ex)
			{
				driver.quit();
				Label l8=new Label(nouc,i,ex.getMessage());
				wsh.addCell(l8);
			}
		}// for
		// save results
		wwb.write();
		wwb.close();
		rwb.close();
	}

}
