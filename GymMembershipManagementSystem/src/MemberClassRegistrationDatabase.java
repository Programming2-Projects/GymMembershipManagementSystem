import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberClassRegistrationDatabase extends DataBases{
    private String fileName;
    private ArrayList<MemberClassRegistration> records;

    public MemberClassRegistrationDatabase (String fileName) {
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
            e.printStackTrace();
        }
    }

    public MemberClassRegistration createRecordFrom (String line) {
        if (line == null || line.isEmpty())
            return null;

        String[] data = line.split(",\\s*");
        if (data.length != 4)
            return null;

        String memberID = data[0];
        String classID = data[1];
        LocalDate registrationDate = LocalDate.parse(data[2]);
        String status = data[3];
        return new MemberClassRegistration(memberID, classID, status, registrationDate);
    }

    public ArrayList<MemberClassRegistration> returnAllRecords () {
        return records;
    }

    public boolean contains (String key) {
        for (MemberClassRegistration registration:records)
            if (registration.getSearchKey().equals(key))
                return true;
        return false;
    }

    public MemberClassRegistration getRecord (String key) {
        for (MemberClassRegistration registration:records)
            if (registration.getSearchKey().equals(key))
                return registration;
        return null;
    }

    public boolean insertRecord (MemberClassRegistration registration) {
        if (contains(registration.getSearchKey()))
            return false;
        this.records.add(registration);
        return true;
    }

    public boolean deleteRecord (MemberClassRegistration record) {
        return this.records.remove(record); 
    }

    public boolean saveToFile () {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))) {
            String line;
            for (MemberClassRegistration registration:records) {
                line = registration.lineRepresentation();
                printWriter.println(line);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
