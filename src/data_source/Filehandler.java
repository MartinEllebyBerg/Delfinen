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
        File file = new File("src/data_source/saveTestData.csv");
        Scanner scannerInput = null;
        int numOfAttributesExerciseConstructor = 4;
        int numOfAttributesCompConstructor = 8;
        try {
            scannerInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry something went wrong with loading the MovieCollection.");
            throw new RuntimeException(e);
        }

        while (scannerInput.hasNext()) {
            String line = scannerInput.nextLine();
            String[] values = line.split(";");

            String firstName = values[0];
            String lastName = values[1];
            LocalDate birthDay = LocalDate.parse(values[2], DateTimeFormatter.ISO_LOCAL_DATE);
            boolean memberActive = Boolean.parseBoolean(values[3]);

            if(values.length == numOfAttributesExerciseConstructor) { //Exercise member, hvis arrayet kun har 4 værdier. EM constructor.
                arr.add(new ExerciseMember(firstName, lastName, birthDay, memberActive));

            } else if (values.length == numOfAttributesCompConstructor) { //Competition member, hvis arrayet har 8 værdier. CM constructor.
                SwimDiscipline swimDiscipline1 = null;
                SwimDiscipline swimDiscipline2 = null;
                SwimDiscipline swimDiscipline3 = null;
                SwimDiscipline swimDiscipline4 = null;
                try {
                    swimDiscipline1 = SwimDiscipline.valueOf(values[4].toUpperCase());
                    swimDiscipline2 = SwimDiscipline.valueOf(values[5].toUpperCase());
                    swimDiscipline3 = SwimDiscipline.valueOf(values[6].toUpperCase());
                    swimDiscipline4 = SwimDiscipline.valueOf(values[7].toUpperCase());

                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Discipline: " + values[4]);
                }
                arr.add(new CompetitionMember(firstName, lastName, birthDay, memberActive, swimDiscipline1, swimDiscipline2,
                        swimDiscipline3,swimDiscipline4));
            } else {
                //TODO: fjern sysout fra filehandler linje 69-70
                System.out.println("DEBUG: Fejl ved tilføjelse af member objekt. Filehandler, linje 69.");
            }
        }
        scannerInput.close();
        return arr;

    }

    public void saveListOfMembersCompetition(ArrayList<Member> list) {
        try (PrintWriter output = new PrintWriter(new FileWriter("src/data_source/saveTestData.csv"))) {

            for (Member member : list) {
                if (member instanceof CompetitionMember downcastMember) {
                    String memberString = String.format("%s;%s;%s;%b;%s;%s;%s;%s",
                            member.getFirstName(),
                            member.getLastName(),
                            member.getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE),
                            member.getIsMemberActive(),
                            downcastMember.getSwimDiscipline1() != null ? downcastMember.getSwimDiscipline1().toString() : "", // Handle possible nulls
                            downcastMember.getSwimDiscipline2() != null ? downcastMember.getSwimDiscipline2().toString() : "",
                            downcastMember.getSwimDiscipline3() != null ? downcastMember.getSwimDiscipline3().toString() : "",
                            downcastMember.getSwimDiscipline4() != null ? downcastMember.getSwimDiscipline4().toString() : "");
                    output.println(memberString);
                } else if(member instanceof ExerciseMember) {
                    String memberString = String.format("%s;%s;%s;%b",
                            member.getFirstName(),
                            member.getLastName(),
                            member.getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE),
                            member.getIsMemberActive());
                    output.println(memberString);
                }
            }
            //TODO: Fjern sysout fra FH linje 95-96, samt linje 98.
            System.out.println("Members' list has been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
