package org.pk.display;

import org.apache.log4j.Logger;
import org.pk.dto.MembersDTO;
import org.pk.util.writeRecords.WriteRecords;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;

public class Display {

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Display.class.getName());
    private HashMap<String, MembersDTO> members;
    Scanner sc = new Scanner(System.in); // Scanner class for user input

    public Display(HashMap<String, MembersDTO>  members) {
        this.members = members;
    }

    public void run(){
        int i = 1;
        while(i != 0){
            System.out.println("\n1. Display all members");
            System.out.println("2. Display members with a particular user code");
            System.out.println("3. Display members with preferred location");
            System.out.println("4. Display members who has completed maximum jobs.");
            System.out.println("5. Write records of remote job");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            i = sc.nextInt();
            log.info("User entered " + i);
            switch (i) {
                case 1:
                    displayMembers();
                    break;
                case 2:
                    getMembersWithUserCode();
                    break;
                case 3:
                    getMembersWithPreferredLocation();
                    break;
                case 4:
                    getMembersWithMaxJobs();
                    break;
                case 5:
                    WriteRecords w = new WriteRecords(members);
                    w.writeRecords();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
        }
    }

    public void displayMembers(){
//        members.sort(Comparator.comparing(Members::getName));
//        for (Members member : members) {
//            System.out.println(member.disp());
//        }
        // Using lambda expression
//        System.out.println(members.stream().map(Members::disp).collect(Collectors.joining("\n")));
        members.forEach((k,v) -> System.out.println(v.disp()));
    }

    private void getMembersWithUserCode() {
//        System.out.println("Enter the user code");
//        String userCode = sc.next();
//        log.info("User code entered is " + userCode);
////        for (Members member : members) {
////            if (userCode.equals(member.getUsercode())) {
////                System.out.println(member.disp());
////            }
////        }
//        // Using lambda expression
//        Members mem = members.stream().filter(a -> a.getUsercode().equals(userCode)).findFirst().orElse(null);
//        if(mem != null) { System.out.println(mem.disp()); } else { System.out.println("No Members found with the user code"); }
        System.out.println("Enter the user code");
        String userCode = sc.next();
        log.info("User code entered is " + userCode);
        System.out.println(members.get(userCode).disp());
    }

    private void getMembersWithPreferredLocation() {
        System.out.println("Enter the preferred location");
        System.out.println("1=>remote, 2=>hybrid");
        int type = parseInt(sc.next());
        log.info("User entered " + type);
//        for (Members member : members) {
//            if(type != 1 && type != 2){
//                System.out.println("Choose correct option");
//                break;
//            } else if (
//                    type == 1 && member.getPreferred_location().equals("remote")
//            ) {
//                System.out.println(member.disp());
//            } else if (
//                    type == 2 && member.getPreferred_location().equals("hybrid")
//            ) {
//                System.out.println(member.disp());
//            }
//        }
        // Using lambda expression
        // System.out.println(members.stream().filter(a -> a.getPreferred_location().equals(finalLocation)).map(Members::disp).collect(Collectors.joining("\n")));
        String location;
        if(type == 1) {
            location = "remote";
        }else if (type==2){
            location = "hybrid";
        }else {
            log.error("User entered wrong option");
            System.out.println("Choose correct option");
            return;
        }
        String finalLocation = location;
        members.forEach((k, v) -> {
            if(v.getPreferred_location().equals(finalLocation)) {
                System.out.println(v);
            }
        });
    }

    private void getMembersWithMaxJobs() {
        AtomicInteger max= new AtomicInteger();
//        for (Members member : members) {
//            if (parseInt(member.getJobs_completed()) > max) {
//                max = parseInt(member.getJobs_completed());
//            }
//        }
//        for (Members member : members) {
//            if (parseInt(member.getJobs_completed()) == max) {
//                System.out.println(member.disp());
//            }
//        }
        // Using lambda expression
//        System.out.println(members.stream().max(Comparator.comparing(Members::getJobs_completed)).get().disp());

        members.forEach((k, v) -> {
            if(parseInt(v.getJobs_completed()) > max.get()) {
                max.set(parseInt(v.getJobs_completed()));
                log.info("new max = " + max.get());
            }
        } );
        members.forEach((k, v) -> {
            if(parseInt(v.getJobs_completed()) == max.get()) {
                System.out.println(v.disp());
            }
        } );
    }
}

