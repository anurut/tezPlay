package screens;

import org.openqa.selenium.By;

import base.MobileActions;
import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TezShotsScreen extends ScreenBase{

	public TezShotsScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	MobileActions action = new MobileActions(driver);
	private String playNowButtonClass = "android.widget.Button";
	
	private String playAgaintext = "android.view.View"; //Play again?
	
	private String yesButton = "android.widget.Button";//index 2 bounds = [582,2117][787,2201]
	
	public void playGame() throws InterruptedException {
		AndroidElement playNowButton = getListElement("Play no", driver.findElements(By.className(playNowButtonClass)));
		if(playNowButton.isDisplayed()) {
			playNowButton.click();
			Thread.sleep(4000);
		}
		long count = 0;
		while(count !=300) {
		System.out.println("*Hitting*");
			action.tapByCoordinates(590, 2190);
			System.out.println(count);
			count++;
		}
		
		for(int i=0; i<340; i++) {
			System.out.println("*Hitting*");
			action.tapByCoordinates(590, 2190);
		}
	}
	
	
}
