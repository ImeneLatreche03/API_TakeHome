package resources;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static String getToken() {
		String token = "";
		try {
			InputStream input = new FileInputStream(projectPath + "/src/test/java/resources/config.properties");
			prop.load(input);
			token = prop.getProperty("token");

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return token;
	}

	public static String getBaseUri() {
		String baseUri = "";
		try {
			InputStream input = new FileInputStream(projectPath + "/src/test/java/resources/config.properties");
			prop.load(input);
			baseUri = prop.getProperty("baseUri");

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return baseUri;
	}
}
