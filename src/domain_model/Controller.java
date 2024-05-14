package domain_model;

import data_source.Filehandler;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    //ATTRIBUTES
    Data data;
    private Filehandler fh = new Filehandler();


    //CONSTRUCTOR
    public Controller() {
        data = new Data();
    }


    //METHODS
    //######################### Methods for Data class ################################
    public void saveCompMemberList(ArrayList<Member> arr) {
        fh.saveListOfAllMembers(arr);
    }
    public ArrayList<Member> loadSavedCompMemberList(ArrayList<Member> arr) {
        return fh.loadSavedAllMembersList(arr);
    }

    /*
    public void saveExerciseMemberList(ArrayList<Member> arr) {
        fh.saveListOfMembersExercise(arr);
    }
    public ArrayList<Member> loadSavedExerciseMemberList(ArrayList<Member> arr) {
        return fh.loadSavedExerciseMemberList(arr);
    }

     */
    public void saveCompetitionResult(ArrayList<ResultSwimmer> arr) {
        fh.saveCompetitionResults(arr);
    }

    public ArrayList<ResultSwimmer> loadSavedMemberResults(ArrayList<ResultSwimmer> arr) {
        return fh.loadSavedMemberResults(arr);
    }

    /*
    public void saveTrainingResult(ArrayList<ResultSwimmer> arr) {
        fh.saveTrainingResults(arr);
    }

     */
    /*public ArrayList<ResultSwimmer> loadSavedTrainingResult(ArrayList<ResultSwimmer> arr) {
        return fh.loadSavedTrainingResult(arr);
    }*/


    public int nextMemberID() {
        return data.nextMemberID();
    }

    /*public void hardCodedData(){
        data.hardCodedData();
    }*/
    public double calculateTotalRateForecast(){
        return data.calculateTotalForecast();
    }

    public double calculateTotalRateForecastPlus5Youth () {
        return data.calculateTotalForecastPlus5Youth();
    }

    public double calculateTotalRateForecastPlus5Senior () {
        return data.calculateTotalForecastPlus5Senior();
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

    public double sumOverduePayments () {
        return data.sumOverduePayments();
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
