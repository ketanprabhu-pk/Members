package org.pk;

import org.apache.log4j.Logger;
import org.pk.log.Log;
import org.pk.readFile.ReadFile;
import org.pk.member.Members;
import org.pk.display.Display;
import java.util.List;

public class MemberApplication {

    String fileName;
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(MemberApplication.class);
    public MemberApplication(String fileName) {
        new Log();
        this.fileName = fileName;
    }

    public void run(){
        log.info("MemberApplication start");
        ReadFile readFile = new ReadFile(fileName);
        List<Members> members = readFile.readFile();
        log.info("members Read done");
        log.info("Display start");
        Display d = new Display(members);
        d.run();
        log.info("Display done");
    }
}
