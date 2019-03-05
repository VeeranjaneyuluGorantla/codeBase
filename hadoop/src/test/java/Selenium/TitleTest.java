package Selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class TitleTest {

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		String expectedtitle="Welcome: Mercury Tours";
		String actuvaltitle="";
		actuvaltitle=driver.getTitle();
		System.out.println(actuvaltitle);
		if(actuvaltitle.contentEquals(expectedtitle))
		{
			System.out.println("title test passed");
		}
		else {
			System.out.println("title test failed");
		}
		Thread.sleep(5000);
		driver.close();

	}

}
