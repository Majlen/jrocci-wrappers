package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.interfaces.Initializer;
import org.testng.annotations.Test;

public class InitTest {
	@Test(groups = "init")
	public void createRubyLogger() {
		Initializer.initRubyLogger();
	}
}
