package cz.cesnet.cloud.occi.interfaces.core;

import cz.cesnet.cloud.occi.interfaces.exceptions.ParsingException;

import javax.script.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public interface Model {
	List<Mixin> getMixins();
	List<Mixin> getResourceTpls();
	List<Mixin> getOsTpls();
	List<Action> getActions();

	static Model getModel(String model, String media_type) throws IOException, ScriptException, ParsingException {
		return new ModelImpl(model, media_type);
	}
}
