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
        Member m1 = new SwimmerCompetition("Daniel", "Jensen", null, true);
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
    //######################### Methods for ArrayList memberslist ################################
    public ArrayList<Member> getMembersList() {
        return membersList;
    }
    public void addToMembersList(Member member) {
        membersList.add(member);
    }
    //######################### Methods for ArrayList resultlist ################################
    public ArrayList<ResultSwimmer> getResultList() {
        return resultList;
    }
    public void addSwimResultToResultList(ResultSwimmer rs) {
        resultList.add(rs);
    }
}
