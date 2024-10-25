import java.time.*;

public class MemberClassRegistration {
    private String memberID;
    private String classID;
    private String status;
    private LocalDate registrationDate;

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
        return memberID+classID;
    }
    public String lineRepresentation (){
        String line = String.join(",", 
        memberID,classID,registrationDate.toString(),status);

        return line;
    }
    
}
