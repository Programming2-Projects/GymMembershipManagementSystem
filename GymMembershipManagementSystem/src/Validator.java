public class Validator {

    // Method to validate a five alpha-numeric ID
    public static boolean isValidID (String ID) {
        String regex = "^[\\w]+$";
        return ID.matches(regex);
    }

    // Method to validate ID (T for Trainer, M for Member, C for Class)
    public static boolean isValidID (String id, char specialChar) {
        String regex = "^" + specialChar + "\\d{4,}$";
        return id.matches(regex);
    }

    // Method to validate name
    public static boolean isValidName (String name) {
        String regex = "^[a-zA-Z]{2,}(\\s[a-zA-Z]{2,})*$";
        return name.matches(regex);
    } 

    // Method to validate email address
    public static boolean isValidEmail (String email) {
        String regex = "^[\\w.-]+@(gmail|yahoo|outlook|hotmail|icloud|mail|yandex)\\.(com|co\\.uk|co\\.in|ru)$"; 
        return email.matches(regex);
    }

    // Method to validate phone number --> (+20 0123456789 OR +20123456789 OR 0123456789)
    public static boolean isValidPhoneNumber (String phoneNumber) {
        String regex = "^(\\+20\\s(10|11|12|15)\\d{8}|\\+20(10|11|12|15)\\d{8}|\\0(10|11|12|15)\\d{8})$";
        return phoneNumber.matches(regex);
    }

}
