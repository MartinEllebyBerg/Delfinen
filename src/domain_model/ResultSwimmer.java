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
    private boolean isCompetitive;

    //CONSTRUCTOR
    public ResultSwimmer(boolean isCompetitive, int memberID, String competitionLocation,String competitionName, LocalDate resultDate, SwimDiscipline swimDiscipline, double swimTime, int placementCompetition){
        this.isCompetitive = isCompetitive;
        this.memberID = memberID;
        this.competitionLocation = competitionLocation;
        this.competitionName = competitionName;
        this.resultDate = resultDate;
        this.swimDiscipline = swimDiscipline;
        this.swimTime = swimTime;
        this.placementCompetition = placementCompetition;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    public void setCompetitive(boolean competitive) {
        isCompetitive = competitive;
    }

    public ResultSwimmer(boolean isCompetitive, int memberID, SwimDiscipline swimDiscipline, double swimTime, LocalDate resultDate){
        this.isCompetitive = isCompetitive;
        this.memberID = memberID;
        this.swimDiscipline = swimDiscipline;
        this.swimTime = swimTime;
        this.resultDate = resultDate;
    }

    //METHODS
    //######################### Getter methods  ################################
    public int getMemberID() {
        return memberID;
    }

    public SwimDiscipline getSwimDiscipline() {
        return swimDiscipline;
    }
    public String getCompetitionName() {
        return competitionName;
    }
    public String getCompetitionLocation() {
        return competitionLocation;
    }
    public double getSwimTime() {
        return swimTime;
    }
    public int getPlacementCompetition() {
        return placementCompetition;
    }
    public LocalDate getResultDate() {
        return resultDate;
    }


    //######################### Setter methods  ################################
    public void setSwimDiscipline(SwimDiscipline swimDiscipline) {
        this.swimDiscipline = swimDiscipline;
    }
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
    public void setCompetitionLocation(String competitionLocation) {
        this.competitionLocation = competitionLocation;
    }
    public void setSwimTime(double swimTime) {
        this.swimTime = swimTime;
    }
    public void setPlacementCompetition(int placementCompetition) {
        this.placementCompetition = placementCompetition;
    }
    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }


    //######################### toString methods  ################################
    @Override
    public String toString() {
        //TODO: Gøre begge toString metoder lidt pænere. Eventuelt en ifblok, der tjekker på den nye boolean isCompetitive og derefter retter til
        return "ResultSwimmer: " +
                "\nSwimID: " + memberID +
                "\nSwimDiscipline: " + swimDiscipline +
                "\nCompetitionName: " + competitionName +
                "\nCompetitionLocation: " + competitionLocation +
                "\nSwimTime: " + swimTime +
                "\nPlacementCompetition: " + placementCompetition +
                "\nCompetitionDate: " + resultDate;
    }

    public String toStringTraining() {
        return "ResultSwimmer: " +
                "\nSwimID: " + memberID +
                "\nSwimDiscipline: " + swimDiscipline +
                "\nSwimTime: " + swimTime +//
                "\nCompetitionDate: " + resultDate;
    }
    public String placementSTNDRD(int placementCompetition) {
        String result ="";
        if (placementCompetition == 1) {
            result = placementCompetition+"st";
        } else if (placementCompetition == 2) {
            result = placementCompetition+"nd";
        } else if (placementCompetition == 3){
            result = placementCompetition+"rd";
        } else {
            result = placementCompetition+"th";
        }
        return result;
    }
    public String toStringSortSwimTime() {
        String result =
                "SwimTime: "+swimTime+
                "\tMemberID: "+memberID+
                "\tDate performed: "+resultDate;
        if (isCompetitive) {
            result +=
                    "\tCompetition: "+competitionName+
                            "\tCompetition Location: "+competitionLocation+
                            "\tRanked at Competition: "+placementSTNDRD(placementCompetition)+" place\n";
        } else {
            result += "\n";
        }
        return result;
    }
}
