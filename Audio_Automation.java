package testing;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Audio_Automation {
	public static void main(String[] args) throws InterruptedException {
		//get text
		Scanner sc = new Scanner(System.in);
		System.out.println("ente your text");
		String x = sc.nextLine();
		//Launch site
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--use-fake-ui-for-media-stream=1");
		System.setProperty("webdriver.chrome.driver", "D:\\batch241\\chromedriver.exe");
		ChromeDriver driver  = new ChromeDriver(o);
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.id("gsri_ok0")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("spchb")));
		System.setProperty("mbrola.base", "F:\\batch241\\mbrola");
		VoiceManager vm = VoiceManager.getInstance();
		Voice v = vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
	}

}
