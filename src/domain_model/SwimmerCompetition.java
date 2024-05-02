package domain_model;

import java.time.LocalDate;

public class SwimmerCompetition extends Member {


    //ATTRIBUTES
    private ResultSwimmer trainingResult; //arbejder på at tage ResultSwimmer ud af constructor, men i stedet skal dette kunne
    //sættes på den enkelte svømmer senere (via unikdt medlemsID
    private ResultSwimmer competitionResult;

    //CONSTRUCTOR
    public SwimmerCompetition(String firstName, String lastName, LocalDate birthday, boolean memberActive) {
        super(firstName, lastName, birthday, memberActive);
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }

    //METHODS


}
