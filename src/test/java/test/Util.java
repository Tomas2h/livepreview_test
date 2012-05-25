package test;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.chrome.ChromeDriverService;

import com.google.common.collect.ImmutableMap;

public abstract class Util {
  public static final String chromeDriverVersion = "20.0.1133.0";

	/**
	 * Only tested on Ubuntu. Will not work on windows.
	 * 
	 * http://stackoverflow.com/
	 * questions/4748673/how-can-i-check-the-bitness-of-
	 * my-os-using-java-j2se-not-os-arch
	 */
	public static boolean is64Bit() {
		final String arch = System.getProperty("os.arch");
		if (arch == null)
			return false;

		return arch.endsWith("64");
	}

	public static ChromeDriverService createAndStartService() {

		// Chrome must exist.
		if (!new File("/opt/google/chrome/google-chrome").exists()) {
			Assert.fail("Chrome symlink does not exist at /opt/google/chrome/google-chrome");
		}

		final String driver = Util.is64Bit() ? "chromedriver_linux64_" + chromeDriverVersion
				: "chromedriver_linux32_" + chromeDriverVersion;
		final File driverFile = new File("driver" + File.separator + driver);

		// Ensure executable bit is set on driver.
		driverFile.setExecutable(true);

		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingChromeDriverExecutable(driverFile).usingAnyFreePort()
				.withEnvironment(ImmutableMap.of("DISPLAY", ":9")).build();
		try {
			service.start();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return service;
	}
}
