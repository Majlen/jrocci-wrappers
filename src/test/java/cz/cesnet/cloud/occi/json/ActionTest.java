package cz.cesnet.cloud.occi.json;

import cz.cesnet.cloud.occi.ActionHelper;
import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Action;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import cz.cesnet.cloud.occi.interfaces.exceptions.ParsingException;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

public class ActionTest {
	private List<Action> actions;

	@BeforeClass(dependsOnGroups = "modelJSON")
	public void setUp() throws IOException, ScriptException, ParsingException {
		Model model = Model.getModel(ModelHelper.getModel("/correct/model.json"), "application/json");
		actions = ActionHelper.filterStorageLinkActions(model.getActions());
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
