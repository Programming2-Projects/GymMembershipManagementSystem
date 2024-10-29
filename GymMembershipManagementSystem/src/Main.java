import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to FitLife Gym");

        AdminRole sarah = new AdminRole();

        System.out.println("Sarah is now adding the first trainer...");
        String trainerID = "T5412";
        String name = "David";
        String email = "david541@yahoo.com";
        String speciality = "Yoga";
        String phoneNumber = "01121554775";
        if (sarah.addTrainer(trainerID, name, email, speciality, phoneNumber)) {
            System.out.println("First Trainer has been added successfully by Sarah :)");
        }
        else
            System.out.println("Sarah failed adding a new trainer :(");
        
        System.out.println("Sarah is now adding the second trainer...");
        trainerID = "T5";
        name = "Sam";
        email = "samuel79@gmail.com";
        speciality = "Cardio";
        phoneNumber = "+20 1574886557";
        if (sarah.addTrainer(trainerID, name, email, speciality, phoneNumber)) {
            System.out.println("Second Trainer has been added successfully by Sarah :)");
        }
        else
            System.out.println("Sarah failed adding a new trainer :(");

        ArrayList<Trainer> trainers = sarah.getListOfTrainers();
        if (!trainers.isEmpty())
            {
                System.out.println("Done"); 
            }
        int size = trainers.size();
        if (size == 2)
        {
            System.out.println("Done");
        }
        System.out.println(size + " available trainers ---->");
        for (Trainer trainer:trainers)
            System.out.println(trainer); 

        System.out.println("Second Trainer will be removed by Sarah :)");
        String key = trainers.get(1).getSearchKey();
        if (!key.isEmpty())
        {
            System.out.println("Done"); 
        }
        if (sarah.removeTrainer(key)) {
            System.out.println("Second Trainer has been removed successfully by Sarah :)");
        }
        else
            System.out.println("Sarah failed removing the second trainer :("); 

        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TrainerRole david = new TrainerRole();
        System.out.println("David is now adding the first member...");
        String memberID = "M4756";
        name = "John";
        String membershipType = "MONTHLY";
        email = "johnFkenedy@outlook.com";
        phoneNumber = "+201067489224";
        String status = "ACTIVE";
        if (david.addMember(memberID, name, membershipType, email, phoneNumber, status)) {
            System.out.println("First member has been added successfully by David :)");
        }
        else
            System.out.println("david failed adding a new member :(");


        System.out.println("David is now adding the second member...");
        memberID = "M0245975";
        name = "Will";
        membershipType = "YEARLY";
        email = "will.Smith@yandex.ru";
        phoneNumber = "01547895427";
        status = "ACTIVE";
        if (david.addMember(memberID, name, membershipType, email, phoneNumber, status)) {
            System.out.println("Second member has been added successfully by David :)");
        }
        else
            System.out.println("david failed adding a new member :(");

        ArrayList<Member> members = david.getListOfMembers();
        if (!members.isEmpty())
        {
            System.out.println("Done"); 
        }
        size = members.size();
        if (size == 2)
        {
            System.out.println("Done"); 
        }
        System.out.println(size + " available members ---->");
        for (Member member:members)
            System.out.println(member); 
        
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("David is now adding the first class...");
        String classID = "C275";
        String className = "Yoga";
        trainerID = sarah.getListOfTrainers().get(0).getSearchKey();
        int duration = 120;
        int maxParticipants = 5;

        if (david.addClass(classID, className, trainerID, duration, maxParticipants)) {
            System.out.println("First class has been added successfully by David :)");
        }
        else
            System.out.println("david failed adding a new class :(");

        ArrayList<Class> classes = david.getListOfClasses();
        if (!classes.isEmpty())
        {
            System.out.println("Done"); 
        }
        size = classes.size();
        if (size == 1)
        {
            System.out.println("Done"); 
        }
        System.out.println(size + " available classes ---->");
        for (Class class_:classes)
            System.out.println(class_); 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("David is now adding the first member class registration...");
        memberID = members.get(0).getSearchKey();
        classID = classes.get(0).getSearchKey();
        LocalDate registrationDate = LocalDate.now();

        if (david.registerMemberForClass(memberID, classID, registrationDate)) {
            System.out.println("first member class registration has been added successfully by David :)");
        }
        else
            System.out.println("david failed adding a new member class registration :(");

        ArrayList<MemberClassRegistration> registrations = david.getListOfRegistrations();
        if (!registrations.isEmpty())
        {
            System.out.println("Done"); 
        }
        size = registrations.size();
        if (size == 1)
        {
            System.out.println("Done"); 
        }
        System.out.println(size + " available member class registrations ---->");
        for (MemberClassRegistration regs:registrations)
            System.out.println(regs); 

        
        
        david.logout();
        sarah.logout();

    }

}
