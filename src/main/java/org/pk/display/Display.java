package org.pk.display;

import org.apache.log4j.Logger;
import org.pk.Main;
import org.pk.log.Log;
import org.pk.writeRecords.WriteRecords;
import org.pk.member.Members;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Display {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Display.class.getName());
    private List<Members> members;
    Scanner sc = new Scanner(System.in); // Scanner class for user input

    public Display(List<Members> members) {
        this.members = members;
        new Log();
    }

    public void run(){
        int i = 1;
        while(i != 0){
            System.out.println("\n1. Display all members");
            System.out.println("2. Display members with preferred location");
            System.out.println("3. Display members with a particular user code");
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
                    getMembersWithPreferredLocation();
                    break;
                case 3:
                    getMembersWithUserCode();
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
        members.sort(Comparator.comparing(Members::getName));
//        for (Members member : members) {
//            System.out.println(member.disp());
//        }
        // Using lambda expression
        System.out.println(members.stream().map(Members::disp).collect(Collectors.joining("\n")));
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
        String location = "";
        if(type == 1) {
            location = "remote";
        }else if (type==2){
            location = "hybrid";
        }
        String finalLocation = location;
        System.out.println(members.stream().filter(a -> a.getPreferred_location().equals(finalLocation)).map(Members::disp).collect(Collectors.joining("\n")));
    }
    private void getMembersWithUserCode() {
        System.out.println("Enter the user code");
        String userCode = sc.next();
        log.info("User code entered is " + userCode);
//        for (Members member : members) {
//            if (userCode.equals(member.getUsercode())) {
//                System.out.println(member.disp());
//            }
//        }
        // Using lambda expression
        Members mem = members.stream().filter(a -> a.getUsercode().equals(userCode)).findFirst().orElse(null);
        if(mem != null) { System.out.println(mem.disp()); } else { System.out.println("No Members found with the user code"); }
    }
    private void getMembersWithMaxJobs() {
//        int max = 0;
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
        System.out.println(members.stream().max(Comparator.comparing(Members::getJobs_completed)).get().disp());
    }
}

