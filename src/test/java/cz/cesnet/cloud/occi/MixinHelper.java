package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.interfaces.core.Action;
import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import org.testng.Assert;

import java.util.List;

public class MixinHelper {
	public static void testTerms(List<Mixin> list) {
		for (Mixin m: list) {
			String term = m.getTerm();
			Assert.assertTrue(term.equals("appl0") || term.equals("appl1"));
		}
	}

	public static void testSchemas(List<Mixin> list) {
		for (Mixin m: list) {
			Assert.assertEquals(m.getSchema(), "http://schemas.localhost/occi/infrastructure/os_tpl#");
		}
	}

	public static void testTitles(List<Mixin> list) {
		for (Mixin m: list) {
			String title = m.getTitle();
			Assert.assertTrue(title.equals("Appliance Template - Appliance 0") || title.equals("Appliance Template - Appliance 1"));
		}
	}

	public static void testRelations(List<Mixin> list) {
		for (Mixin m: list) {
			Assert.assertEquals(m.getRelations().get(0).getTerm(), "os_tpl");
		}
	}

	public static void testActions(List<Mixin> list) {
		for (Mixin m: list) {
			Assert.assertEquals(m.getActions().size(), 0);
		}
	}
}
