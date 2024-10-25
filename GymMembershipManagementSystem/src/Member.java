public class Member {
    private String name, email, memberId, phoneNumber;
    private MembershipStatus status;
    private MembershipType membershipType;

    public Member(String memberId, String name, MembershipType membershipType, String email, String phoneNumber, MembershipStatus status) {
        if (!Validator.isValidID(memberId))
            throw new IllegalArgumentException("Invalid ID number!");
        if (!Validator.isValidName(name))
            throw new IllegalArgumentException("Invalid name!");
        if (!Validator.isValidEmail(email))
            throw new IllegalArgumentException("Invalid email address!");
        if (!Validator.isValidPhoneNumber(phoneNumber))
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

}
