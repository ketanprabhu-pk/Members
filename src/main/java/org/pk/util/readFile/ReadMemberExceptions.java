package org.pk.util.readFile;

import org.apache.log4j.Logger;

public class ReadMemberExceptions extends Exception {
    private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger(ReadMemberExceptions.class);

    public ReadMemberExceptions(String message) {
        super(message);
        log.error("ReadMemberExceptions Error : "+message);
    }
}
