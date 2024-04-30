package domain_model;

import domain_model.Member;

import java.time.LocalDate;

public abstract class SwimmerExercise extends Member {


    //ATTRIBUTES
    private TrainingResult trainingResult = null;
    private CompResult competitionResult = null;

    //CONSTRUCTOR
    public SwimmerExercise(String firstName, String lastName, LocalDate birthday, boolean memberActive, TrainingResult trainingResult, CompResult competitionResult) {
        super(firstName, lastName, birthday, memberActive);
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }
        //METHODS
        @Override
        public double calculateMembershipRate() {
        // Her kommer kode
            return 0;
        }
}