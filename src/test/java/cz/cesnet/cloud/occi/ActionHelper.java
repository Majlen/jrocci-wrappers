package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.interfaces.core.Action;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ActionHelper {
	public static List<Action> filterStorageLinkActions(List<Action> actions) {
		return actions.stream()
				.filter(action -> action.getSchema().contains("storagelink"))
				.collect(Collectors.toList());
	}

	public static void testTerm(List<Action> actions) {
		for (Action a: actions) {
			Assert.assertTrue(a.getTerm().equals("online") || a.getTerm().equals("offline"));
		}
	}

	public static void testSchema(List<Action> actions) {
		for (Action a: actions) {
			Assert.assertEquals(a.getSchema(), "http://schemas.ogf.org/occi/infrastructure/storagelink/action#");
		}
	}

	public static void testTitle(List<Action> actions) {
		for (Action a: actions) {
			Assert.assertTrue(a.getTitle().equals("Change storagelink status to active") ||
					a.getTitle().equals("Change storagelink status to inactive"));
		}
	}

}
