import java.util.ArrayList;

public abstract class DataBases<T> {
    abstract void readFromFile ();
    abstract T createRecordFrom (String line);
    abstract boolean contains (String key);
    abstract ArrayList<T> returnAllRecords ();
    abstract T getRecord (String key);
    abstract boolean insertRecord (T record);
    abstract boolean deleteRecord (T record);
    abstract boolean saveToFile ();
}
