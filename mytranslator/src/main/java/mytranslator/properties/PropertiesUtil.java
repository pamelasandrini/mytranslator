package mytranslator.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Util class to get values from config file
 * 
 * @author pborsoni
 *
 */
public class PropertiesUtil {

	private Properties prop = new Properties();
	private String propFileName = "config.properties";

	public PropertiesUtil() {

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			try {
				prop.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error: Could not load the config file");
			}

		} else {
			System.out.println("property file " + propFileName + " not found in the classpath!");
		}

	}

	public String getValue(String key) {

		return prop.getProperty(key);
	}

}
