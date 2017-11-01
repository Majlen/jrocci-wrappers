package cz.cesnet.cloud.occi.interfaces;

public interface Initializer {
	void initLogger();

	static void initRubyLogger() {
		Initializer i = new InitializerImpl();
		i.initLogger();
	}
}
