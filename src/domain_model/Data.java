package domain_model;

import java.util.ArrayList;

public class Data {

    //ATTRIBUTES
private ArrayList<Member> membersList;
private ArrayList<TrainingResult> trainingResultList;
private ArrayList<CompResult> competitionResultList;
    
    //CONSTRUCTOR
public Data () {
    membersList = new ArrayList<>();
    trainingResultList = new ArrayList<>();
    competitionResultList = new ArrayList<>();            
}
    
    //METHODS
    public void testGeneration() {
        
    }
}
