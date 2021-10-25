package com.airhoot.person;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PersonService {
    private static long idCounter = 0;

    public static synchronized String createID()
    {
        return String.valueOf(idCounter++);
    }

    public static Person createNewPassenger(){
        Scanner inputPassengerInfo = new Scanner(System.in);
        System.out.println("Creating a new booking");
        System.out.println("What is the name of the passenger? (first name and last name)");
        String name = new String();
        do {
            String possibleName = inputPassengerInfo.nextLine();
            NameChecker nameChecker = new NameChecker();
            if (nameChecker.validate(possibleName)) {
                name = possibleName;
                break;
            }else{
                System.out.println("Please enter a valid name");
            }
        }while(true);

        System.out.println("What is the email address of the passenger?");
        String email = new String();
        do {
            String possibleEmail = inputPassengerInfo.nextLine();
            EmailValidator emailValidator = new EmailValidator();
            if (emailValidator.validate(possibleEmail) == false) {
                System.out.println("Please enter a valid email");
            }else{
                email = possibleEmail;
                break;
            }
        }while(true);
        System.out.println("What is the phone number of the passenger? ( 12 digits with country code, no + or 0)");
        long phoneNumber = 0;
        do{
            long possiblePhoneNumber = inputPassengerInfo.nextLong();
            if(String.valueOf(possiblePhoneNumber).length() != 12){
                System.out.println("Please enter valid phone number");
            }
            else{
                phoneNumber = possiblePhoneNumber;
                break;
            }
        }while(true);

        System.out.println("What is the passport number of the passenger");
        Scanner sc1 = new Scanner(System.in);
        String passportNumber = sc1.nextLine();
        String idNumber = createID();

        Person person = new Person(name, email, phoneNumber, idNumber, passportNumber);

        return person;
    }


}
