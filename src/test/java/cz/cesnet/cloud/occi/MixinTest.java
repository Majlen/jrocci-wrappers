package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;


public class MixinTest {
	private List<Mixin> mixins;

	@BeforeClass(dependsOnGroups = "model")
	public void setUp() throws IOException, ScriptException {
		Model model = Model.getModel(ModelHelper.getTextModel());
		mixins = model.getOsTpls();
	}

	@Test
	public void getTermMixinTest() {
		for (Mixin m: mixins) {
			String term = m.getTerm();
			Assert.assertTrue(term.equals("uuid_cernvm_3_3_0_40gb_fedcloud_dukan_80") || term.equals("uuid_egi_fedora_25_fedcloud_warg_189"));
		}
	}

	@Test
	public void getSchemaMixinTest() {
		for (Mixin m: mixins) {
			Assert.assertEquals(m.getSchema(), "http://occi.localhost/occi/infrastructure/os_tpl#");
		}
	}

	@Test
	public void getTitleMixinTest() {
		for (Mixin m: mixins) {
			String title = m.getTitle();
			Assert.assertTrue(title.equals("CERNVM-3.3.0-40GB@fedcloud-dukan") || title.equals("EGI-Fedora-25@fedcloud-warg"));
		}
	}

	@Test
	public void getRelationsMixinTest() {
		for (Mixin m: mixins) {
			Assert.assertEquals(m.getRelations().get(0).getTerm(), "os_tpl");
		}
	}
}
