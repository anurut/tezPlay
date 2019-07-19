package base;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import screens.TezShotsScreen;
import screens.mainScreen;
import utils.commonUtils;


@Listeners({TestListener.class})
public class TestBase {


	public static mainScreen mainScreen;
	public static TezShotsScreen gameScreen;
	
	public static AndroidDriver<AndroidElement> driver;

	public static String loadPropertyFile = "Android_phoneCash.properties";

	public SoftAssert softAssertion;

	@BeforeSuite
	public void setUp() throws IOException {


		//load properties file, desired capabilities, initialize Android driver
		if(driver == null) {

			if (loadPropertyFile.startsWith("Android")){

				//load Android properties
				System.out.println("Inside TestBase.setUP method");
				commonUtils.loadAndroidConfigProperties(loadPropertyFile);
				System.out.println("Loaded property file");
				commonUtils.setAndroidCapabilities();
				System.out.println("Setup AndroidCapabilities");
				driver = commonUtils.getAndroidDriver();
				System.out.println("Got Android Driver");

			}else if (loadPropertyFile.startsWith("iOS")) {

				//load iOS properties
			}
		}
	}

	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		//service.stop();
	}
}
