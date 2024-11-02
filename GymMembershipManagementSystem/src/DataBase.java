import java.util.ArrayList;
import java.io.*;

public abstract class DataBase<T extends Recordable> {
    protected String fileName;
    protected ArrayList<T> records;
    abstract T createRecordFrom (String line);

    public DataBase (String fileName) {
        this.fileName = fileName;
        this.records = new ArrayList<>();
        readFromFile();
    }

    public void readFromFile () {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                this.records.add(createRecordFrom(line));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public ArrayList<T> returnAllRecords () {
        return records;
    }

    public boolean contains (String key) {
        for (T record : records)
            if (record.getSearchKey().equals(key))
                return true;
        return false;
    }

    public T getRecord (String key) {
        for (T record : records)
            if (record.getSearchKey().equals(key))
                return record;
        return null;
    }

    public boolean insertRecord (T record) {
        if (contains(record.getSearchKey()))
            return false;
        this.records.add(record);
        return true;
    }

    public boolean deleteRecord (T record) {
        return this.records.remove(record); 
    }

    public boolean saveToFile () {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))) {
            String line;
            for (T record : records) {
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
