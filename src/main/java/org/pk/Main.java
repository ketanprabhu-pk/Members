package org.pk;

import javafx.beans.property.Property;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.pk.log.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        new Log();
        log.info("Start");
        String csvFile = "";
        try {
            if(args[0] != null)
                csvFile = args[0];
            else
                csvFile = "D:\\projects\\java\\maven\\Members\\members.csv";
        } catch (Exception e) {
            System.out.println("Please enter a valid file name");
            System.exit(0);
        }
        MemberApplication ma = new MemberApplication(csvFile);
        ma.run();
        log.debug("End");
    }
}
