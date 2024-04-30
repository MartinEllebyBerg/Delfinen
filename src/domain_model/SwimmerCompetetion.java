package domain_model;

import java.time.LocalDate;

public class SwimmerCompetetion extends Member {


    //ATTRIBUTES
    private TrainingResult trainingResult;
    private CompResult competitionResult;

    //CONSTRUCTOR
    public SwimmerCompetetion(String firstName, String lastName, LocalDate birthday, boolean memberActive, TrainingResult trainingResult, CompResult competitionResult) {
        super(firstName, lastName, birthday, memberActive);
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }

    //METHODS

}
