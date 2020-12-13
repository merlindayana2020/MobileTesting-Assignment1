package Assign1;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class assignment1 extends Base{
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = Capability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.cricbuzz.com/");
		//click on Menu
		driver.findElement(By.xpath("//*[text()='Menu']")).click();
		// click on home
		driver.findElement(By.xpath("//*[text()='Home']")).click();
		//scroll till top stories
		JavascriptExecutor js = (JavascriptExecutor)driver;
		AndroidElement ele = driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]"));
		Thread.sleep(6000);
		js.executeScript("arguments[0].scrollIntoView(false)",ele);
		//assert any text
		if(ele.getText().contains("Top Stories")) {
			System.out.print("able to Find Top Stories  -> ");
			System.out.print(driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]/..//a")).getText());
		}
				
		
	}

}
