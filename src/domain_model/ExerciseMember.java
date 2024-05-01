package domain_model;

import java.time.LocalDate;

public class ExerciseMember extends Member {


    //ATTRIBUTES
    private ResultSwimmer competitionResult = null;

    //CONSTRUCTOR
    public ExerciseMember(String firstName, String lastName, LocalDate birthday, boolean memberActive, ResultSwimmer competitionResult) {
        super(firstName, lastName, birthday, memberActive);
        this.competitionResult = competitionResult;
    }
        //METHODS

}