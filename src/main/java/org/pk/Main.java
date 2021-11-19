package org.pk;

import org.apache.log4j.Logger;

public class Main {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
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
