package test_util;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static test_util.JavaScript.*;

/* For local WebDriver and travis-ci.
 * Sauce tests must extend Sauce.
 * 
 *  Subclasses must define their own @Before. */
public class Base extends TestCase {
	// Default Timeout.
	private final int t = 5;

	private static final String someText = someText().toString();
	private static final String setupGlobals = setupGlobals().toString();
	private static final String childrenLength = childrenLength().toString();
	private static final String firstChildHTML = firstChildHTML().toString();
	private static final String firstChildTagName = firstChildTagName()
			.toString();
	private static final String checkCodeStyle0 = checkCodeStyle0().toString();
	private static final String checkCodeStyle1 = checkCodeStyle1().toString();
	private static final String checkCodeStyle2 = checkCodeStyle2().toString();

	protected WebDriver driver;
	protected JavascriptExecutor exec;

	@Override
	public void tearDown() throws Exception {
		driver.quit();
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

	private void assertTitleChangedToContain(final String newTitle) {
		assertTitleChangedToContain(newTitle, t);
	}

	/**
	 * Waits for a new title.
	 * 
	 * @param newTitle
	 *            Title to wait for.
	 * @param timeOutInSeconds
	 *            Timeout in seconds
	 */
	private void assertTitleChangedToContain(final String newTitle,
			final long timeOutInSeconds) {
		try {
			new WebDriverWait(driver, timeOutInSeconds)
					.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(final WebDriver driver) {
							if (driver.getTitle().contains(newTitle))
								return true;
							return false;
						}
					});
		} catch (final Throwable t) {
			Assert.fail("Title did not change to contain " + newTitle
					+ " within " + timeOutInSeconds + " seconds. Title is: "
					+ driver.getTitle());
		}
	}

	public void exe(final String javascript) {
		exec.executeScript(javascript);
	}

	public void exeTrue(final String javascript) {
		assertTrue((Boolean) exec.executeScript("return " + javascript));
	}

	/* Only for debugging. */
	public void printTest(final String javascript) {
		System.out.println("return " + javascript);
	}

	public void go(final String url) {
		driver.get(url);
	}

	@Test
	public void testLivePreview() {
		go("http://bootstraponline.github.com/livepreview/public/");
		assertTitleChangedToContain("Live Preview");

		// Remove onbeforeunload.
		exe("window.onbeforeunload = null;");

		final String expectedLocation = "window.location.protocol + '//' + window.location.host == 'http://bootstraponline.github.com';";
		exeTrue(expectedLocation);

		// Check get and set of document text.
		exe("$.editorSession.setValue(" + someText + ")");
		final String expectedText = "$.editorSession.getValue() == " + someText
				+ ";";
		exeTrue(expectedText);

		// Check that text rendered as expected.
		// Setup globals first.
		exe(setupGlobals);
		exeTrue(childrenLength);
		exeTrue(firstChildHTML);
		exeTrue(firstChildTagName);
		exeTrue(checkCodeStyle0);
		exeTrue(checkCodeStyle1);
		exeTrue(checkCodeStyle2);

		// Check default commit message.
		final String expectedDefaultCommitMessage = "$.commentSession.getValue() == 'Updated 0 (markdown)'";
		exeTrue(expectedDefaultCommitMessage);

		// Check custom commit message.
		exe("$.commentSession.setValue('custom msg')");

		final String expectedCustomMessage = "$.commentSession.getValue() == 'custom msg';";
		exeTrue(expectedCustomMessage);
	}
}
