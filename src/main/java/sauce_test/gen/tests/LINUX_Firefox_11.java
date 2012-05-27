package sauce_test.gen.tests;

import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import test_util.Sauce;
import static test_util.Util.timeNow;

public class LINUX_Firefox_11 extends Sauce {

	@Before
	public void setUp() {
		final DesiredCapabilities capabillities = DesiredCapabilities.firefox();
		capabillities.setCapability("version", "11");
		capabillities.setCapability("platform", Platform.LINUX);
		capabillities.setCapability("name", "LINUX_Firefox_11_" + timeNow());

		setUpDriver(capabillities);
	}
}