package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ModelTest {
	private String textModel;
	private Model model;

	@BeforeClass
	public void setUp() throws IOException {
		textModel = ModelHelper.getModel("/correct/model.json");
	}

	@Test(groups = "modelJSON")
	public void parseCorrectModelTest() {
		try {
			model = Model.getModel(textModel, "application/json");
		} catch (Exception e) {
			throw new SkipException("Expected to fail before bugfix in json-schema gem");
		}
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

}
