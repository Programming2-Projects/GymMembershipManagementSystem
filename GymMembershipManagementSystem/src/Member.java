public class Member {
    private String name, email, memberId, phoneNumber;
    private MembershipStatus status;
    private MembershipType membershipType;

    public Member(String memberId, String name, MembershipType membershipType, String email, String phoneNumber, MembershipStatus status) {
        if (!isValidID(memberId))
            throw new IllegalArgumentException("Invalid ID number!");
        if (!isValidName(name))
            throw new IllegalArgumentException("Invalid name!");
        if (!isValidEmail(email))
            throw new IllegalArgumentException("Invalid email address!");
        if (!isValidPhoneNumber(phoneNumber))
            throw new IllegalArgumentException("Invalid phone number!");

        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String lineRepresentation () {
        String line = String.join(",", 
        memberId, name, String.valueOf(membershipType), 
        email, phoneNumber, String.valueOf(status));

        return line;
    }

    public String getSearchKey () {
        return memberId;
    }

    // Method to validate a five alpha-numeric ID
    public static boolean isValidID (String ID) {
        if (ID.matches("^[\\w]{5}$"))
            return true;
        return false;
    }

    // Method to validate name
    public static boolean isValidName (String name) {
        if (name.matches("^[a-zA-Z]{2,}(\\s[a-zA-Z]{2,})*$"))
            return true;
        return false;
    } 

    // Method to validate email address
    public static boolean isValidEmail (String email) {
        if (email.matches(
            "^[\\w.-]+@(gmail|yahoo|outlook|hotmail|icloud|mail|yandex)\\.(com|co\\.uk|co\\.in|ru)$"))
            return true;
        return false;
    }

    // Method to validate phone number --> (+20 0123456789 OR +20123456789 OR 0123456789)
    public static boolean isValidPhoneNumber (String phoneNumber) {
        if (phoneNumber.matches(
            "^(\\+20\\s(10|11|12|15)\\d{8}|\\+20(10|11|12|15)\\d{8}|\\0(10|11|12|15)d{8})$"))
            return true;
        return false;
    } 


}
