package domain_model;

import java.time.LocalDate;

public class Member {

    //ATTRIBUTES
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private boolean memberActive;
    private static int nextMemberID = 1; //statisk attribut til at sammentælle memberID og sørge for unikt nummer.
    private int memberID;

    //CONSTRUCTOR
    public Member(String firstName, String lastName, LocalDate birthday, boolean memberActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.memberActive = memberActive;
        memberID = nextMemberID++;
    }

    //METHODS
    public double calculateMembershipRate() {
        //Her kommer kode
        return 0;
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
}
