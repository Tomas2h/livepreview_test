package test_util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/* For Sauce Labs OnDemand. */
public class Sauce extends Base {
	protected void setUpDriver(final DesiredCapabilities capabillities) {
		// Don't record videos.
		// capabillities.setCapability("record-video", false);
		// Don't record screenshots.
		// capabillities.setCapability("record-screenshots", false);

		try {
			driver = new RemoteWebDriver(new URL(Util.getSauceKey()),
					capabillities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		exec = (JavascriptExecutor) driver;
	}
}
