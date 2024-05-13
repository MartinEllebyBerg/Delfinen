package data_source;

import domain_model.CompetitionMember;
import domain_model.ExerciseMember;
import domain_model.Member;
import domain_model.SwimDiscipline;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    //ATTRIBUTES

    //CONSTRUCTOR

    //METHODS

    //metode til at loade membersList ved opstart
    //metode til at save membersList ved ændringer
    //metode til at loade resultList ved opstart
    //metode til at save resultList ved ændringer
    public ArrayList<Member> loadSavedCompMemberList(ArrayList<Member> arr) { //Load competitionMembers
        File file = new File("src/data_source/CompetitionMembers.csv");
        Scanner scannerInput = null;
        try {
            scannerInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry something went wrong with loading the Memberslist.");
            throw new RuntimeException(e);
        }

        while (scannerInput.hasNext()) {
            String line = scannerInput.nextLine();
            String[] values = line.split(";");

            String firstName = values[0];
            String lastName = values[1];
            LocalDate birthDay = LocalDate.parse(values[2], DateTimeFormatter.ISO_LOCAL_DATE);
            boolean memberActive = Boolean.parseBoolean(values[3]);
            boolean paymentRegistered = Boolean.parseBoolean(values[4]);

            SwimDiscipline swimDiscipline1 = null;
            SwimDiscipline swimDiscipline2 = null;
            SwimDiscipline swimDiscipline3 = null;
            SwimDiscipline swimDiscipline4 = null;
            try {
                swimDiscipline1 = SwimDiscipline.valueOf(values[5].toUpperCase());
                swimDiscipline2 = SwimDiscipline.valueOf(values[6].toUpperCase());
                swimDiscipline3 = SwimDiscipline.valueOf(values[7].toUpperCase());
                swimDiscipline4 = SwimDiscipline.valueOf(values[8].toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Discipline: " + values[5]);
            } // Handle the error appropriately, such as skipping this entry or asking for correct input
            //continue;

            Member member = new CompetitionMember(firstName, lastName, birthDay, memberActive, paymentRegistered, swimDiscipline1,
                    swimDiscipline2, swimDiscipline3, swimDiscipline4);
            // Opretter ny Member fra fil

            arr.add(member);
            // Tilføjer member til listen
        }
        scannerInput.close();
        return arr;

    }
    public ArrayList<Member> loadSavedExerciseMemberList(ArrayList<Member> arr) { //Load exercise
        File file = new File("src/data_source/ExerciseMembers.csv");
        Scanner scannerInput = null;
        try {
            scannerInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry something went wrong with loading the MembersList.");
            throw new RuntimeException(e);
        }

        while (scannerInput.hasNext()) {
            String line = scannerInput.nextLine();
            String[] values = line.split(";");

            String firstName = values[0];
            String lastName = values[1];
            LocalDate birthDay = LocalDate.parse(values[2], DateTimeFormatter.ISO_LOCAL_DATE);
            boolean memberActive = Boolean.parseBoolean(values[3]);
            boolean paymentRegistered = Boolean.parseBoolean(values[4]);

            Member member = new ExerciseMember(firstName, lastName, birthDay, memberActive, paymentRegistered);
            // Opretter ny Member fra fil

            arr.add(member);
            // Tilføjer member til listen
        }
        scannerInput.close();
        return arr;

    }

    public void saveListOfMembersCompetition(ArrayList<Member> list) {
        try (PrintWriter output = new PrintWriter(new FileWriter("src/data_source/CompetitionMembers.csv"))) {

            for (Member member : list) {
                if (member instanceof CompetitionMember downcastMember) {
                    String memberString = String.format("%s;%s;%s;%b;%b;%s;%s;%s;%s",
                            member.getFirstName(),
                            member.getLastName(),
                            member.getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE),
                            member.getIsMemberActive(),
                            member.isPaymentRegistered(),
                            downcastMember.getSwimDiscipline1() != null ? downcastMember.getSwimDiscipline1().toString() : "", // Handle possible nulls
                            downcastMember.getSwimDiscipline2() != null ? downcastMember.getSwimDiscipline2().toString() : "",
                            downcastMember.getSwimDiscipline3() != null ? downcastMember.getSwimDiscipline3().toString() : "",
                            downcastMember.getSwimDiscipline4() != null ? downcastMember.getSwimDiscipline4().toString() : "");
                    output.println(memberString);
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void saveListOfMembersExercise(ArrayList<Member> list) {
        try (PrintWriter output = new PrintWriter(new FileWriter("src/data_source/ExerciseMembers.csv"))) {

            for (Member member : list) {
                if(member instanceof ExerciseMember) {
                    String memberString = String.format("%s;%s;%s;%b;%b",
                            member.getFirstName(),
                            member.getLastName(),
                            member.getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE),
                            member.getIsMemberActive(),
                            member.isPaymentRegistered());
                    output.println(memberString);
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
