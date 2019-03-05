package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args)throws Exception
	{
		// isDisplayed(), 
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// validate a radio button
		driver.findElement(By.partialLinkText("Flights")).click();
		Thread.sleep(2000);
		try 
		{
           WebElement e=driver.findElement(By.name("tripType"));
           if(e.isDisplayed())
           {
        	   System.out.println("Displayed");
        	   if(e.isEnabled())
        	   {
        		   System.out.println("Enabled");
        		   if(e.isSelected()) {
        			   System.out.println("selected");
        		   }
        		   else
        		   {
        			   System.out.println("not selected");
        		   }
        	   }
        	   else {
        		   System.out.println("disabled");
        	   }
           }
           else {
        	   System.out.println("Hidden");
           }
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		driver.close();
		

	}

}
