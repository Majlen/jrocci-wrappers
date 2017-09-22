package cz.cesnet.cloud.occi.interfaces.core;

import java.util.List;

public interface Mixin {
	List<Mixin> getRelations();
	String getTerm();
	String getSchema();
	String getTitle();
}
