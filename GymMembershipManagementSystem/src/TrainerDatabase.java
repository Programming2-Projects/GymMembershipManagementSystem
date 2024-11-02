public class TrainerDatabase extends DataBase<Trainer>{
    
    public TrainerDatabase (String fileName) {
        super(fileName);
    }

    @Override
    public Trainer createRecordFrom (String line) {
        if (line == null || line.isEmpty())
            return null;

        String[] data = line.split(",\\s*");
        if (data.length != 5)
            return null;

        String trainerId = data[0];
        String name = data[1];
        String email = data[2];
        String  speciality = data[3];
        String phoneNumber = data[4];
        return new Trainer(trainerId, name, email, speciality, phoneNumber);
    }
    
}
