package org.pk.readFile;

import org.apache.log4j.Logger;
import org.pk.Main;
import org.pk.log.Log;
import org.pk.member.Members;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private final String fileName;
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(ReadFile.class);

    public ReadFile(String fileName) {
        new Log();
        this.fileName = fileName;
    }

    public List<Members> readFile() {
        List<Members> members = new ArrayList<Members>();
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            log.info("Reading file: " + this.fileName);
            String line;
            while ((line = br.readLine()) != null) {
                String[] member = line.split(cvsSplitBy);
                if (member[0].equals("usercode")) {
                    continue;
                }
                members.add(new Members(member[0], member[1], member[2], member[3], Boolean.parseBoolean(member[4]))
                );
            }
        } catch (Exception e) {
            log.error("Error reading file: " + this.fileName);
            e.printStackTrace();
        }
        return members;
    }
}
