package org.pk.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Log {
    private static final String LOG_PROPERTIES = "D:\\projects\\java\\maven\\Members\\log4j.properties";
    private static Logger logger = null;
    private String clazz1;
    public Log() {
        Properties property= new Properties();
        try {
            property.load(new FileInputStream(LOG_PROPERTIES));
            PropertyConfigurator.configure(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
