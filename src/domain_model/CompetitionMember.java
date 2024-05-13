package domain_model;

import java.time.LocalDate;

public class CompetitionMember extends Member {


    //ATTRIBUTES
    private SwimDiscipline swimDiscipline1 = null;
    private SwimDiscipline swimDiscipline2= null;
    private SwimDiscipline swimDiscipline3 = null;
    private SwimDiscipline swimDiscipline4 = null;
    private ResultSwimmer latestResults;


    public void setSwimDiscipline1(SwimDiscipline swimDiscipline1) {
        this.swimDiscipline1 = swimDiscipline1;
    }

    public void setSwimDiscipline2(SwimDiscipline swimDiscipline2) {
        this.swimDiscipline2 = swimDiscipline2;
    }

    public void setSwimDiscipline3(SwimDiscipline swimDiscipline3) {
        this.swimDiscipline3 = swimDiscipline3;
    }

    public void setSwimDiscipline4(SwimDiscipline swimDiscipline4) {
        this.swimDiscipline4 = swimDiscipline4;
    }

    //CONSTRUCTOR
    public CompetitionMember(int memberID, String firstName, String lastName, LocalDate birthday, boolean memberActive, boolean paymentRegistered, SwimDiscipline swimDiscipline1, SwimDiscipline swimDiscipline2, SwimDiscipline swimDiscipline3, SwimDiscipline swimDiscipline4) {
        super(memberID, firstName, lastName, birthday, memberActive, paymentRegistered);
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
    public void setLatestResults(ResultSwimmer latestResults) {
        this.latestResults = latestResults;
    }

    public ResultSwimmer getLatestResults() {
        return latestResults;
    }

    @Override
    public String toString() {
        String result ="";
        result += "\nSwimming disciplines: ";
        if (getSwimDiscipline1() != SwimDiscipline.NULL) {
            result += ""+getSwimDiscipline1();
        }
        if (getSwimDiscipline2() != SwimDiscipline.NULL) {
            result += "\t|\t"+getSwimDiscipline2();
        }
        if (getSwimDiscipline3() != SwimDiscipline.NULL) {
            result += "\t|\t"+getSwimDiscipline3();
        }
        if (getSwimDiscipline4() != SwimDiscipline.NULL) {
            result += "\t|\t"+getSwimDiscipline4();
        }
        return super.toString()+result;
    }
}
