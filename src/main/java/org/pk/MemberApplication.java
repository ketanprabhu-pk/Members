package org.pk;

import org.apache.log4j.Logger;
import org.pk.dto.MembersDTO;
import org.pk.util.readFile.ReadFile;
import org.pk.display.Display;

import java.util.HashMap;

public class MemberApplication {

    String fileName;
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(MemberApplication.class);
    public MemberApplication(String fileName) {
        this.fileName = fileName;
    }

    public void run(){
        log.info("MemberApplication start");
        ReadFile readFile = new ReadFile(fileName);
//        HashMap<String,HashMap<String,Object>> members = readFile.readFile();
        HashMap<String, MembersDTO> member = readFile.readFile();
        log.info("members Read done");
        log.info("Display start");
        Display d = new Display(member);
        d.run();
        log.info("Display done");
    }
}
