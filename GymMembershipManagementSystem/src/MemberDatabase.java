import java.io.*;
import java.util.ArrayList;

public class MemberDatabase extends DataBases{
    private ArrayList<Member> records;
    private String fileName;

    public MemberDatabase (String fileName) {
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

    public Member createRecordFrom (String line) {
        if (line == null || line.isEmpty())
            return null;

        String[] data = line.split(",\\s*");
        if (data.length != 6)
            return null;

        String memberId = data[0];
        String name = data[1];
        String membershipType = data[2];
        String email = data[3];
        String phoneNumber = data[4];
        String status = data[5];
        return new Member(memberId, name, membershipType, email, phoneNumber, status);
    }

    public ArrayList<Member> returnAllRecords () {
        return records;
    }

    public boolean contains (String key) {
        for (Member record:records)
            if (record.getSearchKey().equals(key))
                return true;
        return false;
    }

    public Member getRecord (String key) {
        for (Member member:records)
            if (member.getSearchKey().equals(key))
                return member;
        return null;
    }

    public boolean insertRecord (Member record) {
        if (contains(record.getSearchKey()))
            return false;
        this.records.add(record);
        return true;
    }

    public boolean deleteRecord (Member record) {
        return this.records.remove(record); 
    }

    public boolean saveToFile () {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.fileName)))) {
            String line;
            for (Member member:records) {
                line = member.lineRepresentation();
                printWriter.println(line);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
