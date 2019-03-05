package testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiDropdown_DivTag {

	public static void main(String[] args) throws Exception{
		// Launch site
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		WebElement e = driver.findElement(By.xpath("//*[contains(@class,'ui fluid dropdown selection multiple')]"));
		Actions a = new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(5000);
		//get and display items
		List<WebElement> il=driver.findElements(By.xpath("//*[contains(@class,'ui fluid dropdown selection multiple')]/child::div[2]/div"));
		System.out.println("No:items is  "+il.size());
		for(int i=0;i<il.size();i++) {
			System.out.println(il.get(i).getText());
		}
		//select multiple items(6,8,18)
		il.get(5).click();
		Thread.sleep(5000);
		il.get(7).click();
		Thread.sleep(5000);
		il.get(17).click();
		Thread.sleep(5000);
		//get selected items
		List<WebElement> sl=driver.findElements(By.xpath("//*[contains(@class,'ui fluid dropdown selection multiple')]/a"));
		System.out.println("no of iteams in  selected items  "+sl.size());
		for(int j=0;j<sl.size();j++) {
			System.out.println(sl.get(j).getText());
		}
		Thread.sleep(5000);
		//deselect 2nd iteam
		driver.findElement(By.xpath("//*[contains(@class,'ui fluid dropdown selection multiple')]/a[2]/i")).click();
		//close site
		driver.close();

	}

}
