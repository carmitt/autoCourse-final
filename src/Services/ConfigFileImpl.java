package Services;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileImpl implements IConfigService {

	Properties properties = null;

	@Override
	public void load(String env) throws Exception {
		properties = new Properties();

		FileInputStream fileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "/files/config/" + env + ".prop"));

		// globalProperties.load(fileInputStream);

		properties.load(fileInputStream);

		fileInputStream.close();

	}

	@Override
	public String getProperty(String propName) {
		return properties.getProperty(propName);

	}

	

	@Override
	public String getEnv() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSut() {
		// TODO Auto-generated method stub
		return null;
	}

}
