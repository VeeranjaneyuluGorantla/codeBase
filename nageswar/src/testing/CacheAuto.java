package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CacheAuto {

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// fill text box with data 
		driver.findElement(By.name("q")).sendKeys("abul kalam");
		Thread.sleep(1000);
		// get count items in code
		List<WebElement> l=driver.findElements(By.xpath("//*[@role='listbox']/li"));
		int cs=l.size(); 
		System.out.println(cs);
        Actions a=new Actions(driver);
        int flag=0;
        for(int i=1;i<cs;i++)
        {
        	a.sendKeys(Keys.DOWN).build().perform();
        	Thread.sleep(1000);
        	if(i==3)
        	{
        		a.sendKeys(Keys.ENTER).build().perform();
        		break;
        	}
        }
        
        //driver.close();
	}

}
