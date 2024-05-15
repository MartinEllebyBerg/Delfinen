package domain_model;

import data_source.Filehandler;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.FileHandler;

public class Data {

    //ATTRIBUTES

    private ArrayList<Member> membersList;
    private ArrayList<ResultSwimmer> resultList;
    private ArrayList<String[]> searchList;
    private ArrayList<Member> searchMatch;
    private int indexToBeChanged;


    //CONSTRUCTOR
    public Data() {
        membersList = new ArrayList<>();
        resultList = new ArrayList<>();
        searchList = new ArrayList<>();
        searchMatch = new ArrayList<>();

        //testAddSwimResultCompetition();
        //testAddSwimResultTraining();

    }


    //METHODS



    public ArrayList<Member> getSearchMatch() {
        return searchMatch;
    }

    public ArrayList<Member> searchMember(String name) {
        searchMatch.clear();
        for (Member member : membersList) {
            if (member.getFirstName().toLowerCase().contains(name.toLowerCase())) {
                searchMatch.add(member);
            }
        }
        return searchMatch;
    }

    //######################### Test methods & hardcode ################################

    /*public void hardCodedData() {
        Member m1 = new CompetitionMember("Mette", "Munch", LocalDate.of(1974, 2, 23), true, false,SwimDiscipline.BUTTERFLY, SwimDiscipline.NULL, SwimDiscipline.NULL, SwimDiscipline.NULL);
        Member m2 = new CompetitionMember("Daniel", "Jensen", LocalDate.of(1986, 4, 26), false, false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.NULL, SwimDiscipline.NULL);
        Member m3 = new ExerciseMember("Martin", "Elleby", LocalDate.of(1999, 8, 12), true, false);
        Member m4 = new ExerciseMember("Mark", "Onat", LocalDate.of(2001, 2, 8), false,false);
        Member m5 = new CompetitionMember("Hans", "Hansen", LocalDate.of(2005, 8, 26), true, false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m6 = new CompetitionMember("Peter", "Hansen", LocalDate.of(2012, 5, 15), true, false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m7 = new CompetitionMember("Signe", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m8 = new CompetitionMember("Ulrik", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m9 = new CompetitionMember("Lise", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m10 = new CompetitionMember("Christian", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m11 = new CompetitionMember("Malthe", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m12 = new CompetitionMember("Mette", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m13 = new CompetitionMember("Martin", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m14 = new CompetitionMember("Anders", "Hansen", LocalDate.of(2016, 3, 15), true,false, SwimDiscipline.FRONTCRAWL, SwimDiscipline.BACKSTROKE, SwimDiscipline.BUTTERFLY, SwimDiscipline.BREASTSTROKE);
        Member m15 = new ExerciseMember("Mette", "Olsen", LocalDate.of(1960, 3, 15), true,false);
        Member m16 = new ExerciseMember("Jakob", "Jakobsen", LocalDate.of(2016, 3, 15), false,false);


        membersList.add(m1);
        membersList.add(m2);
        membersList.add(m3);
        membersList.add(m4);
        membersList.add(m5);
        membersList.add(m6);
        membersList.add(m7);
        membersList.add(m8);
        membersList.add(m9);
        membersList.add(m10);
        membersList.add(m11);
        membersList.add(m12);
        membersList.add(m13);
        membersList.add(m14);
        membersList.add(m15);
        membersList.add(m16);
    }*/

    //TODO: Hvis denne testGeneration ikke anvendes så slet
    public void testGeneration() {

        System.out.println("Print full memberlist");

        System.out.println(" ");
        for (Member m : membersList) {
            System.out.println("MemberID: " + m.getMemberID() + ", " + m.getFirstName() + " " + m.getLastName());
            System.out.println("Day of birth: " + m.getBirthday());
            System.out.println("Is member active: " + m.getIsMemberActive());

            if (m instanceof CompetitionMember) {
                System.out.println("Competition swimmer");
                if (!((CompetitionMember) m).getSwimDiscipline1().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim discipline: " + ((CompetitionMember) m).getSwimDiscipline1());
                }
                if (!((CompetitionMember) m).getSwimDiscipline2().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim discipline: " + ((CompetitionMember) m).getSwimDiscipline2());
                }
                if (!((CompetitionMember) m).getSwimDiscipline3().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim discipline: " + ((CompetitionMember) m).getSwimDiscipline3());
                }
                if (!((CompetitionMember) m).getSwimDiscipline4().equals(SwimDiscipline.NULL)) {
                    System.out.println("Swim discipline: " + ((CompetitionMember) m).getSwimDiscipline4());
                }

            }
            System.out.println(" ");
        }
    }

    //######################### Methods for ArrayList memberslist ################################
    public ArrayList<Member> getMembersList() {
        Collections.sort(membersList); //Her bruger vi comparabel fra Member, som sørger for sortering på memberID
        return membersList;
    }

    public void addToMembersList(Member member) {
        membersList.add(member);
    }

    public int nextMemberID() {
        int result = 0;
        result = membersList.size()+ 1;
        return result;
    }

    //######################### Methods for ArrayList resultlist ################################
    public ArrayList<ResultSwimmer> getResultList() {
        return resultList;
    }

    public void addSwimResultToResultList(ResultSwimmer rs) {
        resultList.add(rs);
    }

    public double calculateTotalForecast() {
        double totalForecast = 0.0;
        for (Member m : membersList) {
            m.calculateYearOfMember();
            m.calculateMembershipRate();
            totalForecast += m.getRate();
        }
        return totalForecast;
    }
    public double calculateTotalForecastPlus5Youth() {
        double forecastYouth = 0.0;
        double forecastSenior = 0.0;
        double totalForecast = 0.0;
        for (Member m : membersList) {
            m.calculateYearOfMember();
            if (m.getYearsOfAge() < 18){
                forecastYouth += m.getRate()*1.05;
            } else {
                m.calculateMembershipRate();
                forecastSenior += m.getRate();
            }
            totalForecast = forecastYouth + forecastSenior;
        }
        return totalForecast;
    }
    public double calculateTotalForecastPlus5Senior() {
        double forecastYouth = 0.0;
        double forecastSenior = 0.0;
        double totalForecast = 0.0;
        for (Member m : membersList) {
            m.calculateYearOfMember();
            if (m.getYearsOfAge() > 18){
                forecastSenior += m.getRate()*1.05;
            } else {
                m.calculateMembershipRate();
                forecastYouth += m.getRate();
            }
            totalForecast = forecastYouth + forecastSenior;
        }
        return totalForecast;
    }

    public void findIndexToBeChanged(int memberID) {
        for (Member m : membersList) {
            if (m.getMemberID() == memberID) {
                indexToBeChanged = membersList.indexOf(m);
            }
        }
    }

    public String findNameByIndex() {
        String memberFirstName = null;
        String memberLastName = null;
        for (int i = 0; i < membersList.size(); i++) {
            if (i == indexToBeChanged) {
                memberFirstName = membersList.get(i).getFirstName();
                memberLastName = membersList.get(i).getLastName();
            }
        }
        return memberFirstName + " " + memberLastName;
    }
    public String showDataSpecificMember(int memberID){
        StringBuilder result = new StringBuilder();
        System.out.println("Her høres metoden printSpecificMember");
        System.out.println(" ");
        for(Member m : membersList){
            if(m.getMemberID() == memberID) {
                result.append("MemberNo. ").append(m.getMemberID())
                        .append("\nFirstname: ").append(m.getFirstName())
                        .append(", Lastname: ").append(m.getLastName())
                        .append(", Birthday: ").append(m.getBirthday());
                for (ResultSwimmer r : resultList) {
                    if (m.getMemberID() == r.getMemberID()) {
                        if(!r.getCompetitionName().equals("null")) {
                            result.append("\nCompetition: ").append(r.getCompetitionName());
                        } else {
                            result.append("\nTraining result");
                        }
                        result.append("\nSwimDiscipline: ").append(r.getSwimDiscipline())
                                .append(", time: ").append(r.getSwimTime())
                                .append(", date: ").append(r.getResultDate());

                    }
                }
            }
        }
        return result.toString();
    }

    public void registerPayment() {
        for (int i = 0; i < membersList.size(); i++) {
            if (i == indexToBeChanged) {
                membersList.get(i).setPaymentRegistered(true);
            }
        }
    }

    public ArrayList<String> printOverduePayments() {
        ArrayList<String> overduePayments = new ArrayList<>();
        for (Member member : membersList) {
            if(!member.isPaymentRegistered()) {
                overduePayments.add(member.toStringOverduePayments());
            }
        }
        return overduePayments;
    }

    public double sumOverduePayments () {
        double result = 0.0;
        for (Member member : membersList) {
            if(!member.isPaymentRegistered()) {
                result += member.getRate();
            }
        }
        return result;
    }

//TODO: Hvis denne testAddSwimResultCompetition ikke anvendes så slet
    //TODO: Hvis denne testAddSwimResultCompetition ikke anvendes så slet
    public void testAddSwimResultCompetition() {
        System.out.println("Her kører addswimresultmetoden");
        ResultSwimmer result1 = new ResultSwimmer(true, 2, "Holbæk", "Sjællandske Mesterskaber", null, SwimDiscipline.BUTTERFLY, 20.48, 5);
        ResultSwimmer result2 = new ResultSwimmer(true, 2, "København", "DM", null, SwimDiscipline.BACKSTROKE, 22.85, 3);
        ResultSwimmer result3 = new ResultSwimmer(true, 1, SwimDiscipline.FRONTCRAWL, 15.96, null);
        ResultSwimmer result4 = new ResultSwimmer(true, 5, "Delfinen", "Klubmesterskaber", null, SwimDiscipline.BUTTERFLY, 20.58, 1);
        resultList.add(result1);
        resultList.add(result2);
        resultList.add(result3);
        resultList.add(result4);
        for (ResultSwimmer r : resultList) {
            System.out.println("udprint af listen med toString");
            System.out.println(r.toString());
        }
    }

    //TODO: Hvis denne testPrintSpecificMember ikke anvendes så slet
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
    //TODO: Hvis denne testSearchCompSwimmerWithResultDataSaveInArray ikke anvendes så slet senere
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

    public String findSwimmersResultTraining(Member m) {
        int idToReference = m.getMemberID();
        int count = 1;
        String result = "";
        result += "Competition results: \n";
        for (ResultSwimmer rs : resultList) { //TODO: Ændre hvilken liste, der itereres over, når genereringsmetoden i UI udarbejdet af Mark og Martin er færdig. Der skal itereres over ResultListTraining og ResultListCompetition.
            if (idToReference == rs.getMemberID()) {
                if (rs.isCompetitive()) {
                    result += count + ". " + rs + "\n";
                    count++;
                }
            }
        }

        result += "\nTraining results: \n";
        for (ResultSwimmer rs : resultList) {
            if (idToReference == rs.getMemberID()) {
                if (!rs.isCompetitive()) {
                    result += count + ". " + rs.toStringTraining() + "\n";
                    count++;
                }
            }
        }
        return result;
    }

    public void testPrintSavedArrayListWithCombinedData() {
        System.out.println("List of swimmers with either their data from competition stored or training data:");
        for (String[] combinedData : searchList) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-5s", combinedData[0])); //String.format er lig med en form for tabulator
            sb.append(String.format("%-15s", combinedData[1]));
            sb.append(String.format("%-15s", combinedData[2]));
            sb.append(String.format("%-15s", combinedData[3]));
            sb.append(String.format("%-15s", combinedData[4]));
            sb.append(String.format("%-10s", combinedData[5]));
            sb.append(String.format("%-30s", combinedData[6]));
            sb.append(String.format("%-20s", combinedData[7]));
            sb.append(String.format("%-15s", combinedData[8]));
            //TODO: Ingen sysouts i andre klasser end UI
            System.out.println(sb.toString());
        }
    }

    public int getIndexToBeChanged() {
        return indexToBeChanged;
    }

    /*
    public void testAddSwimResultTraining() { //Udkommenteret, eftersom der blev fjernet 3 arraylister, der ikke skulle bruges.
        //TODO: Ingen sysouts i andre klasser end UI
        System.out.println("test af udprint af addSwimResultTraining metode");
        ResultSwimmer r1 = new ResultSwimmer(false, 30, SwimDiscipline.FRONTCRAWL, 20.35, LocalDate.of(2024, 9, 13));
        for (ResultSwimmer r : resultListTraining) {

        }
        //TODO: Ingen sysouts i andre klasser end UI
        resultList.add(r1);
        for (ResultSwimmer r : resultList) {
            System.out.println(r.toStringTraining());
        }
    }

     */

    //######################### SwimResult objects ################################
    public void addSwimResultTraining(boolean isCompetitive, int memberID, SwimDiscipline swimDiscipline, double swimTime, LocalDate resultDate) {
        resultList.add(new ResultSwimmer(isCompetitive, memberID, swimDiscipline, swimTime, resultDate));
    }

    public void addSwimResultCompetition(boolean isCompetitive, int memberID, String competitionLocation, String competitionName, LocalDate resultDate, SwimDiscipline swimDiscipline, double swimTime, int placementCompetition) {
        resultList.add(new ResultSwimmer(isCompetitive, memberID, competitionLocation, competitionName, resultDate, swimDiscipline, swimTime, placementCompetition));
    }

    /* //Udkommenteret, eftersom der blev fjernet 3 arraylister, der ikke skulle bruges.
    public void printResultListTraining() {
        //TODO: Ingen sysouts i andre klasser end UI
        for (ResultSwimmer r : resultListTraining) {
            System.out.println(r);
        }
        for (ResultSwimmer r : resultList) {
            System.out.println(r.toStringTraining());
        }
    }

     */

    public void printResultListCompetition() {
        for (ResultSwimmer r : resultList) {
            System.out.println(r.toString());
        }
    }
}
