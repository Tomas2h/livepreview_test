package sauce_test.gen;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ sauce_test.gen.tests.XP_Firefox_11.class,
		sauce_test.gen.tests.XP_Chrome.class,
		sauce_test.gen.tests.VISTA_Firefox_11.class,
		sauce_test.gen.tests.VISTA_Chrome.class,
		sauce_test.gen.tests.LINUX_Firefox_11.class,
		sauce_test.gen.tests.LINUX_Chrome.class })
public class SauceTestSuite {
}
