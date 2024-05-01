package domain_model;

import java.time.LocalDate;

public class CompetitionMember extends Member {


    //ATTRIBUTES
    private SwimDiscipline swimDiscipline1 = null;
    private SwimDiscipline swimDiscipline2= null;
    private SwimDiscipline swimDiscipline3 = null;
    private SwimDiscipline swimDiscipline4 = null;


    //CONSTRUCTOR
    public CompetitionMember(String firstName, String lastName, LocalDate birthday, boolean memberActive, SwimDiscipline swimDiscipline1, SwimDiscipline swimDiscipline2, SwimDiscipline swimDiscipline3, SwimDiscipline swimDiscipline4) {
        super(firstName, lastName, birthday, memberActive);
        this.swimDiscipline1 = swimDiscipline1;
        this.swimDiscipline2 = swimDiscipline2;
        this.swimDiscipline3 = swimDiscipline3;
        this.swimDiscipline4 = swimDiscipline4;}

    //METHODS


    public SwimDiscipline getSwimDiscipline1() {
        return swimDiscipline1;
    }

    public SwimDiscipline getSwimDiscipline2() {
        return swimDiscipline2;
    }

    public SwimDiscipline getSwimDiscipline3() {
        return swimDiscipline3;
    }

    public SwimDiscipline getSwimDiscipline4() {
        return swimDiscipline4;
    }
}
