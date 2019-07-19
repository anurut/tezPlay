package base;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class MobileActions {

	private AndroidDriver<AndroidElement> driver;

	public MobileActions (AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	//Tap to an element for 250 milliseconds
	public void tapByElement (AndroidElement androidElement) {
		new TouchAction(driver)
		.tap(tapOptions().withElement(element(androidElement)))
		.waitAction(waitOptions(Duration.ofMillis(250))).perform();
	}

	//Tap by coordinates
	public void tapByCoordinates (int x,  int y) {
		new TouchAction(driver)
		.tap(point(x,y))
		.waitAction(waitOptions(Duration.ofMillis(100))).perform();
	}

	//Press by element
	public void pressByElement (AndroidElement element, long seconds) {
		new TouchAction(driver)
		.press(element(element))
		.waitAction(waitOptions(ofSeconds(seconds)))
		.release()
		.perform();
	}

	//Press by coordinates
	public void pressByCoordinates (int x, int y, long seconds) {
		new TouchAction(driver)
		.press(point(x,y))
		.waitAction(waitOptions(ofMillis(seconds)))
		.release()
		.perform();
	}

	//Horizontal Swipe by percentages
	public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * endPercentage);

		new TouchAction(driver)
		.press(point(startPoint, anchor))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endPoint, anchor))
		.release().perform();
	}

	//Vertical Swipe by percentages
	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);
		int anchor = (int) (size.width * anchorPercentage);
		System.out.println("anchor point : " + anchor);
		int startPoint = (int) (size.height * startPercentage);
		System.out.println("start point : " + startPoint);
		int endPoint = (int) (size.height * endPercentage);
		System.out.println("end point : " + endPoint);

		new TouchAction(driver)
		.press(point(anchor, startPoint))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(anchor, endPoint))
		.release().perform();
	}

	//Swipe by elements
	public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

		new TouchAction(driver)
		.press(point(startX,startY))
		.waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endX, endY))
		.release().perform();
	}

	//Multi-touch action by using an android element
	public void multiTouchByElement (AndroidElement androidElement) {
		TouchAction press = new TouchAction(driver)
				.press(element(androidElement))
				.waitAction(waitOptions(ofSeconds(1)))
				.release();

		new MultiTouchAction(driver)
		.add(press)
		.perform();
	}
}
