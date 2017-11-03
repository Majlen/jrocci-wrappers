package cz.cesnet.cloud.occi.text;

import cz.cesnet.cloud.occi.ActionHelper;
import cz.cesnet.cloud.occi.ModelHelper;
import cz.cesnet.cloud.occi.interfaces.core.Action;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import cz.cesnet.cloud.occi.interfaces.exceptions.ParsingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.List;

public class ActionTest {
	List<Action> actions;

	@BeforeClass(dependsOnGroups = "modelText")
	public void setUp() throws IOException, ScriptException, ParsingException {
		Model model = Model.getModel(ModelHelper.getModel("/correct/model.txt"), "text/plain");
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
