package domain_model;

import java.time.LocalDate;

public class TrainingResult {

    //ATTRIBUTES
    private String swimDiscipline;
    private double swimTime;
    private LocalDate trainingDay;

    //CONSTRUCTOR

    //METHODS

    @Override
    public String toString() {
        return "TrainingResult" +
                "swimDiscipline='" + swimDiscipline + '\'' +
                ", swimTime: " + swimTime +
                ", trainingDay: " + trainingDay;
    }
}
