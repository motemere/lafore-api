package me.motemere.laforeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfiguration {
  private static final Logger log = LoggerFactory.getLogger(AppConfiguration.class);
  private static final AppConfiguration INSTANCE = new AppConfiguration();
  private Properties properties;
  private final String PROPERTIES_FILENAME = "config.properties";

  public static AppConfiguration getInstance() {
    return INSTANCE;
  }

  public AppConfiguration() {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();

    try (InputStream input = loader.getResourceAsStream(PROPERTIES_FILENAME)) {
      Properties prop = new Properties();
      prop.load(input);
      this.properties = prop;

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private String propToEnvNameConversion(String propName) {
    return propName.toUpperCase().replaceAll("\\.", "_");
  }

  public String get(String propName) {
    String envName = propToEnvNameConversion(propName);
    String envValue = System.getenv(envName);
    String propValue = properties.getProperty(propName);

    if (envValue != null) {
      log.info(String.format("'%s' is '%s'", envName, envValue));
      return envValue;
    }

    if (propValue != null) {
      log.info(String.format("'%s' is '%s'", propName, propValue));
      return propValue;
    }

    log.info(String.format("'%s' is not found", propName));

    return null;
  }
}
