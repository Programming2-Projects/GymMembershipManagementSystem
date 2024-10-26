public class Trainer {
private String trainerId;
private String name;
private String email;
private String speciality;
private String phoneNumber;

public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
    if (!Validator.isValidID(trainerId, 'T'))
        throw new IllegalArgumentException("Invalid ID number!");
    if (!Validator.isValidName(name))
        throw new IllegalArgumentException("Invalid name!");
    if (!Validator.isValidEmail(email))
        throw new IllegalArgumentException("Invalid email address!");
    if (!Validator.isValidPhoneNumber(phoneNumber))
        throw new IllegalArgumentException("Invalid phone number!");

    this.trainerId = trainerId;
    this.name = name;
    this.email = email;
    this.speciality = speciality;
    this.phoneNumber = phoneNumber;
}

public String lineRepresentation (){
    String line = String.join(",",
    trainerId, name, email, speciality, phoneNumber);
    
    return line;
}

public String getSearchKey () {
    return trainerId;
}}
