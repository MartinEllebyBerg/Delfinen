package ui;

import domain_model.*;

import java.io.Console;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    //ATTRIBUTES
    Controller controller;
    Scanner input;
    private final int SENTINEL = 9;
    private int switchInput = 0;

    //CONSTRUCTOR
    public UserInterface() {
        controller = new Controller();
        input = new Scanner(System.in);
    }

    //METHODS

    //######################### Determine position within Delfinen to get a different UI  ################################
    public void DelfinenUISetPosition() {
        System.out.println("Welcome to Delfinen's member administration program. Please input your role within Delfinen.");
        System.out.println("CHAIRMAN | TREASURER | COACH");
        boolean condition = true;

        while (condition) {
            System.out.print("> ");
            String switchChoice = input.nextLine().toLowerCase();

            switch (switchChoice) {
                case "chairman": {
                    startProgramChairman();
                    condition = false;
                    break;
                }
                case "treasurer": {
                    startProgramTreasurer();
                    condition = false;
                    break;
                }
                case "coach": {
                    startProgramCoach();
                    condition = false;
                    break;
                }
                default: {
                    System.out.println("Invalid input. Please input either Chairman, Treasurer or Coach.");
                    break;
                }
            }
        }
    }

    //######################### Different UI based on position within Delfinen  ################################
    public void startProgramAll() {

        while (switchInput != SENTINEL) {
            System.out.println("Delfinen UI - DEBUG - ALL CHOICES");
            System.out.println(" ");
            System.out.println("1. Add Swimmer");
            System.out.println("2. Add Swimmer results-NOTIMPLEMENTED-");
            System.out.println("3. Register Swimmer Payments -NOTIMPLEMENTED-");
            System.out.println("4. Display list of Swimmers\n");
            System.out.println("9. Terminate program");
            try {

                System.out.print("> ");
                switchInput = input.nextInt();
                input.nextLine();

                switch (switchInput) {

                    case 1: {
                        generateSwimmer();
                        break;
                    }
                    case 2: {
                        //TODO: Add Swimmer results -
                    }
                    case 3: {
                        //TODO: Register Swimmer payments
                    }
                    case 4: {
                        //TODO: See list of swimmers
                        displayListofMembers();
                        break;
                    }
                    case 5: {
                        //TODO: Set multiple swim disciplines to object
                        setMultipleDisciplines();
                        break;
                    }
                    case 6: { //test af metoder
                        //findMemberSearchWithNewArray();
                        deleteSwimDisciplines();
                        break;
                    }
                    case 9: {
                        System.out.println("Terminating application.");
                        break; //Failsafe
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public void startProgramChairman() {
        displayMenuChairman();

        while (switchInput != SENTINEL) {

            try {

                System.out.print("> ");
                switchInput = input.nextInt();
                input.nextLine();

                switch (switchInput) {

                    case 1: {
                        generateSwimmer();
                        break;
                    }
                    case 2: {
                        displayListofMembers();
                        break;
                    }
                    case 3: {

                    }
                    case 9: {
                        System.out.println("Terminating application.");
                        break; //Failsafe
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public void displayMenuChairman() {
        System.out.println("Delfinen UI - CHAIRMAN");
        System.out.println(" ");
        System.out.println("1. Add Swimmer");
        System.out.println("2. Display list of Swimmers\n");
        System.out.println("9. Terminate program");
    }

    public void displayMenuTreasurer() {
        System.out.println("Delfinen UI - TREASURER");
        System.out.println(" ");
        System.out.println("1. Register Swimmer Payments -NOTIMPLEMENTED-");
        System.out.println("2. Display list of Swimmers\n");
        System.out.println("9. Terminate program");
    }

    public void displayMenuCoach() {
        System.out.println("Delfinen UI - COACH");
        System.out.println(" ");
        System.out.println("1. Register Swimmer Disciplines");
        System.out.println("2. Delete Swimmer Disciplines");
        System.out.println("3. Display list of Swimmers\n");
        System.out.println("9. Terminate program");
    }

    public void startProgramTreasurer() {
        displayMenuTreasurer();
        while (switchInput != SENTINEL) {
            try {
                System.out.print("> ");
                switchInput = input.nextInt();
                input.nextLine();

                switch (switchInput) {

                    case 1: {
                        //TODO: Register Swimmer payments
                    }
                    case 2: {
                        //TODO: See list of swimmers
                        displayListofMembers();
                        break;
                    }
                    case 3: {
                        //TODO: Forecast financials - budget
                    }
                    case 9: {
                        System.out.println("Terminating application.");
                        break; //Failsafe
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public void startProgramCoach() {
        displayMenuCoach();
        while (switchInput != SENTINEL) {

            try {

                System.out.print("> ");
                switchInput = input.nextInt();
                input.nextLine();

                switch (switchInput) {

                    case 1: {
                        setMultipleDisciplines();
                        break;
                    }
                    case 2: {
                        deleteSwimDisciplines();
                        break;
                    }
                    case 3: {
                        displayListofMembers();
                        break;
                    }
                    case 9: {
                        System.out.println("Terminating application.");
                        break; //Failsafe
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    //######################### Adding Member  ################################
    public void generateSwimmer() {
        System.out.println("Please input the swimmers FIRST name: ");
        String firstName = input.nextLine();
        System.out.println("Please input the swimmers LAST name: ");
        String lastName = input.nextLine();

        LocalDate birthday = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Please input your birthday in the following format YYYY-MM-DD: ");

            String birthdayStr = input.nextLine(); //Brugerinput gemmes

            try {
                birthday = LocalDate.parse(birthdayStr); //LocalDate.parse læser de nødvendige attributter fra birthdayStr og parser dem til YYYY-MM-DD
                validInput = true; //Vi afslutter while loopet.
            } catch (DateTimeParseException e) {
                System.out.println("Invalid input. Please type your input in the following format YYYY-MM-DD");
            }
        }
        boolean activePassive = askForActivity(); //Metode, tjekker for aktivitet.

        System.out.println("During this registration you will be able to select one swim discipline for the member.");
        System.out.println("Afterwards, you will be able to set multiple disciplines the for selected swimmer.\n");
        SwimDiscipline firstDiscipline = userPromptSwimDiscipline();

        boolean decidingWhatTypeOfSwimmer = compOrExerciseSwimmer(); //Assigner, om der skal laves et konkurrence eller motionist objekt.

        //TODO: Refactor med henblik på læsbarhed. Flyt if blokke ud i separate metoder og kald dem her i generateSwimmer()
        if (decidingWhatTypeOfSwimmer) {
            Member m = new CompetitionMember(firstName, lastName, birthday, activePassive, firstDiscipline, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL);
            controller.addToMembersList(m);
            String activity; //Bygges gennem nedenstående if-statements. Bruges bare til at display aktivitetsstatus i endelige sysout besked.
            if (activePassive) {
                activity = " This member has the following activity status: ACTIVE";
            } else {
                activity = " This member has the following activity status: PASSIVE";
            }
            System.out.println("You have successfully added " + firstName + " " + lastName + ". Their birthday was recorded at " + birthday
                    + activity);
            System.out.println("This member is on the team for: " + firstDiscipline);
        } else if (!decidingWhatTypeOfSwimmer) {
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
        } else if (activePassive.toLowerCase().equals("passive")) {
            System.out.println("You have selected a PASSIVE membership.");
        } else {
            System.out.println("You have typed something not recognised by the program. Please try again. Error code: 88452T");
            return askForActivity();
        }
        return memberActive;
    }

    public boolean compOrExerciseSwimmer() {
        boolean comp = false;
        System.out.println("Please select if the swimmer should be assigned as a competition swimmer or exercise swimmer. Competition/Exercise");
        String answer = input.nextLine();
        if (answer.toLowerCase().equals("competition")) {
            comp = true;
        } else if (answer.toLowerCase().equals("exercise")) {
            comp = false;
        } else {
            System.out.println("You have inputted something not recognised by the application. Error code: 4352BT.");
            return compOrExerciseSwimmer();
        }

        return comp;
    }

    //######################### Adding Member - Swim disciplines  ################################
    public SwimDiscipline findSwimDisciplineEnum(String searchTerm) {
        for (SwimDiscipline e : SwimDiscipline.values()) {
            if (searchTerm.equals(e.name())) {
                System.out.println("Found matching enum: " + e + " " + e.name());
                return e;
            }
        }
        return null;
    }

    public SwimDiscipline userPromptSwimDiscipline() {
        String UPSWDInput = " ";
        System.out.println("Please type in which discipline you would like to be assigned or attached to.");
        System.out.println("Valid choices include breaststroke, backstroke, frontcrawl, butterfly or null.");

        while (true) {
            if (UPSWDInput.equals("done")) {
                break;
            }
            UPSWDInput = input.nextLine().toLowerCase();
            if (UPSWDInput.equals("breaststroke") || UPSWDInput.equals("backstroke") || UPSWDInput.equals("frontcrawl") || UPSWDInput.equals("butterfly") || UPSWDInput.equals("null")) {
                return findSwimDisciplineEnum(UPSWDInput.toUpperCase());
            } else if (UPSWDInput.equals("done")) {
                break;
            } else {
                System.out.println("No valid input. Please try again.");
                return userPromptSwimDiscipline();
            }
        }
        return null;
    }

    //#########################  Member - Set multiple swim disciplines  ################################
    public void setMultipleDisciplines() {

        System.out.println("Reminder: The member ID can be found when fetching a list of registered swimmers.\n");
        System.out.println("Please input the member ID you would like to apply changes to.");
        int idToFind = input.nextInt();
        input.nextLine();
        Member memberToFind = findMemberById(idToFind); //Vi taster member id for at returnere et member objekt at redigere svømmediscipliner på.

        if (memberToFind instanceof CompetitionMember downcastedMemberToFind) { //downcaster vores member objekt direkte i if-sætning til downcastedMemberToFind.
            if (hasAvailableDisciplines(downcastedMemberToFind)) { //boolean hasAvailableDisciplines() tjekker, om vores objekt har tilgængeligt med plads til en svømmedisciplin.
                SwimDiscipline selectedDiscipline = userPromptSwimDiscipline(); //Vi vælger vores disciplin og gemmer i variabel.
                if (!hasDiscipline(downcastedMemberToFind, selectedDiscipline)) { //Hvis det specifikke objekt ikke har den disciplin, de prompter efter, kan det tildeles
                    if (downcastedMemberToFind.getSwimDiscipline1() == SwimDiscipline.NULL) {
                        downcastedMemberToFind.setSwimDiscipline1(selectedDiscipline);
                        System.out.println(selectedDiscipline + " has successfully been assigned to " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    } else if (downcastedMemberToFind.getSwimDiscipline2() == SwimDiscipline.NULL) {
                        downcastedMemberToFind.setSwimDiscipline2(selectedDiscipline);
                        System.out.println(selectedDiscipline + " has successfully been assigned to " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    } else if (downcastedMemberToFind.getSwimDiscipline3() == SwimDiscipline.NULL) {
                        downcastedMemberToFind.setSwimDiscipline3(selectedDiscipline);
                        System.out.println(selectedDiscipline + " has successfully been assigned to " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    } else if (downcastedMemberToFind.getSwimDiscipline4() == SwimDiscipline.NULL) {
                        downcastedMemberToFind.setSwimDiscipline4(selectedDiscipline);
                        System.out.println(selectedDiscipline + " has successfully been assigned to " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    } else {
                        System.out.println("You are currently at at max amount of attached swimming disciplines available.");
                    }
                } else {
                    System.out.println(selectedDiscipline + " has already been assigned to " + memberToFind.getFirstName() + " " + memberToFind.getLastName() + "(" + "Member ID: " + memberToFind.getMemberID() + ")");
                }
            } else {
                System.out.println("You have assigned all available disciplines. ");
            }
        }
    }

    public boolean hasAvailableDisciplines(CompetitionMember member) { //Tjekker om member objektets 4 svømmediscipliner er sandt til null.(Det er 3 per default.
        return member.getSwimDiscipline1() == SwimDiscipline.NULL ||
                member.getSwimDiscipline2() == SwimDiscipline.NULL ||
                member.getSwimDiscipline3() == SwimDiscipline.NULL ||
                member.getSwimDiscipline4() == SwimDiscipline.NULL;
    }

    public boolean hasDiscipline(CompetitionMember member, SwimDiscipline discipline) { //Tjekker det specifikke member objekts 4 svømmediscipliner op mod en specifik svømmedisciplin
        return member.getSwimDiscipline1() == discipline ||
                member.getSwimDiscipline2() == discipline ||
                member.getSwimDiscipline3() == discipline ||
                member.getSwimDiscipline4() == discipline;
    }

    public void deleteSwimDisciplines() throws InputMismatchException {
        System.out.println("Reminder: The member ID can be found when fetching a list of registered swimmers.\n");
        System.out.println("Please input the member ID you would like to apply changes to.");

        int idToFind = input.nextInt();
        input.nextLine();
        Member memberToFind = findMemberById(idToFind);

        if (memberToFind instanceof CompetitionMember downcastedMemberToFind) {
            //TODO: Fjerne muligheder ved null svømmediscipliner
            System.out.println("1. " + downcastedMemberToFind.getSwimDiscipline1());
            System.out.println("2. " + downcastedMemberToFind.getSwimDiscipline2());
            System.out.println("3. " + downcastedMemberToFind.getSwimDiscipline3());
            System.out.println("4. " + downcastedMemberToFind.getSwimDiscipline4());
            System.out.println("\nPlease select the discipline you would like to delete.");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    SwimDiscipline disciplineName = downcastedMemberToFind.getSwimDiscipline1();
                    downcastedMemberToFind.setSwimDiscipline1(SwimDiscipline.NULL);
                    System.out.println(disciplineName + " has successfully been deleted from " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    break;
                }
                case 2: {
                    SwimDiscipline disciplineName = downcastedMemberToFind.getSwimDiscipline2();
                    downcastedMemberToFind.setSwimDiscipline2(SwimDiscipline.NULL);
                    System.out.println(disciplineName + " has successfully been deleted from " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    break;
                }
                case 3: {
                    SwimDiscipline disciplineName = downcastedMemberToFind.getSwimDiscipline3();
                    downcastedMemberToFind.setSwimDiscipline3(SwimDiscipline.NULL);
                    System.out.println(disciplineName + " has successfully been deleted from " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    break;
                }
                case 4: {
                    SwimDiscipline disciplineName = downcastedMemberToFind.getSwimDiscipline4();
                    downcastedMemberToFind.setSwimDiscipline4(SwimDiscipline.NULL);
                    System.out.println(disciplineName + " has successfully been deleted from " + downcastedMemberToFind.getFirstName() + " " + downcastedMemberToFind.getLastName() + ".");
                    break;
                }
            }
        }
    }

    public Member findMemberById(int idToFind) {
        for (Member member : controller.getMembersList()) {
            if (member.getMemberID() == idToFind) {
                if (member instanceof CompetitionMember) {
                    return member;
                }
                if (member instanceof ExerciseMember) {
                    return member;
                }
            }
        }
        return null;
    }

    public void findMemberSearchWithNewArray() { // Ved ikke om vi skal bruge denne metode, men den er vel rar at have
        System.out.println("Please type in the first name of the member you are looking for.");
        int count = 1;
        String memberToFind = input.nextLine();

        controller.searchMember(memberToFind);
        System.out.println("Number of members found: " + controller.getSearchMatch().size());
        if (!controller.getSearchMatch().isEmpty()) {
            System.out.println("The following members are registered: ");
            for (Member member : controller.getSearchMatch()) {
                if (member instanceof CompetitionMember) {
                    System.out.println(count + ". " + member);
                    count++;
                }
                if (member instanceof ExerciseMember) {
                    System.out.println(count + ". " + member);
                    count++;
                }
            }

        } else {
            System.out.println("No members with that name has been registered.");
        }
    }


    //######################### See list of members  ################################
    public void displayListofMembers() {
        if (!controller.getMembersList().isEmpty()) {
            System.out.println("Displaying list of current members: ");
            for (Member m : controller.getMembersList()) {
                if (m instanceof CompetitionMember) {
                    System.out.println("Competition Swimmers: ");
                    System.out.println(m.toString());
                }
                if (m instanceof ExerciseMember) {
                    System.out.println("Exercise Swimmers: ");
                    System.out.println(m.toString());
                }
            }
        } else {
            System.out.println("No registered swimmers found.");
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
