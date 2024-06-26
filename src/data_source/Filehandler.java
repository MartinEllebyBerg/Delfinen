package data_source;

import domain_model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    public Filehandler() {
    }

    //#########################  Save & Load - Members  ################################
    public ArrayList<Member> loadSavedAllMembersList(ArrayList<Member> arr) throws FileNotFoundException { //Load competitionMembers
        File file = new File("src/data_source/newMembersFull.csv");
        Scanner scannerInput = null;
        int numOfAttributesExerciseConstructor = 6;
        int numOfAttributesCompConstructor = 10;
        scannerInput = new Scanner(file);

        while (scannerInput.hasNext()) {
            String line = scannerInput.nextLine();
            String[] values = line.split(";");

            int memberID = Integer.parseInt(values[0]);
            String firstName = values[1];
            String lastName = values[2];
            LocalDate birthDay = LocalDate.parse(values[3], DateTimeFormatter.ISO_LOCAL_DATE);
            boolean memberActive = Boolean.parseBoolean(values[4]);
            boolean paymentRegistered = Boolean.parseBoolean(values[5]);

            if (values.length == numOfAttributesExerciseConstructor) {
                arr.add(new ExerciseMember(memberID, firstName, lastName, birthDay, memberActive, paymentRegistered));
            } else if (values.length == numOfAttributesCompConstructor) {
                SwimDiscipline swimDiscipline1 = null;
                SwimDiscipline swimDiscipline2 = null;
                SwimDiscipline swimDiscipline3 = null;
                SwimDiscipline swimDiscipline4 = null;
                try {
                    swimDiscipline1 = SwimDiscipline.valueOf(values[6].toUpperCase());
                    swimDiscipline2 = SwimDiscipline.valueOf(values[7].toUpperCase());
                    swimDiscipline3 = SwimDiscipline.valueOf(values[8].toUpperCase());
                    swimDiscipline4 = SwimDiscipline.valueOf(values[9].toUpperCase());

                } catch (IllegalArgumentException e) {
                }
                arr.add(new CompetitionMember(memberID, firstName, lastName, birthDay, memberActive, paymentRegistered, swimDiscipline1,
                        swimDiscipline2, swimDiscipline3, swimDiscipline4));
            }
        }
        scannerInput.close();
        return arr;
    }

    public void saveListOfAllMembers(ArrayList<Member> list) {
        try (PrintWriter output = new PrintWriter(new FileWriter("src/data_source/newMembersFull.csv"))) {
            for (Member member : list) {
                if (member instanceof CompetitionMember downcastMember) {
                    String memberString = String.format("%d;%s;%s;%s;%b;%b;%s;%s;%s;%s",
                            member.getMemberID(),
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
                } else if (member instanceof ExerciseMember) {
                    String memberString = String.format("%d;%s;%s;%s;%b;%b",
                            member.getMemberID(),
                            member.getFirstName(),
                            member.getLastName(),
                            member.getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE),
                            member.getIsMemberActive(),
                            member.isPaymentRegistered());
                    output.println(memberString);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //#########################  Save & Load - Results  ################################
    public void saveAllResults(ArrayList<ResultSwimmer> list) {
        try (PrintWriter output = new PrintWriter(new FileWriter("src/data_source/newSwimmerResultsFull.csv"))) {

            for (ResultSwimmer comp : list) {
                String compString = String.format("%s;%d;%s;%s;%s;%s;%s;%d",
                        comp.isCompetitive(),
                        comp.getMemberID(),
                        comp.getCompetitionLocation(),
                        comp.getCompetitionName(),
                        comp.getResultDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                        comp.getSwimDiscipline(),
                        comp.getSwimTime(),
                        comp.getPlacementCompetition());
                output.println(compString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ResultSwimmer> loadSavedMemberResults(ArrayList<ResultSwimmer> arr) { //Load competitionMembers
        File file = new File("src/data_source/newSwimmerResultsFull.csv");
        Scanner scannerInput = null;
        int numOfAttributesCompetitiveConstructor = 8;
        int numOfAttributesTrainingConstructor = 5;
        try {
            scannerInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scannerInput.hasNext()) {
            String line = scannerInput.nextLine();
            String[] values = line.split(";");

            if (values.length == numOfAttributesCompetitiveConstructor) { //Competition result.
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
                } catch (IllegalArgumentException e) {
                }

                arr.add(new ResultSwimmer(isCompetitive, memberID, competitionLocation, competitionName, resultDate, swimDiscipline1,
                        swimTime, placementCompetition));

            } else if (values.length == numOfAttributesTrainingConstructor) { //Training result
                boolean isCompetitive = Boolean.parseBoolean(values[0]);
                int memberID = Integer.parseInt(values[1]);
                double swimTime = Double.parseDouble(values[3]);
                LocalDate resultDate = LocalDate.parse(values[4], DateTimeFormatter.ISO_LOCAL_DATE);

                SwimDiscipline swimDiscipline1 = null;
                try {
                    swimDiscipline1 = SwimDiscipline.valueOf(values[2].toUpperCase());
                } catch (IllegalArgumentException e) {
                }
                arr.add(new ResultSwimmer(isCompetitive, memberID, swimDiscipline1, swimTime, resultDate));
            } else {
            }
        }
        scannerInput.close();
        return arr;
    }
}