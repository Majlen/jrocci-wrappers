package cz.cesnet.cloud.occi.interfaces.core;

import javax.script.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public interface Model {
	List<Mixin> getMixins();
	List<Mixin> getResourceTpls();
	List<Mixin> getOsTpls();

	static Model getModel(String model) throws IOException, ScriptException {
		return new ModelImpl(model);
	}
}