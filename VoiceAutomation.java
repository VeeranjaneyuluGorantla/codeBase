package testing;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceAutomation {

	public static void main(String[] args) throws Exception {
		// get data from key board
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your text");
		String x=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.chrome.driver","D:\\batch241\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--use-fake-ui-for-media-stream=1");
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//click on mic
		driver.findElement(By.id("gsri_ok0")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("spch")));
		//send voice (freetts+mbrola+vb_cable driver)
		System.setProperty("mbrola.base","F:\\batch241\\mbrola");
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
		//close site
		/*Thread.sleep(1000);
		driver.close();*/

	}

}
