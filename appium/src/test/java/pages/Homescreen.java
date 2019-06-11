package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Homescreen {
	public AndroidDriver driver;
	@FindBy(xpath="//*[@content-desc='Minus']")
	public WebElement minus;
	@FindBy(xpath="//*[@content-desc='Plus']")
	public WebElement plus;
	@FindBy(xpath="//*[@content-desc='Multiplication']")
	public WebElement multiply;
	@FindBy(xpath="//*[@content-desc='Division']")
	public WebElement devide;
	@FindBy(xpath="//*[@content-desc='Clear']")
	public WebElement clear;
	@FindBy(xpath="//*[@content-desc='Equal']")
	public WebElement equal;
	@FindBy(xpath="//*[@class='android.widget.EditText']")
	public WebElement outputbox;
	public Homescreen(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void clickadd()
	{
		plus.click();
	}
	public void clickmiuns()
	{
		minus.click();
	}
	public void clickmultiply()
	{
		multiply.click();
	}
	public void clickdevide()
	{
		devide.click();
	}
	public String getOutput()
	{
		String o=outputbox.getAttribute("text");
		return(o);
	}
}
