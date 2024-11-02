public class MemberDatabase extends DataBase<Member> {

    public MemberDatabase (String fileName) {
        super(fileName);
    }

    @Override
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
    
}
