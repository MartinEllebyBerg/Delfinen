package ui;

import domain_model.Controller;

import java.sql.SQLOutput;
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
        while(switchInput != SENTINEL) {
            System.out.println("Delfinen UI - ALPHA");
            System.out.println(" ");
            System.out.println("1. -NOTIMPLEMENTED-");
            System.out.println("2. -NOTIMPLEMENTED-");

            System.out.print("> ");
            switchInput = scanIntSafely();

            switch (switchInput) {

                case 1: {

                }
                case 2: {

                }

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
