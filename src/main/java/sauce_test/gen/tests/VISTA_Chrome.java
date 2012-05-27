package sauce_test.gen.tests;

import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import test_util.Sauce;
import static test_util.Util.timeNow;

public class VISTA_Chrome extends Sauce {

	@Before
	public void setUp() {
		final DesiredCapabilities capabillities = DesiredCapabilities.chrome();
		capabillities.setCapability("platform", Platform.VISTA);
		capabillities.setCapability("name", "VISTA_Chrome_" + timeNow());

		setUpDriver(capabillities);
	}
}