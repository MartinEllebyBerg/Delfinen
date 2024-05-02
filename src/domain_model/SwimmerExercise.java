package domain_model;

import java.time.LocalDate;

public class SwimmerExercise extends Member {


    //ATTRIBUTES
    private ResultSwimmer competitionResult = null;

    //CONSTRUCTOR
    public SwimmerExercise(String firstName, String lastName, LocalDate birthday, boolean memberActive) {
        super(firstName, lastName, birthday, memberActive);
        this.competitionResult = competitionResult;
    }
        //METHODS''

}