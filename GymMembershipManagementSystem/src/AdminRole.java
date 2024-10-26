import java.util.ArrayList;

public class AdminRole {
    private TrainerDatabase trainerDatabase;

    public AdminRole() {
        this.trainerDatabase = new TrainerDatabase("Trainers.txt");
    }

    public boolean addTrainer (String trainerId, String name, String email, String specialty, String phoneNumber){
        Trainer trainer;
        try {
            trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return trainerDatabase.insertRecord(trainer);
    }

    public ArrayList<Trainer> getListOfTrainers (){
        return trainerDatabase.returnAllRecords();
    }

    public boolean removeTrainer (String key){
        Trainer trainerToDelete = trainerDatabase.getRecord(key);
        return trainerDatabase.deleteRecord(trainerToDelete);
    }

    public void logout(){
        trainerDatabase.saveToFile();
    }
}
