package domain_model;

import java.time.LocalDate;

public class ResultSwimmer {

    //ATTRIBUTES
    private String swimDiscipline;
    private String competitionName;
    private String competitionLocation;
    private double swimTime;
    private int placementCompetition;
    private LocalDate resultDate;

    //CONSTRUCTOR

    //METHODS

    @Override
    public String toString() {
        return "CompResult" +
                "swimDiscipline: " + swimDiscipline + '\'' +
                ", competitionName: " + competitionName + '\'' +
                ", swimTime: " + swimTime +
                ", placementCompetition: " + placementCompetition +
                ", competitionDate: " + competitionDate;
    }
}
