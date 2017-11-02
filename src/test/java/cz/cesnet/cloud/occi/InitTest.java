package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.interfaces.Initializer;
import org.testng.annotations.BeforeSuite;

public class InitTest {
	@BeforeSuite
	public void createRubyLogger() {
		Initializer.initRubyLogger();
	}
}
