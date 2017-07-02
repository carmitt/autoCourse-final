package Services;

import java.util.Properties;



public interface IConfigService {

	public void load(String env) throws Exception;

	public String getProperty(String propName);

	public String getEnv();

	public String getSut();

}
