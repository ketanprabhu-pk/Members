package org.pk.util.readFile;

import org.apache.log4j.Logger;
import org.pk.dto.MembersDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadFile {
    private final String fileName;
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(ReadFile.class);

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    public HashMap<String, MembersDTO> readFile() {
        HashMap<String, MembersDTO> members = new HashMap<>();
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            log.info("Reading file: " + this.fileName);
            String line;
            while ((line = br.readLine()) != null) {
                String[] member = line.split(cvsSplitBy);
                if (member[0].equals("usercode")) {
                    continue;
                }
                log.info("Adding member: " + member[0]);
                MembersDTO membered;
                membered = new MembersDTO(member[0], member[1], member[2], member[3], Boolean.parseBoolean(member[4]));
                members.put(member[0],membered);
            }
        }catch (FileNotFoundException fne) {
            log.error("File not found: " + this.fileName+"\nFileNotFoundException Error: " + fne.getMessage());
            System.out.println("FileNotFoundException has occurred");
            fne.printStackTrace();
        }catch (IOException ie) {
            log.error("Error reading file: " + this.fileName+"\nIOException Error: " + ie.getMessage());
            System.out.println("IOException has occurred");
        }catch (Exception e) {
            log.error("Error in file: " + this.fileName + "\nException Error: " + e.getMessage());
            e.printStackTrace();
        }
        return members;
    }
}