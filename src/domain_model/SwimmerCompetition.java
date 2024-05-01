package domain_model;

import java.time.LocalDate;

public class SwimmerCompetition extends Member {


    //ATTRIBUTES
    private ResultTraining trainingResult;
    private ResultCompetition competitionResult;

    //CONSTRUCTOR
    public SwimmerCompetition(String firstName, String lastName, LocalDate birthday, boolean memberActive, ResultTraining trainingResult, ResultCompetition competitionResult) {
        super(firstName, lastName, birthday, memberActive);
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }

    //METHODS

}
