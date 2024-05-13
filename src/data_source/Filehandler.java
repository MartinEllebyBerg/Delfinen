package data_source;

import domain_model.*;

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
            } // Handle the error appropriately, such as skipping this entry or asking for correct input
            //continue;

            Member member = new CompetitionMember(firstName, lastName, birthDay, memberActive, swimDiscipline1,
                    swimDiscipline2, swimDiscipline3, swimDiscipline4);
            // Laver en ny movie baseret på scannerinput fra fil

            arr.add(member);
            // Tilføjer filmene til vores filmsamling
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
                }
            }
            System.out.println("Members' list has been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<ResultSwimmer> loadSavedMemberResults(ArrayList<ResultSwimmer> arr) { //Load competitionMembers
        File file = new File("src/data_source/saveTestResults.csv");
        Scanner scannerInput = null;
        int numOfAttributesCompetitiveConstructor = 8;
        int numOfAttributesTrainingConstructor = 5;
        try {
            scannerInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry something went wrong with loading the MovieCollection.");
            throw new RuntimeException(e);
        }

        while (scannerInput.hasNext()) {

            String line = scannerInput.nextLine();
            String[] values = line.split(";");

            if(values.length == numOfAttributesCompetitiveConstructor) { //Competition result.
                boolean isCompetitive = Boolean.parseBoolean(values[0]);

                int memberID = Integer.parseInt(values[1]);
                String competitionLocation = values[2];
                String competitionName = values[3];
                LocalDate resultDate = LocalDate.parse(values[4], DateTimeFormatter.ISO_LOCAL_DATE);
                SwimDiscipline swimDiscipline1 = null;
                double swimTime = Double.parseDouble(values[6]);
                int placementCompetition = Integer.parseInt(values[7]);

                try {
                    swimDiscipline1 = SwimDiscipline.valueOf(values[5].toUpperCase());
                }catch(IllegalArgumentException e) {
                    System.out.println("DEBUG: Invalid discipline: "+values[4]);
                }

                arr.add(new ResultSwimmer(isCompetitive, memberID, competitionLocation, competitionName, resultDate, swimDiscipline1,
                        swimTime, placementCompetition));

            } else if (values.length == numOfAttributesTrainingConstructor) { //Training result
                boolean isCompetitive = Boolean.parseBoolean(values[0]);
                int memberID = Integer.parseInt(values[1]);
                int swimTime = Integer.parseInt(values[3]);
                LocalDate resultDate = LocalDate.parse(values[4], DateTimeFormatter.ISO_LOCAL_DATE);


                SwimDiscipline swimDiscipline1 = null;
                try {
                    swimDiscipline1 = SwimDiscipline.valueOf(values[2].toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Discipline: " + values[2]);
                }
                arr.add(new ResultSwimmer(isCompetitive, memberID, swimDiscipline1, swimTime, resultDate));
            } else {
                //TODO: fjern sysout fra filehandler linje 69-70
                System.out.println("DEBUG: Fejl ved tilføjelse af member objekt. Filehandler, linje 69.");
            }
        }
        scannerInput.close();
        return arr;

    }

    public void saveListOfMemberResults(ArrayList<ResultSwimmer> list) {
        try (PrintWriter output = new PrintWriter(new FileWriter("src/data_source/saveTestResults.csv"))) {

            for (ResultSwimmer rs : list) {
                    String memberString = String.format("%s;%s;%s;%s;%s;%s;%s;%s",
                            rs.isCompetitive(), rs.getMemberID(), rs.getCompetitionLocation(), rs.getCompetitionName(),
                    rs.getResultDate(), rs.getSwimDiscipline(), rs.getSwimTime(), rs.getPlacementCompetition());

                    output.println(memberString);

            }
            //TODO: Fjern sysout fra FH linje 95-96, samt linje 98.
            System.out.println("Members' list has been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
