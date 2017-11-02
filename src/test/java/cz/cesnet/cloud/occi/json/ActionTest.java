package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.ActionHelper;
import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Action;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

public class ActionTest {
	List<Action> actions;

	@BeforeClass(dependsOnGroups = "modelJSON")
	public void setUp() throws IOException, ScriptException {
		try {
			Model model = Model.getModel(ModelHelper.getModel("/correct/model.json"), "application/json");
			actions = ActionHelper.filterStorageLinkActions(model.getActions());
		} catch (Exception e) {
			throw new SkipException("Expected to fail before bugfix in json-schema gem");
		}
	}

	@Test
	public void getTermActionTest() {
		ActionHelper.testTerm(actions);
	}

	@Test
	public void getSchemaActionTest() {
		ActionHelper.testSchema(actions);
	}

	@Test
	public void getTitleActionTest() {
		ActionHelper.testTitle(actions);
	}
}
