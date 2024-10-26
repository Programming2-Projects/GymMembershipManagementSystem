import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole () {
        this.memberDatabase = new MemberDatabase("Members.txt");
        this.classDatabase = new ClassDatabase("Class.txt");
        this.registrationDatabase = new MemberClassRegistrationDatabase("Registration.txt");
    }

    // Creates a new member object and inserts it into the MemberDatabase
    public boolean addMember (String memberID, String name, MembershipType membershipType, String email, String phoneNumber, MembershipStatus status) {
        Member member;
        try {
            member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return memberDatabase.insertRecord(member);
    }

    // Returns a list of all members stored in the MemberDatabase
    public ArrayList<Member> getListOfMembers () {
        return memberDatabase.returnAllRecords();
    }
    
    // Creates a new Class object and inserts it into the ClassDatabase
    public boolean addClass (String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class class_;
        try {
            class_ = new Class(classID, className, trainerID, duration, maxParticipants);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return classDatabase.insertRecord(class_);
    }

    // Returns a list of all classes stored in the ClassDatabase
    public ArrayList<Class> getListOfClasses () {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass (String memberID, String classID, LocalDate registrationDate) {
        // Get refrence to the class object with the specified ID
        Class class_ = classDatabase.getRecord(classID);
        if (class_ == null) {
            System.out.println("Class not found!!");
            return false;
        }

        // Get refrence to the member object with the specified ID
        Member member = memberDatabase.getRecord(memberID);
        if (member == null) {
            System.out.println("Member not found!!");
            return false;
        }

        // Check for available seats
        int seats = class_.getAvailabeSeats();
        if (seats < 1) {
            System.out.println("No available seats!!");
            return false;
        }

        // Create a new registration then add it to the database
        MemberClassRegistration registration;
        try {
            registration = new MemberClassRegistration(memberID, classID, MembershipStatus.ACTIVE, registrationDate);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        if (registrationDatabase.insertRecord(registration))
            class_.setAvailableSeats(seats - 1);
        else {
            System.out.println("Error inserting registration record");
            return false;
        }
        return true;     
    }

    public boolean cancelRegistration (String memberID, String classID) {
        MemberClassRegistration registration = registrationDatabase.getRecord(memberID + classID);
        if (registration == null) {
            System.out.println("Registration not found!!");
            return false;
        }

        // Increase number of available seats by 1
        Class class_ = classDatabase.getRecord(classID);
        if (class_ == null) {
            System.out.println("Class not found!!");
            return false;
        }
        class_.setAvailableSeats(class_.getAvailabeSeats() + 1);

        LocalDate registrationDate = registration.getRegistrationDate();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(registrationDate, currentDate);

        // Issue a refund if the member cancels within 3 days of the registrationDate
        if (period.getYears() == 0 && period.getMonths() == 0 && period.getDays() <= 3)
            System.out.println("You get a refund.");
        
        // Update registration status to Canceled
        registration.setStatus(MembershipStatus.CANCELED);

        return true;
    }

    // Returns a list of all class registrations stored in the MemberClassRegistrationDatabase
    public ArrayList<MemberClassRegistration> getListOfRegistrations () {
        return registrationDatabase.returnAllRecords();
    }

    // Save new data before exiting program
    public void logout () {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }

}
