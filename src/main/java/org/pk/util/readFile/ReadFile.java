package org.pk.util.readFile;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.pk.dto.MembersDTO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class ReadFile {
    private final String fileName;
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(ReadFile.class);

    public ReadFile(String fileName) {
        log.setLevel(Level.INFO);
        this.fileName = fileName;
    }

    public HashMap<String, MembersDTO> readFile() throws ReadMemberExceptions {
        HashMap<String, MembersDTO> members = new HashMap<>();
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            log.info("Reading file: " + this.fileName);
            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {

                String[] member= new String[5];
                member = line.split(cvsSplitBy);
                if (member[0].equals("usercode")) {
                    i++;
                    continue;
                }
                try {
                    if (member.length != 5) {
                        throw new ReadMemberExceptions("Invalid member data length at line " + i + " : " + Arrays.toString(member));
                    } else if (member[0].trim() == null || member[0].trim() == "" || member[0].isEmpty()) {
                        throw new ReadMemberExceptions("Invalid member data at line " + i + " at position 1 : " + Arrays.toString(member));
                    } else if (member[1] == null || member[1] == "" || member[1].isEmpty()) {
                        throw new ReadMemberExceptions("Invalid member data at line " + i + " at position 2 : " + Arrays.toString(member));
                    } else if (member[2] == null || member[2] == "" || member[2].isEmpty()) {
                        throw new ReadMemberExceptions("Invalid member data at line " + i + " at position 3 : " + Arrays.toString(member));
                    } else if (member[3] == null || member[3] == "" || member[3].isEmpty()) {
                        throw new ReadMemberExceptions("Invalid member data at line " + i + " at position 4 : " + Arrays.toString(member));
                    } else if (member[4] == null || member[4] == "" || member[4].isEmpty()) {
                        throw new ReadMemberExceptions("Invalid member data at line " + i + " at position 5 : " + Arrays.toString(member));
                    } else {
                        log.info("Adding member: " + member[0]);
                        MembersDTO membered;
                        membered = new MembersDTO(member[0], member[1], member[2], member[3], Boolean.parseBoolean(member[4]));
                        members.put(member[0], membered);
                    }
                }catch (Exception e) {
                    log.error("Error at line " + i + " : " + Arrays.toString(member));
                }
                i++;
            }
        }catch (FileNotFoundException fne) {
            log.error("File not found: " + this.fileName+"\nFileNotFoundException Error: " + fne.getMessage());
            System.out.println("FileNotFoundException has occurred");
            fne.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException aie) {
            log.error("ArrayIndexOutOfBoundsException Error: " + aie.getMessage());
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