package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.MixinHelper;
import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import cz.cesnet.cloud.occi.interfaces.exceptions.ParsingException;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;


public class MixinTest {
	private List<Mixin> mixinsJson;

	@BeforeClass(dependsOnGroups = "modelJSON")
	public void setUp() throws ScriptException, IOException, ParsingException{
		Model model = Model.getModel(ModelHelper.getModel("/correct/model.json"), "application/json");
		mixinsJson = model.getOsTpls();
}

	@Test
	public void getTermMixinTest() {
		MixinHelper.testTerms(mixinsJson);
	}

	@Test
	public void getSchemaMixinTest() {
		MixinHelper.testSchemas(mixinsJson);
	}

	@Test
	public void getTitleMixinTest() {
		MixinHelper.testTitles(mixinsJson);
	}

	@Test
	public void getRelationsMixinTest() {
		MixinHelper.testRelations(mixinsJson);
	}

	@Test
	public void getActionsTest() {
		MixinHelper.testActions(mixinsJson);
	}
}
