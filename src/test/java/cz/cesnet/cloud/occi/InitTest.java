package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.interfaces.Initializer;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class InitTest {
	@BeforeSuite
	public void createRubyLogger() {
		Initializer.initRubyLogger();
	}

	@Test
	public void rubyLoggerTest() {
		Initializer.initRubyLogger();
	}
}
