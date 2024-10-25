public class Trainer {
private String trainerId;
private String name;
private String email;
private String speciality;
private String phoneNumber;

public String lineRepresentation (){
    String line = String.join(",",
    trainerId,name,email,speciality,phoneNumber);

    return line;
}

public String getSearchKey () {
    return trainerId;
}}
