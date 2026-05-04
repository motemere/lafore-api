package me.motemere.laforeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration class that loads properties from a file and allows overriding them with environment variables.
 * The properties file should be named 'config.properties' and placed in the classpath.
 * Environment variables should be in uppercase and use underscores instead of dots (e.g., 'db.url' becomes 'DB_URL').
 */
public class AppConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(AppConfiguration.class);
    private static final AppConfiguration INSTANCE = new AppConfiguration();
    private Properties properties;
    private final String propertiesFilename = "config.properties";

    public static AppConfiguration getInstance() {
        return INSTANCE;
    }

    public AppConfiguration() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try (InputStream input = loader.getResourceAsStream(propertiesFilename)) {
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

    /**
     * Get property value by name.
     * First, it checks if there is an environment variable with the corresponding name (converted from property name).
     * If found, it returns the environment variable value.
     * If not found, it checks the properties file for the property value.
     * If still not found, it returns null.
     *
     * @param propName property name, e.g. 'db.url'
     * @return property value, e.g. 'jdbc:mysql://localhost:3306/mydb'
     */
    public String get(String propName) {
        String envName = propToEnvNameConversion(propName);
        String envValue = System.getenv(envName);
        String propValue = properties.getProperty(propName);

        if (envValue != null) {
            LOG.info(String.format("'%s' is '%s'", envName, envValue));
            return envValue;
        }

        if (propValue != null) {
            LOG.info(String.format("'%s' is '%s'", propName, propValue));
            return propValue;
        }

        LOG.info(String.format("'%s' is not found", propName));

        return null;
    }
}
