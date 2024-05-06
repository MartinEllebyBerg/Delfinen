package domain_model;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.util.*;

public class Data {
    //hardcoded data
    private Member m1 = new CompetitionMember("Mette", "Munch", LocalDate.of(1974,2,23), true, SwimDiscipline.BUTTERFLY, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL);
    private Member m2 = new CompetitionMember("Daniel", "Jensen", null, false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.NULL, SwimDiscipline.NULL);
    private Member m3 = new ExerciseMember("Martin", "Elleby", null, true);
    private Member m4 = new ExerciseMember("Mark", "Onat", null, false);
    private Member m5 = new CompetitionMember("Hans", "Hansen", null, true, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);

    //hardcoded test af Registrere træningsobjekt


    //ATTRIBUTES

    private ArrayList<Member> membersList;
    private ArrayList<ResultSwimmer> resultList;
    private ArrayList<String[]> searchList;
    private ArrayList<Member> searchMatch;
    private ArrayList<ResultSwimmer> resultListTraining;
    private ArrayList<ResultSwimmer> resultListCompetition;

    //CONSTRUCTOR
    public Data() {
        membersList = new ArrayList<>();
        resultList = new ArrayList<>();
        searchList = new ArrayList<>();
        searchMatch = new ArrayList<>();
        resultListTraining = new ArrayList<>();
        resultListCompetition = new ArrayList<>();
    }


    //METHODS


    public ArrayList<Member> getSearchMatch() {
        return searchMatch;
    }

    public ArrayList<Member> searchMember(String name) {
        searchMatch.clear();
        for(Member member : membersList) {
            if(member.getFirstName().toLowerCase().contains(name.toLowerCase())) {
                searchMatch.add(member);
            }
        }
        return searchMatch;
    }

    //######################### Test methods & hardcode ################################
    public void testGeneration() {

        membersList.add(m1);
        membersList.add(m2);
        membersList.add(m3);
        membersList.add(m4);
        membersList.add(m5);

        System.out.println("Print full memberlist");

        System.out.println(" ");
        for (Member m : membersList) {
            System.out.println("MemberID: " + m.getMemberID() + ", " +m.getFirstName() + " " + m.getLastName());
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

    /*public void testPrintSpecificMember(){
        System.out.println("Her høres metoden printSpecificMember");
        System.out.println(" ");
        for(Member m : membersList){
            for(ResultSwimmer r : resultList){
                if(m.getMemberID() == r.getMemberID()) {
                    System.out.println("MemberNo. " + m.getMemberID() + ", Firstname: " + m.getFirstName() + ", Lastname: " + m.getLastName() +
                            "\nCompetition: " + r.getCompetitionName() + ", Location: " +r.getCompetitionLocation() +
                            "\nSwimDiscipline: " + r.getSwimDiscipline() + ", time: " +r.getSwimTime());
                }
            }
        }
    }*/
    public void testSearchCompSwimmersWithResultDataSaveInAnArray() {
        System.out.println("Her køres metoden hvor de to lister kombineres, hvis der er identisk memberID, og det gemmes i ny Array");
        System.out.println(" ");
        for (Member m : membersList) {
            for (ResultSwimmer r : resultList) {
                if (m.getMemberID() == r.getMemberID()) {
                    String[] combinedData = { //I denne nye arrayList har jeg lavet alt om til String..
                            String.valueOf(m.getMemberID()), //combinedData[0]
                            m.getFirstName(), //combinedData[1]
                            m.getLastName(), //combinedData[2]
                            String.valueOf(r.getResultDate()), //combinedData[3]
                            String.valueOf(r.getSwimDiscipline()), //combinedData[4]
                            String.valueOf(r.getSwimTime()), //combinedData[5]
                            r.getCompetitionName(), //combinedData[6]
                            r.getCompetitionLocation(), //combinedData[7]
                            String.valueOf(r.getPlacementCompetition()) //combinedData[8]
                    };
                    searchList.add(combinedData);

                }
            }
        }
    }
    public void testPrintSavedArrayListWithCombinedData(){
        System.out.println("List of swimmers with either their data from competition stored or training data:");
        for (String[] combinedData : searchList){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-5s",combinedData[0])); //String.format er lig med en form for tabulator
            sb.append(String.format("%-15s",combinedData[1]));
            sb.append(String.format("%-15s",combinedData[2]));
            sb.append(String.format("%-15s",combinedData[3]));
            sb.append(String.format("%-15s",combinedData[4]));
            sb.append(String.format("%-10s",combinedData[5]));
            sb.append(String.format("%-30s",combinedData[6]));
            sb.append(String.format("%-20s",combinedData[7]));
            sb.append(String.format("%-15s",combinedData[8]));
            System.out.println(sb.toString());

        }

    }

    public void testAddSwimResultTraining() {
        System.out.println("test af udprint af addSwimResultTraining metode");
        ResultSwimmer r1 = new ResultSwimmer(30, SwimDiscipline.FRONTCRAWL, 20.35, LocalDate.of(2024, 9, 13));
        resultListTraining.add(r1);
        for (ResultSwimmer r : resultListTraining) {
            System.out.println(r.toStringTraining());
        }
    }

    public void addSwimResultTraining(int memberID, SwimDiscipline swimDiscipline, double swimTime, LocalDate resultDate) {
        resultListTraining.add(new ResultSwimmer(memberID, swimDiscipline, swimTime, resultDate));
    }

    public void addSwimResultCompetition(int memberID, String competitionLocation, String competitionName, LocalDate resultDate, SwimDiscipline swimDiscipline, double swimTime, int placementCompetition) {
        resultListCompetition.add(new ResultSwimmer(memberID, competitionLocation, competitionName, resultDate, swimDiscipline, swimTime, placementCompetition));
    }


}
