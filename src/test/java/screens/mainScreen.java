package screens;

import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;

import base.MobileActions;

public class mainScreen extends ScreenBase{

	public mainScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	MobileActions action = new MobileActions(driver);
	
	
	
	public void scrollToBottom() throws InterruptedException {
		waitForElement("//android.widget.ImageView[@content-desc='Anurut Malhan']","xpath");
		AndroidElement startElement = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Anurut Malhan']"));
		
		if(startElement.isDisplayed()) {
			System.out.println();
			System.out.println("---- Swiping down down down ----");
			action.verticalSwipeByPercentages(0.99, 0.45, 0.5);
			Thread.sleep(1000);
			action.verticalSwipeByPercentages(0.99, 0.45, 0.5);
			Thread.sleep(1000);
			action.verticalSwipeByPercentages(0.99, 0.45, 0.5);
		}
	}
	
	
	public void enterGame() {
		
		AndroidElement endElement = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Tez Shots']"));
		if(endElement.isDisplayed()) {
			endElement.click();
			
		}
		
	}
}
