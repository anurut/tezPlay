package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import screens.TezShotsScreen;
import screens.mainScreen;

import base.TestBase;

public class NewTest extends TestBase{

	@BeforeTest
	public void init() {
		softAssertion = new SoftAssert();
	}
	
	
	@Test
	public void tst() throws InterruptedException {
		mainScreen = new mainScreen(driver);
		mainScreen.scrollToBottom();
	}
	
	@Test(dependsOnMethods = "tst")
	public void tst1() {
		mainScreen.enterGame();
	}
	
	@Test(dependsOnMethods = "tst1")
	public void tst2() throws InterruptedException {
		gameScreen = new TezShotsScreen(driver);
		gameScreen.playGame();
	}
	
	
}
