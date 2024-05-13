package domain_model;

import java.time.LocalDate;

public class ExerciseMember extends Member {


    //ATTRIBUTES



    //CONSTRUCTOR
    public ExerciseMember(String firstName, String lastName, LocalDate birthday, boolean memberActive, boolean paymentRegistered,SwimDiscipline swimDiscipline1, SwimDiscipline swimDiscipline2, SwimDiscipline swimDiscipline3, SwimDiscipline swimDiscipline4) {
        super(firstName, lastName, birthday, memberActive, paymentRegistered);


    }
        //METHODS


}