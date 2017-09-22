package cz.cesnet.cloud.occi.interfaces.api;

import cz.cesnet.cloud.occi.interfaces.core.Model;

import javax.script.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public interface Client {
	Model getModel();

	static Client getClientTokenAuth() throws IOException, ScriptException {
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine rubyEngine = m.getEngineByName("jruby");

		InputStream is = Model.class.getResourceAsStream("/clientAuthHelpers/token.rb");
		InputStreamReader file = new InputStreamReader(is);
		Object receiver = rubyEngine.eval(file);
		is.close();
		file.close();

		return ((Invocable)rubyEngine).getInterface(receiver, Client.class);
	}
}
