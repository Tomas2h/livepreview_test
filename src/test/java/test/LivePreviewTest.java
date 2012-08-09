package test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import test_util.Base;
import test_util.Util;

/**
 * Runs on local and travis-ci.org
 * http://travis-ci.org/#!/bootstraponline/livepreview_test
 **/
@RunWith(BlockJUnit4ClassRunner.class)
public class LivePreviewTest extends Base {
	// Must be static.
	private static ChromeDriverService service;

	// Must be static.
	@BeforeClass
	public static void createAndStartService() {
		service = Util.createAndStartService();
	}

	// Must be static.
	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	@Before
	public void setUp() {
		driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());
		exec = (JavascriptExecutor) driver;
	}
}