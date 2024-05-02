package ui;

import domain_model.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    //ATTRIBUTES
    Controller controller;
    Scanner input;
    private final int SENTINEL = 9;

    //CONSTRUCTOR
    public UserInterface() {
        controller = new Controller();
        input = new Scanner(System.in);
    }

    //METHODS
    public void startProgram() {
        int switchInput = 0;

        while (switchInput != SENTINEL) {
            System.out.println("Delfinen UI - ALPHA");
            System.out.println(" ");
            System.out.println("1. Add Swimmer");
            System.out.println("2. Add Swimmer results-NOTIMPLEMENTED-");
            System.out.println("3. Register Swimmer Payments -NOTIMPLEMENTED-");
            System.out.println("4. Display list of Swimmers");

            System.out.print("> ");
            switchInput = input.nextInt();
            input.nextLine();

            switch (switchInput) {

                case 1: {
                    generateSwimmer();
                    break;
                }
                case 2: {
                    //TODO: Add Swimmer results
                }
                case 3: {
                    //TODO: Register Swimmer payments
                }
                case 4: {
                    //TODO: See list of swimmers
                    displayListofMembers();
                }
                case 5: {

                }
                case 9: {
                    System.out.println("Terminating application.");
                    break; //Failsafe
                }

            }
        }
    }

    //######################### Adding Member  ################################
    public void generateSwimmer() {
        System.out.println("Please input the swimmers FIRST name: ");
        String firstName = input.nextLine();
        System.out.println("Please input the swimmers LAST name: ");
        String lastName = input.nextLine();
        System.out.println("Please input your birthday in the following format YY-MM-DD: ");
        String birthdayArr = input.next();
        input.nextLine();
        String[] values = birthdayArr.split("-");
        int year = Integer.parseInt(values[0]);
        int month = Integer.parseInt(values[1]);
        int day = Integer.parseInt(values[2]);

        LocalDate birthday = LocalDate.of(year, month, day);


        boolean activePassive = askForActivity(); //Metode, tjekker for aktivitet.

        //TODO: Spørge eller generere et memberID her.
        //TODO: Assign svømmediscipliner enum


        boolean whichSwimmerType = compOrExerciseSwimmer(); //Assigner, om der skal laves et konkurrence eller motionist objekt.

        if (whichSwimmerType) {
            Member m = new CompetitionMember(firstName, lastName, birthday, activePassive, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL);
            controller.addToMembersList(m);
            String activity; //Bygges gennem nedenstående if-statements. Bruges bare til at display aktivitetsstatus i endelige sysout besked.
            if(activePassive) {
                activity = " This member has the following activity status: ACTIVE";
            } else {
                activity = " This member has the following activity status: PASSIVE";
            }
            System.out.println("You have successfully added "+firstName+" "+lastName+".Their birthday was recorded at "+birthday
            +activity);
        } else if (!whichSwimmerType) {
            Member m = new ExerciseMember(firstName, lastName, birthday, activePassive);
            controller.addToMembersList(m);
        } else {
            System.out.println("Something went wrong. Returning to menu.");
        }
    }

    public boolean askForActivity() {
        boolean memberActive = false;
        System.out.println("Please select your desired membership status ACTIVE/PASSIVE: ");
            String activePassive = input.nextLine();
            if (activePassive.toLowerCase().equals("active")) {
                System.out.println("You have selected an ACTIVE membership.");
                memberActive = true;
            } else if(activePassive.toLowerCase().equals("passive")) {
                System.out.println("You have selected a PASSIVE membership.");
            } else {
                System.out.println("You have typed something not recognised by the program. Please try again. Error code: 88452T");
                askForActivity();
            }
        return memberActive;
    }
    public boolean compOrExerciseSwimmer() {
        boolean comp = false;
        System.out.println("Please select if the swimmer should be assigned as a competition swimmer or exercise swimmer.");
        System.out.println("Competition/Exercise");
        String answer = input.nextLine();
        if (answer.toLowerCase().equals("competition")) {
            comp = true;
        } else if (answer.toLowerCase().equals("exercise")) {
            comp = false;
        } else {
            System.out.println("You have inputted something not recognised by the application. Error code: 4352BT.");
            compOrExerciseSwimmer();
        }

        return comp;
    }

    //######################### See list of members  ################################
    public void displayListofMembers() {
        System.out.println("Displaying list of current members: ");
        for(Member m : controller.getMembersList()) {
            if (m instanceof CompetitionMember) {
                System.out.println("Competition Swimmers: ");
                System.out.println(m.toString());
            }
            if (m instanceof ExerciseMember) {
                System.out.println("Exercise Swimmers: ");
                System.out.println(m.toString());
            }
        }
    }

    private int scanIntSafely() { //Metode til at fange hvis man skriver et bogstav i en int scanner, der ellers vil melde en fejl
        try {
            return input.nextInt(); // Her tester den om der bliver tastet en int ind i scanneren
        } catch (InputMismatchException ime) {
            input.nextLine(); // Scanneren skal lige forstå, at den nu skal være klar til at læse på en ny linje
            System.out.println("You didn't type in a number - please try again:");
            return scanIntSafely(); // Rekursion: Metoden kalder sig selv, og starter dermed forfra med et nyt try!
        }
    }

}
