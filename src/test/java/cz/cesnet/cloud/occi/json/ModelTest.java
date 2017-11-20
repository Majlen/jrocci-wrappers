package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import cz.cesnet.cloud.occi.interfaces.exceptions.ParsingException;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;

public class ModelTest {
	private String textModel;
	private Model model;

	@BeforeClass
	public void setUp() throws IOException {
		textModel = ModelHelper.getModel("/correct/model.json");
	}

	@Test(groups = "modelJSON")
	public void parseCorrectModelTest() throws ScriptException, IOException, ParsingException {
		model = Model.getModel(textModel, "application/json");
	}

	@Test(dependsOnMethods = {"parseCorrectModelTest"})
	public void getOSTplModelTest() {
		ModelHelper.testOSTpls(model);
	}

	@Test(dependsOnMethods = {"parseCorrectModelTest"})
	public void getResTplModelTest() {
		ModelHelper.testResTpls(model);
	}

	@Test(dependsOnMethods = {"parseCorrectModelTest"})
	public void getMixinsModelTest() {
		ModelHelper.testMixins(model);
	}

	@Test(dependsOnMethods = {"parseCorrectModelTest"})
	public void getActionsModelTest() {
		ModelHelper.testActions(model);
	}
}
