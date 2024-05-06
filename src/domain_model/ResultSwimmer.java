package domain_model;

import java.time.LocalDate;

public class ResultSwimmer {

    //ATTRIBUTES
    private SwimDiscipline swimDiscipline;
    private String competitionName;
    private String competitionLocation;
    private double swimTime;
    private int placementCompetition;
    private LocalDate resultDate;
    private int memberID;

    //CONSTRUCTOR
    public ResultSwimmer(int memberID, String competitionLocation,String competitionName, LocalDate resultDate, SwimDiscipline swimDiscipline, double swimTime, int placementCompetition){
        this.memberID = memberID;
        this.competitionLocation = competitionLocation;
        this.competitionName = competitionName;
        this.resultDate = resultDate;
        this.swimDiscipline = swimDiscipline;
        this.swimTime = swimTime;
        this.placementCompetition = placementCompetition;
    }
    public ResultSwimmer(int memberID, SwimDiscipline swimDiscipline, double swimTime, LocalDate resultDate){
        this.memberID = memberID;
        this.swimDiscipline = swimDiscipline;
        this.swimTime = swimTime;
        this.resultDate = resultDate;
    }

    //METHODS
    @Override
    public String toString() {
        return "ResultSwimmer: " +
                "swimID: " + memberID + '\'' +
                ", swimDiscipline: " + swimDiscipline + '\'' +
                ", competitionName: " + competitionName + '\'' +
                ", competitionLocation='" + competitionLocation + '\'' +
                ", swimTime=" + swimTime +
                ", placementCompetition=" + placementCompetition +
                ", competitionDate=" + resultDate;
    }

    public String toStringTraining() {
        return "ResultSwimmer: " +
                "swimID: " + memberID + '\'' +
                ", swimDiscipline: " + swimDiscipline + '\'' +
                ", swimTime=" + swimTime +
                ", competitionDate=" + resultDate;
    }

    public int getMemberID() {
        return memberID;
    }

    public SwimDiscipline getSwimDiscipline() {
        return swimDiscipline;
    }

    public void setSwimDiscipline(SwimDiscipline swimDiscipline) {
        this.swimDiscipline = swimDiscipline;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionLocation() {
        return competitionLocation;
    }

    public void setCompetitionLocation(String competitionLocation) {
        this.competitionLocation = competitionLocation;
    }

    public double getSwimTime() {
        return swimTime;
    }

    public void setSwimTime(double swimTime) {
        this.swimTime = swimTime;
    }

    public int getPlacementCompetition() {
        return placementCompetition;
    }

    public void setPlacementCompetition(int placementCompetition) {
        this.placementCompetition = placementCompetition;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }
}
