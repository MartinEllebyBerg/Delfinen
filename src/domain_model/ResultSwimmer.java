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
    public boolean isCompetitive() {
        return isCompetitive;
    }

    //######################### Setter methods  ################################
    // Vi bruger ikke setterne pt., men lader dem stå for skalérbarheden :-)
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
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
    public void setCompetitive(boolean competitive) {
        isCompetitive = competitive;
    }


    //######################### toString methods  ################################
    @Override
    public String toString() {
        return "MemberID: " + memberID+
                " | SwimDiscipline: " + swimDiscipline +
                " | SwimTime: " + swimTime +
                " | CompetitionName: " + competitionName +
                " | CompetitionLocation: " + competitionLocation +
                " | PlacementCompetition: " + placementCompetition +
                " | CompetitionDate: " + resultDate;
    }
    public String toStringSwimIDMemberId(Member m) {
        return "MemberID: " + memberID +" ("+m.getFirstName()+" "+m.getLastName()+")"+
                " | SwimDiscipline: " + swimDiscipline +
                " | SwimTime: " + swimTime +
                " | CompetitionName: " + competitionName +
                " | CompetitionLocation: " + competitionLocation +
                " | PlacementCompetition: " + placementCompetition +
                " | CompetitionDate: " + resultDate;
    }
    public String toStringTraining() {
        return "SwimID: " + memberID +
                " | SwimDiscipline: " + swimDiscipline +
                " | SwimTime: " + swimTime +
                " | TrainingDate: " + resultDate + "\n";
    }
    public String toStringSortSwimTime(Member m) {
        String result =
                "SwimTime: "+swimTime+
                        "\tMemberID: "+memberID+
                        "\tMember name: "+"("+m.getFirstName()+" "+m.getLastName()+")"+
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

    //######################### Helper Methods  ################################
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
}