package org.pk.writeRecords;

import org.pk.member.Members;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteRecords {

    FileWriter fileWriter;
    List<Members> members;
    public WriteRecords(List<Members> members){
        this.members = members;
    }
    public void writeRecords() {
        File csvFile = new File("D:\\projects\\java\\core\\member\\employees.csv");
        try {
            if (csvFile.createNewFile()) {
                System.out.println("File created: " + csvFile.getName());
            } else {
                System.out.println("File already exists. Overriding the file");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            System.out.println("Writing records to file...");
            fileWriter = new FileWriter(csvFile);
            fileWriter.write("usercode,name,jobs_completed,preferred_location,inactive\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Members member : members) {
            if (member.getPreferred_location().equals("remote")) {
                try {
                    fileWriter.append(member.getUsercode());
                    fileWriter.append(",");
                    fileWriter.append(member.getName());
                    fileWriter.append(",");
                    fileWriter.append(member.getJobs_completed());
                    fileWriter.append(",");
                    fileWriter.append(member.getPreferred_location());
                    fileWriter.append(",");
                    fileWriter.append(Boolean.toString(member.getInactive()));
                    fileWriter.append("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
