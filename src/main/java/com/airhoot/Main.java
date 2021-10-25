package com.airhoot;

import com.airhoot.flight.*;
import com.airhoot.person.EmailValidator;
import com.airhoot.person.NameChecker;
import com.airhoot.person.PersonService;
import com.airhoot.person.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.airhoot.BookingService.createBooking;
import static com.airhoot.BookingService.editBooking;
import static com.airhoot.flight.FlightService.createFlightsList;

public class Main {
    //    ADMIN or BOOKING
    public static void main(String[] args) {
//    I'm initializing a new flightlist where we will store all the flights
//    This particular line uses the public flightslist constructor
        FlightsList flightlist = createFlightsList();
        while (true) {
            System.out.println("Function to Access?: ");
            System.out.println("(1)ADMIN");
            System.out.println("(2)BOOKING");
            Scanner sc = new Scanner(System.in);
            int selection = sc.nextInt();
            switch (selection) {
                case 1:
                    //      if mainSelection is 1 display admin options
                    System.out.println("Select function to perform: ");
                    System.out.println("(1)CREATE NEW FLIGHT");
                    System.out.println("(2)EDIT EXISTING FLIGHT");
                    System.out.println("(3)CANCEL EXISTING");
                    System.out.println("(4)SEARCH FLIGHTS BY PASSENGER EMAIL");
                    int adminSelection = sc.nextInt();
                    switch (adminSelection) {
                        case 1:
//                    Create a new flight and prompt user input to fill in constructor
                            Flight flight = FlightService.createNewFlight();
//                    Add this new flight to the flight list
                            if (flightlist.addFlight(flight) == true) {
                                System.out.println("Flight Successfully Added");
                                System.out.println(flightlist.getFlights().toString());
                            } else {
                                System.out.println("ERROR ADDING FLIGHT");
                            }
                            continue;
                        case 2:
//                    Prompt user to select flight to edit
                            System.out.println("Select flight to edit: ");
//                    Initialize optionCount integer. This allows me to generate an option selection number next to each flight
//                    Option count will increment upwards until it reaches flight list size
//                    and display next to each flight
                            int optionCount = 0;
                            for (Flight flightOfList : flightlist.getFlights()) {
                                System.out.println("(" + optionCount + ")" + flightOfList.toString());
                                optionCount++;
                                continue;
                            }
                            Flight flightToEdit = flightlist.getFlights().get(sc.nextInt());
                            System.out.println("Select property to edit: ");
                            System.out.println("(1)DESTINATION");
                            System.out.println("(2)ORIGIN");
                            System.out.println("(3)DEPARTURE DATE");
                            System.out.println("(4)PASSENGERS");
                            System.out.println("(5)DURATION");
                            System.out.println("(6)PRICE");
                            System.out.println("(7)CAPACITY");
                            System.out.println("(8)STATUS");
                            int propertyToEdit = sc.nextInt();
                            FlightService.editFlight(propertyToEdit,flightToEdit);
                            continue;
                        case 3:
//                            Prompt user to select flight to edit
                            System.out.println("Select flight to cancel: ");
//                    Initialize optionCount integer. This allows me to generate an option selection number next to each flight
//                    Option count will increment upwards until it reaches flight list size
//                    and display next to each flight
                            optionCount = 0;
                            for (Flight flightOfList : flightlist.getFlights()) {
                                System.out.println("(" + optionCount + ")" + flightOfList.toString());
                                optionCount++;
                                continue;
                            }
                            flightToEdit = flightlist.getFlights().get(sc.nextInt());
                            FlightService.cancelFlight(flightToEdit);
                            continue;
                        case 4:
                            System.out.println("Enter passenger email");
                            String email = new String();
                            do {
                                String possibleEmail = sc.nextLine();
                                EmailValidator emailValidator = new EmailValidator();
                                if (emailValidator.validate(possibleEmail) == false) {
                                    System.out.println("Please enter a valid email");
                                } else {
                                    email = possibleEmail;
                                    break;
                                }
                            }while(true);

                            for (Flight flightOfList : flightlist.getFlights()) {
                                for (Person person : flightOfList.getPassengers()) {
                                    try {if(email.equals(person.getEmail())) {
                                        System.out.println(flightOfList.toString());
                                    }} catch(NullPointerException e) {
                                        System.out.println("Null Pointer Found");
                                    }
                                    break;
                                }
                                break;
                            }
                            continue;

                    }
//                    System.out.println(flightlist.getFlights().toString());
                    continue;


                case 2:
                    //      if mainSelection is 2 display booking options
                    System.out.println("Select function to perform: ");
                    System.out.println("(1)BOOK A FLIGHT");
                    System.out.println("(2)EDIT/CANCEL A BOOKING");
                    int bookingSelection = sc.nextInt();
                    switch (bookingSelection) {
                        case 1:
    //                    If input is 1 book a flight
    //                    Create a new passenger
                            Person passenger = PersonService.createNewPassenger();
    //                    Display all flights
                            createBooking(flightlist, passenger);
                            break;
                        case 2:
                            System.out.println("On which flight is the booking?");
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
                            Flight flightToEdit = flightlist.getFlights().get(sc.nextInt());
                            System.out.println("Which booking on this flight do you wish to edit/cancel?");
                            Person[] passengers = flightToEdit.getPassengers();
                            optionCount = 0;
                            for(int i = 0; i < flightToEdit.getCount(); i++){
                                System.out.println("(" + optionCount + ")" + "PASSENGER NAME: " + passengers[i].getName() + " PASSENGER ID: " + passengers[i].getIdNumber());
                                optionCount++;
                            }
                            Person passengerToEdit = passengers[sc.nextInt()];
                            System.out.println(passengerToEdit.toString());
                        do {
                            System.out.println("What details of this passenger would you like to edit?");
                            System.out.println("(1)NAME");
                            System.out.println("(2)EMAIL ADDRESS");
                            System.out.println("(3)PHONE NUMBER");
                            System.out.println("(4)PASSPORT NUMBER");
                            editBooking(passengerToEdit);
                            System.out.println("Would you like to edit other details of this booking?");
                            System.out.println("(1) Choose another detail to edit");
                            System.out.println("(2) Conclude editing");
                            int continueEditing = sc.nextInt();
                            switch (continueEditing) {
                                case 1:
                                    continue;
                                case 2:
                                    break;
                            }
                        }while(true);


                    }
                    continue;
                default:
                    //     if mainSelection is not 1 or 2 prompt a proper input
                    System.out.println("Please input an integer between 1 and 2: ");
            }


        }
    }







//      if selection is 2 display booking options
}

