package cz.cesnet.cloud.occi.text;

import cz.cesnet.cloud.occi.MixinHelper;
import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;


public class MixinTest {
	private List<Mixin> mixinsText;

	@BeforeClass(dependsOnGroups = "modelText")
	public void setUp() throws IOException, ScriptException {
		Model model = Model.getModel(ModelHelper.getModel("/correct/model.txt"), "text/plain");
		mixinsText = model.getOsTpls();
	}

	@Test
	public void getTermMixinTest() {
		MixinHelper.testTerms(mixinsText);
	}

	@Test
	public void getSchemaMixinTest() {
		MixinHelper.testSchemas(mixinsText);
	}

	@Test
	public void getTitleMixinTest() {
		MixinHelper.testTitles(mixinsText);
	}

	@Test
	public void getRelationsMixinTest() {
		MixinHelper.testRelations(mixinsText);
	}
}
