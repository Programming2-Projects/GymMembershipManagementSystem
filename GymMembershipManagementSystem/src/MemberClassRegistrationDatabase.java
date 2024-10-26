import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberClassRegistrationDatabase {
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
        MembershipStatus status = MembershipStatus.valueOf(data[2]);
        LocalDate registrationDate = LocalDate.parse(data[3]);
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

    public void saveToFile () {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))) {
            String line;
            for (MemberClassRegistration registration:records) {
                line = registration.lineRepresentation();
                printWriter.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
