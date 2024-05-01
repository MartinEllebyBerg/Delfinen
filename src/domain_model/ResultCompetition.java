package domain_model;

import java.time.LocalDate;

public class ResultCompetition {

    //ATTRIBUTES
    private String swimDiscipline;
    private String competitionName;
    private double swimTime;
    private int placementCompetition;
    private LocalDate competitionDate;

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
