package domain_model;

import java.time.LocalDate;

public class SwimmerExercise extends Member {


    //ATTRIBUTES
    private ResultTraining trainingResult = null;
    private ResultCompetition competitionResult = null;

    //CONSTRUCTOR
    public SwimmerExercise(String firstName, String lastName, LocalDate birthday, boolean memberActive, ResultTraining trainingResult, ResultCompetition competitionResult) {
        super(firstName, lastName, birthday, memberActive);
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }
        //METHODS

}