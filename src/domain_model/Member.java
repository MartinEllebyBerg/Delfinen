package domain_model;

import java.time.LocalDate;
import java.time.Period;

public class Member {

    //ATTRIBUTES
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private boolean memberActive;
    private static int nextMemberID = 1; //statisk attribut til at sammentælle memberID og sørge for unikt nummer.
    private int memberID;
    private int yearsOfAge;
    private boolean paymentRegistered;


    //CONSTRUCTOR
    public Member(String firstName, String lastName, LocalDate birthday, boolean memberActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.memberActive = memberActive;

        memberID = nextMemberID++;
        paymentRegistered = false;
    }

    //METHODS

    public void calculateYearOfMember() {
        LocalDate presentTime = LocalDate.now();
        Period calculatedPeriode = Period.between(birthday, presentTime);
        yearsOfAge = calculatedPeriode.getYears();
    }

    public void calculateMembershipRate() {
        double rate;
        if (memberActive == false) {
            rate = 500.00;
        } else if (yearsOfAge < 18) {
            rate = 1000.00;
        } else if (yearsOfAge >= 18 && yearsOfAge < 60) {
            rate = 1600.00;
        } else {
            rate = 1200.00;
        }

    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean getIsMemberActive() {
        return memberActive;
    }

    public int getMemberID() {
        return memberID;
    }
    @Override
    public String toString() {
        String result = "";
        result += "Name: "+getFirstName()+" "+getLastName()+"\tBirthday: "+getBirthday();
        if(getIsMemberActive()) {
            result += "\tActivity status: Active";
        } else {
            result += "\tActivity status: Passive";
        }
        return result;
    }
}
