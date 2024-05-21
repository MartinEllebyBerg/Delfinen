package ui;

import domain_model.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    //ATTRIBUTES
    private Controller controller;
    private Scanner input;
    private final int SENTINEL = 0;
    private int switchInput = -1;

    //CONSTRUCTOR
    public UserInterface() {

        try {
            controller = new Controller();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong loading the list."+e.getMessage());
            throw new RuntimeException(e);
        }
        input = new Scanner(System.in);
        delfinenUISetPosition();
    }

    //METHODS
    //######################### Determine position within Delfinen to get a different UI  ################################
    public void delfinenUISetPosition() {
        System.out.println("Welcome to Delfinen's member administration program. Please input your role within Delfinen.");
        System.out.println("CHAIRMAN | TREASURER | COACH");
        boolean condition = true;

        while (condition) {
            System.out.print("> ");
            String switchChoice = input.nextLine().toLowerCase();

            switch (switchChoice) {
                case "chairman", "ch", "cha", "chai", "chair", "chairm", "chairma" -> {
                    startProgramChairman();
                    condition = false;
                }
                case "treasurer", "tre", "trea", "treas", "treasu", "treasur", "treasure", "t", "tr" -> {
                    startProgramTreasurer();
                    condition = false;
                }
                case "coach", "co", "coa", "coac" -> {
                    startProgramCoach();
                    condition = false;
                }
                default -> {
                    System.out.println("Invalid input. Please input either Chairman, Treasurer or Coach.");
                    if (switchChoice.equals("c")) {
                        System.out.println("'c' is invalid input as that could either mean Chairman or Coach.");
                    }
                }
            }
        }
    }

    //######################### Different UI based on position within Delfinen  ################################
    //######################### Chairman menu(s)  ################################
    public void displayMenuChairman() {
        System.out.println(" ");
        System.out.println("Delfinen - CHAIRMAN");
        System.out.println(" ");
        System.out.println("1. Add Swimmer");
        System.out.println("2. Display list of Swimmers");
        System.out.println("3. Show Treasurer Menu");
        System.out.println("4. Show Coach Menu");
        System.out.println("5. Show Member/Result Overview");
        System.out.println("0. Terminate program");
    }

    public void startProgramChairman() {
        while (switchInput != SENTINEL) {
            displayMenuChairman();
            System.out.print("> ");
            switchInput = scanIntSafely();
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
                    displayChairmanShowTreasurerMenu();
                    break;
                }
                case 4: {
                    displayChairmanShowCoachMenu();
                    break;
                }
                case 5: {
                    displayMembersResultsCompTrain();
                    break;
                }
                case 0: {
                    System.out.println("Terminating application.");
                    break; //Failsafe
                }
            }
        }
    }

    public void displayChairmanShowCoachMenu() {
        displayMenuCoach();
        switchInput = scanIntSafely();
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
            case 4: {
                addSwimmerResults();
                break;
            }
            case 5: {
                searchForMemberResultIdToId();
                break;
            }
            case 6: {
                sortBySwimTime();
                break;
            }
            case 7: {
                displayMembersResultsCompTrain();
                break;
            }
        }
    }

    public void displayChairmanShowTreasurerMenu() {
        displayMenuTreasurer();
        switchInput = scanIntSafely();
        input.nextLine();

        switch (switchInput) {
            case 1: {
                displayListofMembers();
                break;
            }
            case 2: {
                registerPayment();
                break;
            }
            case 3: {
                printOverduePayments();
                showSumOverduePayments();
                break;
            }
            case 4: {
                calculateTotalRateForecast();
                calculateTotalRateForecastPlus5Youth();
                calculateTotalRateForecastPlus5Senior();
                break;
            }
        }
    }

    //######################### Treasurer Menu  ################################
    public void displayMenuTreasurer() {
        System.out.println(" ");
        System.out.println("Delfinen - TREASURER");
        System.out.println(" ");
        System.out.println("1. Display list of Swimmers");
        System.out.println("2. Register payment of Membership");
        System.out.println("3. List of overdue Payments");
        System.out.println("4. Forecast\n");
        System.out.println("0. Terminate program");
    }

    public void startProgramTreasurer() {
        while (switchInput != SENTINEL) {
            displayMenuTreasurer();
            System.out.print("> ");
            switchInput = scanIntSafely();
            input.nextLine();

            switch (switchInput) {
                case 1: {
                    displayListofMembers();
                    break;
                }
                case 2: {
                    registerPayment();
                    break;
                }
                case 3: {
                    printOverduePayments();
                    showSumOverduePayments();
                    break;
                }
                case 4: {
                    calculateTotalRateForecast();
                    calculateTotalRateForecastPlus5Youth();
                    calculateTotalRateForecastPlus5Senior();
                    break;
                }
                case 0: {
                    System.out.println("Terminating application.");
                    break; //Failsafe
                }
            }
        }
    }

    //######################### Coach menu(s)  ################################
    public void displayMenuCoach() {
        System.out.println(" ");
        System.out.println("Delfinen - COACH");
        System.out.println(" ");
        System.out.println("1. Register Swimmer Disciplines");
        System.out.println("2. Delete Swimmer Disciplines");
        System.out.println("3. Display list of Swimmers");
        System.out.println("4. Register Swimmer Results(Training/Competition)");
        System.out.println("5. Search for Training/Competition results by Swimmer ID");
        System.out.println("6. Sort by Swimtime");
        System.out.println("7. Show Member/Result Overview\n");
        System.out.println("0. Terminate program");
    }

    public void startProgramCoach() {

        while (switchInput != SENTINEL) {
            displayMenuCoach();
            System.out.print("> ");
            switchInput = scanIntSafely();
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
                case 4: {
                    addSwimmerResults();
                    break;
                }
                case 5: {
                    searchForMemberResultIdToId();
                    break;
                }
                case 6: {
                    displayMembersResultsCompTrain();
                    break;
                }
                case 7: {
                    sortBySwimTime();
                    break;
                }
                case 0: {
                    System.out.println("Terminating application.");
                    break; //Failsafe
                }
            }
        }
    }

    public void displayMembersResultsCompTrain() {
        System.out.println("1. Show Competition Members - Junior");
        System.out.println("2. Show Competition Members - Senior");
        System.out.println("3. Show Competition Results");
        System.out.println("4. Show Training Results");
        switchInput = scanIntSafely();
        input.nextLine();

        switch (switchInput) {
            case 1: {
                showCompetitionJunior();
                break;
            }
            case 2: {
                showCompetitionSenior();
                break;
            }
            case 3: {
                showResultListCompetition();
                break;
            }
            case 4: {
                showResultListTraining();
                break;
            }
        }
    }

    //######################### Adding Member  ################################
    public void generateSwimmer() {
        int memberID = controller.nextMemberID(); //her kaldes metode som tager antal poster i memberslist plus 1

        boolean paymentRegistered = false;
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
        boolean decidingWhatTypeOfSwimmer = compOrExerciseSwimmer(); //Assigner, om der skal laves et konkurrence eller motionist objekt.

        if (decidingWhatTypeOfSwimmer) {
            System.out.println("During this registration you will be able to select one swim discipline for the member.");
            System.out.println("Afterwards, you will be able to set multiple disciplines for selected swimmer.\n");
            SwimDiscipline firstDiscipline = userPromptSwimDiscipline();
            Member m = new CompetitionMember(memberID, firstName, lastName, birthday, activePassive, paymentRegistered, firstDiscipline, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL);
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
            Member m = new ExerciseMember(memberID, firstName, lastName, birthday, activePassive, paymentRegistered);
            controller.addToMembersList(m);
            System.out.println("You have now successfully added " + firstName + " " + lastName);
        } else {
            System.out.println("Something went wrong. Returning to menu.");
        }
        saveMembersToList();
    }

    public void addSwimmerResults() {
        System.out.println("Please input Training/Competition to register training or competition results:");

        String userChoice = input.nextLine();
        if (userChoice.toLowerCase().equals("training")) {
            boolean resultInputFinished = false; // boolean til at slutte while loopet herunder når brugeren er færdig med at inputte resultatet.
            while (!resultInputFinished) { // while loop der tvinger brugeren til at inputte et memberID på en competition member.
                boolean isCompetitive = false;
                System.out.println("Type the memberID of a competition member whose training results you wish to register:");
                int memberID = scanIntSafely();
                input.nextLine();

                controller.findIndexToBeChanged(memberID);
                String name = controller.findNameByIndex();
                System.out.println("You are registering training result on member: " + name);

                CompetitionMember competitionMember = controller.findCompetitionMemberById(memberID); // instans af CompetitionMember som tjekker om det inputtede memberID tilhører en competition member.
                if (competitionMember != null) { // hvis den finder et memberID der tilhører en competition member så begynder resultatregistreringen.
                    SwimDiscipline disciplineName = userPromptSwimDiscipline(); //Denne metode spørger om brugerinput med tilhørende sysoutbeskeder.

                    System.out.println("Type the swim time:");
                    double swimTime = scanDoubleSafely();
                    input.nextLine();

                    LocalDate localDate = null;
                    boolean validInput = false;

                    while (!validInput) {
                        System.out.println("Type the result date in the following format YYYY-MM-DD: ");

                        String localDateInput = input.nextLine(); //Brugerinput gemmes

                        try {
                            localDate = LocalDate.parse(localDateInput); //LocalDate.parse læser de nødvendige attributter fra birthdayStr og parser dem til YYYY-MM-DD
                            validInput = true; //Vi afslutter while loopet.
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid input. Please type your input in the following format YYYY-MM-DD:");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please type your input in the following format YYYY-MM-DD. Example: 1992-12-12" +
                                    "if the date of the result was the 12th of December in 1992.");
                        }
                    }
                    controller.addSwimResultTraining(isCompetitive, memberID, disciplineName, swimTime, localDate);
                    System.out.println("Successfully added a training result for a swimmer with the following member ID: " + memberID);
                    resultInputFinished = true;
                } else {
                    System.out.println("You cannot register results for exercise members.");
                }
            }
        } else if (userChoice.toLowerCase().equals("competition")) {
            boolean resultInputFinished = false; // boolean til at slutte while loopet herunder når brugeren er færdig med at inputte resultatet.
            while (!resultInputFinished) { // while loop der sørger for at den bliver ved med at tvinge brugeren til at inputte et memberID på en competition member.
                boolean isCompetitive = true;
                System.out.println("Type the memberID of a competition member whose competition results you wish to register:");
                int memberID = scanIntSafely();
                input.nextLine();

                controller.findIndexToBeChanged(memberID);
                String name = controller.findNameByIndex();
                System.out.println("You are registering competition result on member: " + name);

                CompetitionMember competitionMember = controller.findCompetitionMemberById(memberID); // instans af CompetitionMember som tjekker om det inputtede memberID tilhører en competition member.
                if (competitionMember != null) { // hvis den finder et memberID der tilhører en competition member så begynder resultatregistreringen.
                    System.out.println("Type the competition location:");
                    String competitionLocation = input.nextLine();

                    System.out.println("Type the competition name:");
                    String competitionName = input.nextLine();

                    LocalDate localDate = null;
                    boolean validInput = false;

                    while (!validInput) {
                        System.out.println("Type the result date in the following format YYYY-MM-DD: ");

                        String localDateInput = input.nextLine(); //Brugerinput gemmes

                        try {
                            localDate = LocalDate.parse(localDateInput); //LocalDate.parse læser de nødvendige attributter fra birthdayStr og parser dem til YYYY-MM-DD
                            validInput = true; //Vi afslutter while loopet.
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid input. Please type your input in the following format YYYY-MM-DD:");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please type your input in the following format YYYY-MM-DD. Example: 1992-12-12" +
                                    "if the date of the result was the 12th of December in 1992.");
                        }
                    }
                    SwimDiscipline disciplineName = userPromptSwimDiscipline(); //Denne metode spørger om brugerinput med tilhørende sysoutbeskeder.

                    System.out.println("Type the swim time:");
                    double swimTime = scanDoubleSafely();
                    input.nextLine();
                    System.out.println("Type the placement:");
                    int placementCompetition = scanIntSafely();
                    input.nextLine();

                    controller.addSwimResultCompetition(isCompetitive, memberID, competitionLocation, competitionName, localDate, disciplineName, swimTime, placementCompetition);
                    System.out.println("Successfully added a competition result for a swimmer with the following member ID: " + memberID);
                    resultInputFinished = true;
                } else {
                    System.out.println("You cannot register results for exercise members.");
                }
            }
        }
        saveAllResults();
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
                return e;
            }
        }
        return null;
    }

    public SwimDiscipline userPromptSwimDiscipline() {
        String UPSWDInput = " ";
        System.out.println("\nPlease type in which swim discipline to register.");
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
        int idToFind = scanIntSafely();
        input.nextLine();
        Member memberToFind = controller.findMemberById(idToFind); //Vi taster member id for at returnere et member objekt at redigere svømmediscipliner på.
        String memberFirstName = memberToFind.getFirstName();
        String memberLastName = memberToFind.getLastName();
        System.out.println("You are in the process of making changes to: " + memberFirstName + " " + memberLastName);
        System.out.println("Press 1 if you want to proceed with this member, press 2 if you want to see some more information on this member \nor press 3 if you will search for a new member and memberID");
        int choice = scanIntSafely();

        if (choice == 1) {
            if (memberToFind instanceof CompetitionMember downcastedMemberToFind) { //downcaster vores member objekt direkte i if-sætning til downcastedMemberToFin
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
                            System.out.println("You are currently at at max amount of attached swimmingdisciplines available.");
                        }
                    } else {
                        System.out.println(selectedDiscipline + " has already been assigned to " + memberToFind.getFirstName() + " " + memberToFind.getLastName() + "(" + "Member ID: " + memberToFind.getMemberID() + ")");
                    }
                } else {
                    System.out.println("You have assigned all available disciplines. ");
                }
            }
        } else if (choice == 2) {
            System.out.println(controller.showDataSpecificMember(idToFind));
        } else if (choice == 3) {
            input.nextLine();//for at undgå scanner bug
            findMemberSearchWithNewArray();
            setMultipleDisciplines();
        } else {
            System.out.println("Invalid input");
        }
        saveMembersToList();
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

        int idToFind = scanIntSafely();
        input.nextLine();
        Member memberToFind = controller.findMemberById(idToFind);
        String memberFirstName = memberToFind.getFirstName();
        String memberLastName = memberToFind.getLastName();

        System.out.println("You have picked: " + memberFirstName + " " + memberLastName);

        if (memberToFind instanceof CompetitionMember downcastedMemberToFind) {
            //TODO (NICE-TO): Fjerne muligheder ved null svømmediscipliner
            System.out.println("1. " + downcastedMemberToFind.getSwimDiscipline1());
            System.out.println("2. " + downcastedMemberToFind.getSwimDiscipline2());
            System.out.println("3. " + downcastedMemberToFind.getSwimDiscipline3());
            System.out.println("4. " + downcastedMemberToFind.getSwimDiscipline4());
            System.out.println("\nPlease select the discipline you would like to delete.");
            int choice = scanIntSafely();
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
        saveMembersToList();
    }

    //#########################  Member - Search methods ################################
    public void findMemberSearchWithNewArray() {
        System.out.println("Please type in the first name of the member you are looking for.");
        String memberToFind = input.nextLine();
        controller.searchMember(memberToFind);

        if (!controller.getSearchMatch().isEmpty()) {
            System.out.println("Following member/members are registered:");
            for (Member member : controller.getSearchMatch()) {
                System.out.println(member.toString());
            }
        } else {
            System.out.println("No members with that name has been registered.");
        }
    }

    public void searchForMemberResultIdToId() {
        System.out.println("Please input the member ID of which you wish to access training or competition results.");
        System.out.print("> ");
        int idToFind = input.nextInt();
        input.nextLine();
        Member m = controller.findMemberById(idToFind);
        if (m != null) {
            String result = controller.findSwimmersResultTraining(m);
            System.out.println(result);
        } else {
            System.out.println("Something went wrong. No member ID or result ID was found. Try again with an active member list or load the list from the CSV file.");
        }
    }

    //######################### See list of members  ################################
    public void displayListofMembers() {
        if (!controller.getMembersList().isEmpty()) {
            System.out.println("Displaying list of current members: ");
            for (Member m : controller.getMembersList()) {
                if (m instanceof CompetitionMember) {
                    System.out.println(m.toString());
                    System.out.println("Competition swimmer ");
                }
                if (m instanceof ExerciseMember) {
                    System.out.println(m.toString());
                    System.out.println("Exercise swimmer ");
                }
            }
        } else {
            System.out.println("No registered swimmers found.");
        }
    }

    //######################### Economic forecasting  ################################
    public void calculateTotalRateForecast() {
        System.out.println(" ");
        System.out.println("Calculation of expected income (payment membership rate) based on current membership status: ");
        double result = controller.calculateTotalRateForecast();
        System.out.println("Total: " + result + " DKK/year.");
    }

    public void calculateTotalRateForecastPlus5Youth() {
        System.out.println(" ");
        System.out.println("Calculation of expected income if 5% increase in Youth members: ");
        double result = controller.calculateTotalRateForecastPlus5Youth();
        System.out.println("Total: " + result + " DKK/year.");
    }

    public void calculateTotalRateForecastPlus5Senior() {
        System.out.println(" ");
        System.out.println("Calculation of expected income if 5% increase in Senior members: ");
        double result = controller.calculateTotalRateForecastPlus5Senior();
        System.out.println("Total: " + result + " DKK/year.");
    }

    //######################### Payments  ################################
    public void registerPayment() {
        System.out.println(" ");
        System.out.println("Please note in order to register a payment you will need the memberID of the specific member you want to alter");
        System.out.println("Type 1 - if you will search for memberID");
        System.out.println("Type 2 - if you have the memberID and are ready to register payment");
        switchInput = scanIntSafely();
        input.nextLine();

        if (switchInput == 1) {
            findMemberSearchWithNewArray();
            registerPayment();

        } else if (switchInput == 2) {
            System.out.println("Type memberID of the member you want to register payment on:");
            switchInput = scanIntSafely();
            controller.findIndexToBeChanged(switchInput);
            String name = controller.findNameByIndex();
            System.out.println("You want to register payment on member: " + name);
            System.out.println("Is this correct? Type 1 if correct and type 2 if not.");
            switchInput = scanIntSafely();
            input.nextLine();
            if (switchInput == 1) {
                controller.registerPayment();
                System.out.println("\nPayment has now been registered on the member.");
            } else if (switchInput == 2) {
                registerPayment();
            } else {
                System.out.println("Please choose either 1 or 2");
                registerPayment();
            }
        }
        saveMembersToList();
    }

    public void printOverduePayments() {
        ArrayList<String> overduePayments = controller.printOverduePayments();
        for (String overduePayment : overduePayments) {
            System.out.println(overduePayment);
        }
    }

    public void showSumOverduePayments() {
        System.out.println("In total overdue: " + controller.sumOverduePayments() + " DKK");
    }

    //######################### Save & load list  ################################
    public void saveMembersToList() {
        controller.saveAllMembersToList(controller.getMembersList());
        System.out.println("Successfully saved list of members.");
    }

    public void saveAllResults() {
        controller.saveAllResults(controller.getResultList());
        System.out.println("Successfully saved competition result");
    }

    //#########################  Showing lists of recorded swimmer results - Comp/Train - Senior/Junior  ################################
    public void showCompetitionJunior() {
        System.out.println("\nCompetition members under 18 years:");
        controller.printCompetitionJunior();
        for (Member m : controller.getJuniorList()) {
            System.out.println(m.toString());
        }
    }

    public void showCompetitionSenior() {
        System.out.println("Competition members over 18 years:");
        controller.printCompetitionSenior();
        for (Member m : controller.getSeniorList()) {
            System.out.println(m.toString());
        }
    }

    public void showResultListCompetition() {
        System.out.println("\nCompetition results:");
        controller.showResultListCompetition();
        for (ResultSwimmer rs : controller.getSearchList()) {
            Member m = controller.findMemberById(rs.getMemberID());
            System.out.println(rs.toStringSwimIDMemberId(m));
        }
    }

    public void showResultListTraining() {
        System.out.println("\nTraining results:");
        controller.showResultListTraining();
        for (ResultSwimmer rs : controller.getSearchList()) {
            Member m = controller.findMemberById(rs.getMemberID());
            System.out.println(rs.toStringSwimIDMemberId(m));
        }
    }

    //######################### Sorting ResultSwimmer - Training & Competition results  ################################
    public void sortBySwimTime() {
        controller.copyResultListToListToBeSorted();
        if (!controller.getListToBeSorted().isEmpty()) {
            System.out.println("Resultlist successfully copied to listToBeSorted.");
        } else {
            System.out.println("listToBeSorted failed to populate. UI.793.");
        }
        System.out.println(controller.sortBySwimTime());
    }

    //######################### Scanning int & doubles safely - recursion  ################################
    private int scanIntSafely() { //Metode til at fange hvis man skriver et bogstav i en int scanner, der ellers vil melde en fejl
        try {
            return input.nextInt(); // Her tester den om der bliver tastet en int ind i scanneren
        } catch (InputMismatchException ime) {
            input.nextLine(); // Scanneren skal lige forstå, at den nu skal være klar til at læse på en ny linje
            System.out.println("You didn't type in a number - please try again:");
            return scanIntSafely(); // Rekursion: Metoden kalder sig selv, og starter dermed forfra med et nyt try!
        }
    }

    private double scanDoubleSafely() {
        try {
            return input.nextDouble();
        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("You didn't type in a number correctly. Please use the comma (' , ') as a decimal separator. (Example: 21,5) ");
            return scanDoubleSafely();
        }
    }
}