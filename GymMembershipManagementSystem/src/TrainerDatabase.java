import java.io.*;
import java.util.ArrayList;

public class TrainerDatabase extends DataBases<Trainer>{
    private ArrayList<Trainer> records;
    private String fileName;

    public TrainerDatabase (String fileName) {
        this.fileName = fileName;
        this.records = new ArrayList<>();
        readFromFile();
    }

    @Override
    public void readFromFile () {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                this.records.add(createRecordFrom(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public ArrayList<Trainer> returnAllRecords () {
        return records;
    }

    @Override
    public boolean contains (String key) {
        for (Trainer record:records)
            if (record.getSearchKey().equals(key))
                return true;
        return false;
    }

    @Override
    public Trainer getRecord (String key) {
        for (Trainer trainer:records)
            if (trainer.getSearchKey().equals(key))
                return trainer;
        return null;
    }

    @Override
    public boolean insertRecord (Trainer record) {
        if (contains(record.getSearchKey()))
            return false;
        this.records.add(record);
        return true;
    }

    @Override
    public boolean deleteRecord (Trainer record) {
        return this.records.remove(record); 
    }

    @Override
    public boolean saveToFile () {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))) {
            String line;
            for (Trainer trainer:records) {
                line = trainer.lineRepresentation();
                printWriter.println(line);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
