package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.interfaces.core.Mixin;
import cz.cesnet.cloud.occi.interfaces.core.Model;
import org.testng.Assert;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ModelHelper {

	public static String getModel(String res) throws IOException {

		BufferedInputStream is = new BufferedInputStream(ModelHelper.class.getResourceAsStream(res));
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		int result = is.read();
		while(result !=-1)

		{
			out.write((byte) result);
			result = is.read();
		}

		return out.toString(StandardCharsets.UTF_8.name());
	}

	public static void testOSTpls(Model m) {
		List<Mixin> OSList = m.getOsTpls();
		Assert.assertEquals(OSList.size(), 2);
	}

	public static void testResTpls(Model m) {
		List<Mixin> ResList = m.getResourceTpls();
		Assert.assertEquals(ResList.size(), 2);
	}

	public static void testMixins(Model m) {
		List<Mixin> mixinList = m.getMixins();
		Assert.assertEquals(mixinList.size(), 20);
	}

}
