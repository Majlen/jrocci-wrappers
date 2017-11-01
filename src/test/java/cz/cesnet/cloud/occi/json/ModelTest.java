package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

public class ModelTest {
	private String textModel;
	private Model model;

	@BeforeClass(dependsOnGroups = "init")
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
		List<Mixin> OSList = model.getOsTpls();
		Assert.assertEquals(OSList.size(), 2);
	}

	@Test(dependsOnMethods = {"parseCorrectModelTest"})
	public void getResTplModelTest() {
		List<Mixin> ResList = model.getResourceTpls();
		Assert.assertEquals(ResList.size(), 2);
	}

	@Test(dependsOnMethods = {"parseCorrectModelTest"})
	public void getMixinsModelTest() {
		List<Mixin> MixinList = model.getMixins();
		Assert.assertEquals(MixinList.size(), 20);
	}

}
