package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.exceptions.ParsingException;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;

public class MalformedModelTest {
	private String textModel;
	private Model model;

	@BeforeClass
	public void setUp() throws IOException {
		textModel = ModelHelper.getModel("/malformed/model.json");
	}

	@Test(groups = "modelJSON", expectedExceptions = ParsingException.class)
	public void parseMalformedModelTest() throws ScriptException, IOException, ParsingException {
		model = Model.getModel(textModel, "application/json");
	}
}
