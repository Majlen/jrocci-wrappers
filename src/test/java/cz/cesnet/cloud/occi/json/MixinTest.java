package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.MixinHelper;
import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;


public class MixinTest {
	private List<Mixin> mixinsJson;

	@BeforeClass(dependsOnGroups = "modelJSON")
	public void setUp() {
		try {
			Model model = Model.getModel(ModelHelper.getModel("/correct/model.json"), "application/json");
			mixinsJson = model.getOsTpls();
		} catch (Exception e) {
			throw new SkipException("Expected to fail before bugfix in json-schema gem");
		}
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
}
