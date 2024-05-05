package domain_model;

import java.util.ArrayList;

public class Controller {

    //ATTRIBUTES
    Data data;


    //CONSTRUCTOR
    public Controller() {
        data = new Data();
    }

    //METHODS
    //######################### Methods for Data class ################################

    //######################### Methods for Data class - Memberslist ################################
    public ArrayList<Member> getMembersList() {
        return data.getMembersList();
    }
    public void addToMembersList(Member member) {
        data.addToMembersList(member);
    }
    public void hardCodedData(){
        data.hardCodedData();
    }

    public double calculateTotalRateForecast(){
        return data.testFindSamletKontingentIndbetaling();
    }
    //######################### Methods for Data class - Resultlist ################################
    public ArrayList<ResultSwimmer> getResultList() {
        return data.getResultList();
    }
    public void addSwimResultToResultList(ResultSwimmer rs) {
        data.addSwimResultToResultList(rs);
    }

    //######################### Methods for Data class - SearchMatch ################################
    public ArrayList<Member> getSearchMatch() {
        return data.getSearchMatch();
    }
    public ArrayList<Member> searchMember(String name) {
        return data.searchMember(name);
    }

}
