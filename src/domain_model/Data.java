package domain_model;

import java.time.LocalDate;
import java.util.*;

public class Data {

    //ATTRIBUTES

    private ArrayList<Member> membersList;
    private ArrayList<ResultSwimmer> resultList;
    private ArrayList<String[]> searchList;
    private ArrayList<Member> searchMatch;
    private ArrayList<ResultSwimmer> listToBeSorted;
    private ArrayList<Member> juniorList;
    private ArrayList<Member> seniorList;
    private ArrayList<ResultSwimmer> searchListResult;
    private int indexToBeChanged;


    //CONSTRUCTOR
    public Data() {
        membersList = new ArrayList<>();
        resultList = new ArrayList<>();
        searchList = new ArrayList<>();
        searchMatch = new ArrayList<>();
        listToBeSorted = new ArrayList<>();
        juniorList = new ArrayList<>();
        seniorList = new ArrayList<>();
        searchListResult = new ArrayList<>();
    }


    //METHODS
    //######################### Find & Search Methods ################################
    public Member findMemberById(int idToFind) {
        for (Member member : getMembersList()) {
            if (member.getMemberID() == idToFind) {
                if (member instanceof CompetitionMember) {
                    return member;
                }
                if (member instanceof ExerciseMember) {
                    return member;
                }
            }
        }
        return null;
    }
    public CompetitionMember findCompetitionMemberById(int idToFind) {
        for (Member member : getMembersList()) {
            if (member.getMemberID() == idToFind && member instanceof CompetitionMember) {
                return (CompetitionMember) member;
            }
        }
        return null;
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
    public String findSwimmersResultTraining(Member m) {
        int idToReference = m.getMemberID();
        int count = 1;
        String result = "";
        result += "Competition results: \n";
        for (ResultSwimmer rs : resultList) {
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

    //######################### Sorting ################################
    public String returnSortJuniorSeniorSwimTime(int totalCount, int maxAmountOfResultsToPrint, int seniorAge, ArrayList<ResultSwimmer> arr, SwimDiscipline disciplineEnum) {
        int count = totalCount;
        String result = "\n|" + disciplineEnum + "|\n";

        result += "\n\t|" + disciplineEnum + " - Senior |\n";
        for (ResultSwimmer rs : arr) {
            if (rs.getSwimDiscipline().equals(disciplineEnum)) {
                Member m = findMemberById(rs.getMemberID());
                int memberAge = m.getYearsOfAge();
                if (memberAge >= seniorAge) {
                    result += count + ". " + rs.toStringSortSwimTime(m);
                    if (count == maxAmountOfResultsToPrint) {
                        break;
                    }
                    count++;
                }
            }
        }
        result += "\n\t|" + disciplineEnum + " - Junior |\n";
        count = totalCount;
        for (ResultSwimmer rs : arr) {
            if (rs.getSwimDiscipline().equals(disciplineEnum)) {
                Member m = findMemberById(rs.getMemberID());
                int memberAge = m.getYearsOfAge();
                if (memberAge < seniorAge) {
                    result += count + ". " + rs.toStringSortSwimTime(m);
                    if (count == maxAmountOfResultsToPrint) {
                        break;
                    }
                    count++;
                }
            }
        }
        return result;
    }
    public void copyResultListToListToBeSorted() {
        for (ResultSwimmer rs : resultList) {
            listToBeSorted.add(rs);
        }
    }
    public ArrayList<ResultSwimmer> getListToBeSorted() {
        return listToBeSorted;
    }
    public ArrayList<Member> getSearchMatch() {
        return searchMatch;
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
        result = membersList.size() + 1;
        return result;
    }
    //######################### Methods for ArrayList resultlist ################################
    public ArrayList<ResultSwimmer> getResultList() {
        return resultList;
    }
    public void addSwimResultToResultList(ResultSwimmer rs) {
        resultList.add(rs);
    }

    //######################### Calculation & Forecasting ################################
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
            if (m.getYearsOfAge() < 18) {
                forecastYouth += m.getRate() * 1.05;
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
            if (m.getYearsOfAge() > 18) {
                forecastSenior += m.getRate() * 1.05;
            } else {
                m.calculateMembershipRate();
                forecastYouth += m.getRate();
            }
            totalForecast = forecastYouth + forecastSenior;
        }
        return totalForecast;
    }

    public String showDataSpecificMember(int memberID) {
        StringBuilder result = new StringBuilder();
        for (Member m : membersList) {
            if (m.getMemberID() == memberID) {
                result.append("MemberNo. ").append(m.getMemberID())
                        .append("\nFirstname: ").append(m.getFirstName())
                        .append(", Lastname: ").append(m.getLastName())
                        .append(", Birthday: ").append(m.getBirthday());
                for (ResultSwimmer r : resultList) {
                    if (m.getMemberID() == r.getMemberID()) {
                        if (!r.getCompetitionName().equals("null")) {
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
    //######################### Member Payment ################################
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
            if (!member.isPaymentRegistered()) {
                overduePayments.add(member.toStringOverduePayments());
            }
        }
        return overduePayments;
    }
    public double sumOverduePayments() {
        double result = 0.0;
        for (Member member : membersList) {
            if (!member.isPaymentRegistered()) {
                result += member.getRate();
            }
        }
        return result;
    }
    public void combineMemberAndResult(int memberID) {
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
    public String testPrintSavedArrayListWithCombinedData() { //TODO: Skal denne metode fjernes?
        String result = "";
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
            result = sb.toString();
            //TODO: Ingen sysouts i andre klasser end UI

        } return result;
    }

    //######################### Getters ################################
    public int getIndexToBeChanged() {
        return indexToBeChanged;
    }
    public ArrayList<Member> getJuniorList() {
        return juniorList;
    }

    public ArrayList<Member> getSeniorList() {
        return seniorList;
    }

    public ArrayList<ResultSwimmer> getSearchListResult() {
        return searchListResult;
    }

    public ArrayList<String[]> getSearchListString() {
        return searchList;
    }

    //######################### Adding SwimResult objects ################################
    public void addSwimResultTraining(boolean isCompetitive, int memberID, SwimDiscipline swimDiscipline, double swimTime, LocalDate resultDate) {
        resultList.add(new ResultSwimmer(isCompetitive, memberID, swimDiscipline, swimTime, resultDate));
    }

    public void addSwimResultCompetition(boolean isCompetitive, int memberID, String competitionLocation, String competitionName, LocalDate resultDate, SwimDiscipline swimDiscipline, double swimTime, int placementCompetition) {
        resultList.add(new ResultSwimmer(isCompetitive, memberID, competitionLocation, competitionName, resultDate, swimDiscipline, swimTime, placementCompetition));
    }

    //######################### Copying from ResultList to searchList ################################
    //TODO: Mangler at kunne kun printe Competetitionresultater
    public void showResultListCompetition() {
        searchListResult.clear();
        for (ResultSwimmer r : resultList) {
            if (r.isCompetitive() == true) {
                searchListResult.add(r);
            }
        }
    }
    public void showResultListTraining() {
        searchListResult.clear();
        for (ResultSwimmer r : resultList) {
            if (r.isCompetitive() == false) {
                searchListResult.add(r);
            }
        }
    }

    //TODO: Metode til at printe resultatlister fra træning

    //######################### Sorting methods ################################
    public String sortBySwimTime() {
        int totalCount = 1;
        int maxAmountOfResultsToPrint = 5;
        int seniorAge = 18;
        String result = "";
        if (!listToBeSorted.isEmpty()) {
            result = "Sorted by swim time: \n";
            listToBeSorted.sort(new disciplineComparator().thenComparing(new swimTimeComparator()));

            result += returnSortJuniorSeniorSwimTime(totalCount, maxAmountOfResultsToPrint, seniorAge, listToBeSorted, SwimDiscipline.BREASTSTROKE);

            result += returnSortJuniorSeniorSwimTime(totalCount, maxAmountOfResultsToPrint, seniorAge, listToBeSorted, SwimDiscipline.BACKSTROKE);

            result += returnSortJuniorSeniorSwimTime(totalCount, maxAmountOfResultsToPrint, seniorAge, listToBeSorted, SwimDiscipline.FRONTCRAWL);

            result += returnSortJuniorSeniorSwimTime(totalCount, maxAmountOfResultsToPrint, seniorAge, listToBeSorted, SwimDiscipline.BUTTERFLY);


            System.out.println("DEBUG: Vi er i if blok og listToBeSorted er IKKE tom, linje 395.");
        } else {
            result = "There was an error sorting the list. (Error: Data.L454)";
        }
        return result;
    }

    //######################### Copy Members from membersList to junior/senior list ################################
    public void printCompetitionJunior() {
        juniorList.clear();
        for (Member m : membersList) {
            if (m instanceof CompetitionMember) {
                if (m.getYearsOfAge() < 18) {
                    juniorList.add(m);
                }
            }
        }
    }
    public void printCompetitionSenior() {
        seniorList.clear();
        for (Member m : membersList) {
            if (m instanceof CompetitionMember) {
                if (m.getYearsOfAge() >= 18) {
                    seniorList.add(m);
                }
            }
        }
    }
}
