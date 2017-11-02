package cz.cesnet.cloud.occi.text;

import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.annotations.*;

import javax.script.ScriptException;
import java.io.IOException;

public class ModelTest {
	private String textModel;
	private Model model;

	@BeforeClass
	public void setUp() throws IOException {
		textModel = ModelHelper.getModel("/correct/model.txt");
	}

	@Test(groups = "modelText")
	public void parseCorrectModelTest() throws ScriptException, IOException {
		model = Model.getModel(textModel, "text/plain");
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
