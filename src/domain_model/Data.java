package domain_model;

import java.util.ArrayList;

public class Data {

    //ATTRIBUTES
    private ArrayList<Member> membersList;
    private ArrayList<ResultSwimmer> resultList;

    //CONSTRUCTOR
    public Data() {
        membersList = new ArrayList<>();
        resultList = new ArrayList<>();
    }

    //METHODS
    public void testGeneration() {
        Member m1 = new CompetitionMember("Mette", "Munch", null, true, SwimDiscipline.BUTTERFLY, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL);
        Member m2 = new CompetitionMember("Daniel", "Jensen", null, false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.NULL, SwimDiscipline.NULL);
        Member m3 = new ExerciseMember("Martin", "Elleby", null, true);
        Member m4 = new ExerciseMember("Mark", "Onat", null, false);
        Member m5 = new CompetitionMember("Hans", "Hansen", null, true, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);

        membersList.add(m1);
        membersList.add(m2);
        membersList.add(m3);
        membersList.add(m4);
        membersList.add(m5);

        System.out.println("Debug: member added");


        System.out.println("Debug: for each loop");
        for (Member m : membersList) {
            System.out.println("MemberID: " + m.getMemberID());
            System.out.println(m.getFirstName() + " " + m.getLastName());
            System.out.println("Day of Birth: " + m.getBirthday());
            System.out.println("Is member active: " + m.getIsMemberActive());

            if (m instanceof CompetitionMember) {
                System.out.println("Competition swimmer");
                if (!((CompetitionMember) m).getSwimDiscipline1().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim Discipline: " + ((CompetitionMember) m).getSwimDiscipline1());
                }
                if (!((CompetitionMember) m).getSwimDiscipline2().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim Discipline: " + ((CompetitionMember) m).getSwimDiscipline2());
                }
                if (!((CompetitionMember) m).getSwimDiscipline3().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim Discipline: " + ((CompetitionMember) m).getSwimDiscipline3());
                }
                if (!((CompetitionMember) m).getSwimDiscipline4().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim Discipline: " + ((CompetitionMember) m).getSwimDiscipline4());
                }
            }
            System.out.println(" ");
        }


    }
}
