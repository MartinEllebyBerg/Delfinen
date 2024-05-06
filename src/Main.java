import domain_model.Data;
import ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Data d = new Data();
//        d.testGeneration();
//        d.testAddSwimResultCompetition();
//        d.testSearchCompSwimmersWithResultDataSaveInAnArray();
//        d.testPrintSavedArrayListWithCombinedData();
//
//        //ui.startProgramAll();
        ui.DelfinenUISetPosition();
//        //Data d = new Data();
//        //d.testGeneration();
        d.testAddSwimResultTraining();
    }
}
