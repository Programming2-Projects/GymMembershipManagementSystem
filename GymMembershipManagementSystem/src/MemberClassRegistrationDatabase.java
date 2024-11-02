import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends DataBase<MemberClassRegistration>{

    public MemberClassRegistrationDatabase (String fileName) {
        super(fileName);
    }

    @Override
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

}
