package domain_model;

import java.time.LocalDate;

public abstract class Member {

    //ATTRIBUTES
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private boolean memberActive;

    //CONSTRUCTOR
    public Member(String firstName, String lastName, LocalDate birthday, boolean memberActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.memberActive = memberActive;
    }

    //METHODS
    public abstract double calculateMembershipRate();

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
}
