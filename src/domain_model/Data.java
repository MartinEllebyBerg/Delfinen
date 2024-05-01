package domain_model;

import java.util.ArrayList;

public class Data {
    //hardcoded data
    private Member m1 = new CompetitionMember("Mette", "Munch", null, true, SwimDiscipline.BUTTERFLY, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL);
    private Member m2 = new CompetitionMember("Daniel", "Jensen", null, false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.NULL, SwimDiscipline.NULL);
    private Member m3 = new ExerciseMember("Martin", "Elleby", null, true);
    private Member m4 = new ExerciseMember("Mark", "Onat", null, false);
    private Member m5 = new CompetitionMember("Hans", "Hansen", null, true, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);

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
                System.out.println(" ");
            }
        }


    }

    public void testAddSwimResultCompetition() {
        System.out.println("Her kører addswimresultmetoden");
        ResultSwimmer result1 = new ResultSwimmer(2,"Holbæk", "Sjællandske Mesterskaber", null, SwimDiscipline.BUTTERFLY, 20.48, 5);
        ResultSwimmer result2 = new ResultSwimmer(2,"København", "DM", null, SwimDiscipline.BACKSTROKE, 22.85, 3);
        ResultSwimmer result3 = new ResultSwimmer(1,SwimDiscipline.FRONTCRAWL, 15.96, null);
        ResultSwimmer result4 = new ResultSwimmer(5,"Delfinen", "Klubmesterskaber", null, SwimDiscipline.BUTTERFLY, 20.58, 1);
        resultList.add(result1);
        resultList.add(result2);
        resultList.add(result3);
        resultList.add(result4);
        for (ResultSwimmer r : resultList){
            System.out.println("udprint af listen med toString");
            System.out.println(r.toString());
        }

    }

}
