package cz.cesnet.cloud.occi.text;

import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

public class ModelTest {
	private String textModel;
	private Model model;

	@BeforeClass(dependsOnGroups = "init")
	public void setUp() throws IOException {
		textModel = ModelHelper.getModel("/correct/model.txt");
	}

	@Test(groups = "modelText")
	public void parseCorrectTextModelTest() throws ScriptException, IOException {
		model = Model.getModel(textModel, "text/plain");
	}

	@Test(dependsOnMethods = {"parseCorrectTextModelTest"})
	public void getOSTplModelTest() {
		List<Mixin> OSList = model.getOsTpls();
		Assert.assertEquals(OSList.size(), 2);
	}

	@Test(dependsOnMethods = {"parseCorrectTextModelTest"})
	public void getResTplModelTest() {
		List<Mixin> ResList = model.getResourceTpls();
		Assert.assertEquals(ResList.size(), 2);
	}

	@Test(dependsOnMethods = {"parseCorrectTextModelTest"})
	public void getMixinsModelTest() {
		List<Mixin> MixinList = model.getMixins();
		Assert.assertEquals(MixinList.size(), 20);
	}

}
