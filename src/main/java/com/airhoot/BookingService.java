package com.airhoot;

import com.airhoot.flight.Flight;
import com.airhoot.flight.FlightsList;
import com.airhoot.flight.Status;
import com.airhoot.person.EmailValidator;
import com.airhoot.person.NameChecker;
import com.airhoot.person.Person;

import java.util.Scanner;

public class BookingService {
    public static void createBooking(FlightsList flightlist, Person passenger){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which flight would you like to book?");
        int optionCount = 0;
        for (Flight flightOfList : flightlist.getFlights()) {
            if(flightOfList.getStatus() == Status.CANCELLED){
                continue;
            }else {
                System.out.println("(" + optionCount + ")" + flightOfList.toString());
                optionCount++;
                continue;
            }
        }
        Flight flightToEdit;
        do {
            flightToEdit = flightlist.getFlights().get(sc.nextInt());
            if(flightToEdit.getCount() + 1 > flightToEdit.getCapacity()){
                System.out.println("ERROR: Flight at full capacity. Would you like to select a different flight?");
                System.out.println("(1) Select a new flight");
                System.out.println("(2) Terminate booking");
                int continueBooking = sc.nextInt();
                switch (continueBooking){
                    case 1:
                        continue;
                    case 2:
                        break;
                }

            }else{
                flightToEdit.setPassengers(passenger, flightToEdit.getCount());
                flightToEdit.setCount(flightToEdit.getCount() + 1);
                System.out.println("Booking successful");
                break;
            }
        }while(true);
    }

    public static void editBooking(Person passengerToEdit){
        Scanner sc = new Scanner(System.in);
        int detailSelection = sc.nextInt();
        switch (detailSelection) {
            case 1:
                System.out.println("Please input a new name (first name and last name)");
                while(true){
                    String possibleName = sc.nextLine();
                    NameChecker nameChecker = new NameChecker();
                    if (nameChecker.validate(possibleName)) {
                        passengerToEdit.setName(possibleName);
                        System.out.println("Name successfully updated");
                        break;
                    } else {
                        System.out.println("Please enter a valid name");
                    }
                }
                break;
            case 2:
                System.out.println("Please input a new email address");
                do {
                    String possibleEmail = sc.nextLine();
                    EmailValidator emailValidator = new EmailValidator();
                    if (emailValidator.validate(possibleEmail) == false) {
                        System.out.println("Please enter a valid email");
                    } else {
                        passengerToEdit.setEmail(possibleEmail);
                        System.out.println("Email successfully updated");
                        break;
                    }
                } while (true);
                break;
            case 3:
                System.out.println("Please enter a new phone number");
                do {
                    long possiblePhoneNumber = sc.nextLong();
                    if (String.valueOf(possiblePhoneNumber).length() != 12) {
                        System.out.println("Please enter valid phone number");
                    } else {
                        passengerToEdit.setPhoneNumber(possiblePhoneNumber);
                        System.out.println("Phone number successfully updated");
                        break;
                    }
                } while (true);
                break;
            case 4:
                System.out.println("Please enter a new passport number");
                passengerToEdit.setPassportNumber(sc.nextLine());
                System.out.println("Passport number successfully updated");
        }
    }
}
