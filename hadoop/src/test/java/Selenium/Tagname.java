package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tagname {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String tagname="";
		tagname=driver.findElement(By.id("email")).getTagName();
		System.out.println(tagname);
		driver.close();

	}

}
