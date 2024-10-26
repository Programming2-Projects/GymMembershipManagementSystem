import java.time.*;

public class MemberClassRegistration {
    private String memberID;
    private String classID;
    private MembershipStatus status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID) {
        if (!Validator.isValidID(memberID))
            throw new IllegalArgumentException("Invalid Member ID!");
        if (!Validator.isValidID(classID))
            throw new IllegalArgumentException("Invalid Class ID!");

        this.memberID = memberID;
        this.classID = classID;
        this.status = MembershipStatus.ACTIVE;
        this.registrationDate = LocalDate.now();
    }

    public MemberClassRegistration(String memberID, String classID, MembershipStatus status, LocalDate registrationDate) {
        if (!Validator.isValidID(memberID))
            throw new IllegalArgumentException("Invalid Member ID!");
        if (!Validator.isValidID(classID))
            throw new IllegalArgumentException("Invalid Class ID!");

        this.memberID = memberID;
        this.classID = classID;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getSearchKey(){
        return memberID + classID;
    }

    public void setStatus (MembershipStatus status) {
        this.status = status;
    }

    public String lineRepresentation (){
        String line = String.join(",", memberID, classID, 
                        registrationDate.toString(),
                        String.valueOf(status));
        return line;
    }
    
}
