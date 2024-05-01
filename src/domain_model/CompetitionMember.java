package domain_model;

import java.time.LocalDate;

public class CompetitionMember extends Member {


    //ATTRIBUTES
   private

    //CONSTRUCTOR
    public CompetitionMember(String firstName, String lastName, LocalDate birthday, boolean memberActive) {
        super(firstName, lastName, birthday, memberActive);
        this.trainingResult = trainingResult;
        this.competitionResult = competitionResult;
    }

    //METHODS

}
