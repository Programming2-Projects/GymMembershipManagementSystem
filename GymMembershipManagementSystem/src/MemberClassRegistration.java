import java.time.*;

public class MemberClassRegistration implements Recordable{
    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID) {
        if (!Validator.isValidID(memberID))
            throw new IllegalArgumentException("Invalid Member ID!");
        if (!Validator.isValidID(classID))
            throw new IllegalArgumentException("Invalid Class ID!");

        this.memberID = memberID;
        this.classID = classID;
        this.status = "Active";
        this.registrationDate = LocalDate.now();
    }

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
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

    @Override
    public String getSearchKey(){
        return memberID + classID;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    @Override
    public String lineRepresentation (){
        String line = String.join(",", memberID, classID, 
                        registrationDate.toString(), status);
        return line;
    }

    @Override
    public String toString() {
        return "MemberClassRegistration [memberID=" + memberID + ", classID=" + classID + ", status=" + status
                + ", registrationDate=" + registrationDate + "]";
    }

    
    
}
