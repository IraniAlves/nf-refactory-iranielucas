package br.com.iranielucas.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ApplicationConfiguration {
	private static final Logger logger = Logger.getLogger(ApplicationConfiguration.class);
	private static String confPath;
	private static Properties properties;
	private static ApplicationConfiguration instance;

	@SuppressWarnings("static-access")
	public static ApplicationConfiguration getInstance() {
		if (instance == null) {
			instance = new ApplicationConfiguration();
			instance.getProperties();
		}
		return instance;
	}

	private static Properties getProperties() {
		logger.debug("####### ");
		logger.info("Loading App Properties.");
		logger.debug("####### ");
		if (properties == null) {
			try {
				properties = new Properties();
				confPath = "C:\\Users\\Lucas Correia\\Google Drive\\Lucas\\dev";
				File propertyFile = new File(confPath + "\\nf.properties");
				FileInputStream inputStream = new FileInputStream(propertyFile);
				properties.load(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return properties;
	}

	private String getProperty(String property) {
		if (properties != null)
			return properties.getProperty(property);
		return getProperties().getProperty(property);
	}

	private Integer getIntegerProperty(String key) {
		String property = getProperty(key);
		try {
			return Integer.valueOf(property);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private Double getDoubleProperty(String key) {
		String property = getProperty(key);
		try {
			return Double.valueOf(property);
		} catch (NumberFormatException e) {
			return 0d;
		}
	}

	public String getMailHostName() {
		return getProperty("app.mail.hostName");
	}

	public String getMailUserName() {
		return getProperty("app.mail.userName");
	}

	public String getMailPassWord() {
		return getProperty("app.mail.password");
	}
	
	public String getMailFrom() {
		return getProperty("app.mail.from");
	}

	public String getMailTo() {
		return getProperty("app.mail.to");
	}

	public Double getICMS() {
		return getDoubleProperty("app.imposto.icms");
	}

	public Double getISS() {
		return getDoubleProperty("app.imposto.iss");
	}

}
