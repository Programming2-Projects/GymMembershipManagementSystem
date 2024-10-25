public class AdminRole {
private TrainerDatabase database;

public AdminRole() {
    database = new TrainerDatabase("Trainers.txt");
}

public void addTrainer (String trainerId, String name, String email, String specialty, String phoneNumber){
    Trainer newTrainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
    if(!database.insertRecord(newTrainer)){
        System.out.println("Trainer ID already in use.");
    }   
}

public Trainer[] getListOfTrainers (){
    return database.returnAllRecords();
}

public void removeTrainer (String key){
    Trainer trainerToDelete = database.getRecord(key);
    database.deleteRecord(trainerToDelete);
}

public void logout(){
    database.saveToFile();
}
}
