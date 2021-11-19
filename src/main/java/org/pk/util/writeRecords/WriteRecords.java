package org.pk.util.writeRecords;

import org.apache.log4j.Logger;
import org.pk.display.Display;
import org.pk.dto.MembersDTO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class WriteRecords {

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Display.class.getName());
    FileWriter fileWriter;
    HashMap<String, MembersDTO>  members;
    public WriteRecords(HashMap<String, MembersDTO> members){
        this.members = members;
    }
    public void writeRecords() {
        File csvFile = new File("D:\\projects\\java\\maven\\Members\\employees.csv");
        log.info("Writing records to csv file");
        try {
            if (csvFile.createNewFile()) {
                log.info("File created: " + csvFile.getName());
                System.out.println("File created: " + csvFile.getName());
            } else {
                log.info("File already exists.");
                System.out.println("File already exists. Overriding the file");
            }
        } catch (IOException e) {
            log.error("Error in creating file, error: "+e.getMessage());
            System.out.println("An error occurred, error:"+e.getMessage());
            e.printStackTrace();
        }
        try {
            System.out.println("Writing records to file...");
            fileWriter = new FileWriter(csvFile);
            fileWriter.write("usercode,name,jobs_completed,preferred_location,inactive\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        members.forEach((k,v)->{
            if (v.getPreferred_location().equals("remote")){
                try {
                    fileWriter.append(v.getUsercode()+","+v.getName()+","+v.getJobs_completed()+","+v.getPreferred_location()+","+v.getInactive()+"\n");
                } catch (IOException ioException) {
                    log.error("Error while writing to file, record:"+v.disp()+"\n and Errors: "+ioException.getMessage());
                    ioException.printStackTrace();
                }
            }
        });
        try {
            fileWriter.close();
        } catch (IOException e) {
            log.error("Error while closing file, Errors: "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
