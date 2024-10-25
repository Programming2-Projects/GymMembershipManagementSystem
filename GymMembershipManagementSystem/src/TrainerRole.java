import java.util.ArrayList;

public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private RegistrationDatabase registrationDatabase;

    public TrainerRole () {
        this.memberDatabase = new MemberDatabase("Members.txt");
        this.classDatabase = new ClassDatabase("Class.txt");
        this.registrationDatabase = new RegistrationDatabase("Registration.txt");
    }

    public boolean addMember (String memberID, String name, MembershipType membershipType,
    String email, String phoneNumber, MembershipStatus status) {
        Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        return memberDatabase.insertRecord(member);
    }

    public Member[] getListOfMembers () {
        return memberDatabase.returnAllRecords();
    }
    
    public boolean addClass (String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class class_ = new Class(classID, className, trainerID, duration, maxParticipants);
        return classDatabase.insertRecord(class_);
    }

    public ArrayList<Class> getListOfClasses () {
        return classDatabase.returnAllRecords();
    }



}
