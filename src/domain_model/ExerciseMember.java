package domain_model;

import java.time.LocalDate;

public class ExerciseMember extends Member {


    //ATTRIBUTES



    //CONSTRUCTOR
    public ExerciseMember(String firstName, String lastName, LocalDate birthday, boolean memberActive, boolean paymentRegistered) {
        super(firstName, lastName, birthday, memberActive, paymentRegistered);


    }
        //METHODS


    @Override
    public String toString() {
        String result = " ";
        return super.toString();
    }
}