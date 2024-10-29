import java.io.*;
import java.util.ArrayList;

public class ClassDatabase extends DataBases<Class>{
    private String fileName;
    private ArrayList<Class> records;

    public ClassDatabase (String fileName) {
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
            e.getStackTrace();
        }
    }
    
    @Override
    public Class createRecordFrom (String line) {
        if (line == null || line.isEmpty())
            return null;

        String[] data = line.split(",\\s*");
        if (data.length != 5)
            return null;

        String classID = data[0];
        String className = data[1];
        String trainerID = data[2];
        int duration = Integer.parseInt(data[3]);
        int availableSeats = Integer.parseInt(data[4]);
        return new Class(classID, className, trainerID, duration, availableSeats);
    }

    @Override
    public ArrayList<Class> returnAllRecords () {
        return records;
    }

    @Override
    public boolean contains (String key) {
        for (Class record:records)
            if (record.getSearchKey().equals(key))
                return true;
        return false;
    }

    @Override
    public Class getRecord (String key) {
        for (Class record:records)
            if (record.getSearchKey().equals(key))
                return record;
        return null;
    }

    @Override
    public boolean insertRecord (Class record) {
        if (contains(record.getSearchKey()))
            return false;
        this.records.add(record);
        return true;
    }

    @Override
    public boolean deleteRecord (Class record) {
        return this.records.remove(record); 
    }

    @Override
    public boolean saveToFile () {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))) {
            String line;
            for (Class record:records) {
                line = record.lineRepresentation();
                printWriter.println(line);
            }
            return true;
        } catch (IOException e) {
            e.getStackTrace();
        }
        return false;
    }

}
