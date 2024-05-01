package domain_model;

import java.util.ArrayList;

public class Data {

    //ATTRIBUTES
    private ArrayList<Member> membersList;
    private ArrayList<ResultTraining> trainingResultList;
    private ArrayList<ResultCompetition> competitionResultList;

    //CONSTRUCTOR
    public Data() {
        membersList = new ArrayList<>();
        trainingResultList = new ArrayList<>();
        competitionResultList = new ArrayList<>();
    }

    //METHODS
    public void testGeneration() {
        Member m1 = new SwimmerCompetition("Daniel", "Jensen", null, true, null, null);
        membersList.add(m1);
        System.out.println("Debug: member added");

        System.out.println("Debug: for each loop");
        for(Member m : membersList) {
            if (m instanceof SwimmerCompetition) {
                System.out.println("Debug: Indenfor instanceof");
                System.out.println(m.getFirstName()+" "+m.getLastName());
                System.out.println(m.getBirthday());
                System.out.println(m.getIsMemberActive());
            }
        }


    }
}
