package domain_model;

import java.time.LocalDate;
import java.time.Period;

public class Member {

    //ATTRIBUTES
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private boolean memberActive;
    //private static int nextMemberID = 1; //statisk attribut til at sammentælle memberID og sørge for unikt nummer.
    private int memberID;
    private int yearsOfAge;
    private double rate;
    private boolean paymentRegistered;


    //CONSTRUCTOR
    public Member(int memberID, String firstName, String lastName, LocalDate birthday, boolean memberActive,boolean paymentRegistered) {
        this.memberID = memberID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.memberActive = memberActive;
        this.paymentRegistered = paymentRegistered;

        //memberID = nextMemberID++;
        calculateYearOfMember();
        calculateMembershipRate();
    }

    //METHODS

    public void calculateYearOfMember() {
        LocalDate presentTime = LocalDate.now();
        Period calculatedPeriode = Period.between(birthday, presentTime);
        yearsOfAge = calculatedPeriode.getYears();
    }

    public void calculateMembershipRate() {

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

    public double getRate() {
        return rate;
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

    public int getYearsOfAge() {
        return yearsOfAge;
    }

    public boolean isPaymentRegistered() {
        return paymentRegistered;
    }

    public void setPaymentRegistered(boolean paymentRegistered) {
        this.paymentRegistered = paymentRegistered;
    }

    @Override
    public String toString() {
        int ageCutoffSeniorTeam = 18;
        String result = "";
        result += "\nMemberID: " +memberID+ " Name: " + getFirstName() + " " + getLastName() + " Birthday: " + getBirthday() + " Years of age: " + yearsOfAge;
        if(getIsMemberActive()) {
            result += " Activity status: Active";
        } else {
            result += " Activity status: Passive";
        }
        if (yearsOfAge >= ageCutoffSeniorTeam) {
            result+= " Team: " + "Senior";
        } else {
            result += " Team: " + "Youth";
        }
        result += " Membership rate paid: " + paymentRegistered;
        return result;
    }

    public String toStringOverduePayments() {
        String result = "";
        result += "Member ID: " + memberID + " Name: " + getFirstName() + " " + getLastName() + " Rate paid: " + paymentRegistered + " Overdue rate: " + rate;
        return result;
    }
}
