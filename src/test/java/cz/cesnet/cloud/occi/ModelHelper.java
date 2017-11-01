package cz.cesnet.cloud.occi;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
}
