package domain_model;

import java.time.LocalDate;
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
    public void hardCodedData(){
        data.hardCodedData();
    }
    public double calculateTotalRateForecast(){
        return data.calculateTotalForecast();
    }
    public String findSwimmersResultTraining(Member m) {
        return data.findSwimmersResultTraining(m);
    }

    public void findIndexToBeChanged (int memberID) {
        data.findIndexToBeChanged(memberID);
    }

    public String findNameByIndex(){
        return data.findNameByIndex();
    }
    public void registerPayment() {
        data.registerPayment();
    }

    public int getIndexToBeChanged (){
        return data.getIndexToBeChanged();
    }

    //######################### Methods for Data class - Memberslist ################################
    public ArrayList<Member> getMembersList() {
        return data.getMembersList();
    }
    public void addToMembersList(Member member) {
        data.addToMembersList(member);
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

    public ArrayList<String> printOverduePayments(){
        return data.printOverduePayments();
    }
    public ArrayList<Member> searchMember(String name) {
        return data.searchMember(name);
    }

    public void addSwimResultTraining(boolean isCompetitive, int memberID, SwimDiscipline swimDiscipline, double swimTime, LocalDate resultDate) {
        data.addSwimResultTraining(isCompetitive,memberID, swimDiscipline, swimTime, resultDate);
    }

    public void addSwimResultCompetition(boolean isCompetitive, int memberID, String competitionLocation,String competitionName, LocalDate resultDate, SwimDiscipline swimDiscipline, double swimTime, int placementCompetition) {
        data.addSwimResultCompetition(isCompetitive,memberID, competitionLocation, competitionName, resultDate, swimDiscipline, swimTime, placementCompetition);
    }

    /*
    public void printResultListTraining() {
        data.printResultListTraining();
    }

     */

    public void printResultListCompetition() {
        data.printResultListCompetition();
    }

}
