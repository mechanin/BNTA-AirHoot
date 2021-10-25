package com.airhoot;

import com.airhoot.flight.*;
import com.airhoot.person.PersonService;
import com.airhoot.person.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
                            Scanner sc1 = new Scanner(System.in);
                            switch (propertyToEdit) {
                                case 1:
                                    System.out.println("Enter new destination: ");
                                    flightToEdit.setDestination(Airport.valueOf(sc1.nextLine().toUpperCase()));
                                    continue;
                                case 2:
                                    System.out.println("Enter new origin: ");
                                    flightToEdit.setOrigin(Airport.valueOf(sc1.nextLine().toUpperCase()));
                                    continue;
                                case 3:
                                    System.out.println("Enter new departure date M/d/yyyy: ");
                                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
                                    flightToEdit.setDepartureDate(LocalDate.parse(sc1.nextLine(), dateFormat));
                                    continue;
                                case 4:
//                            TODO Edit passengers here
                                case 5:
                                    System.out.println("Enter new duration min: ");
                                    flightToEdit.setDuration(sc1.nextInt());
                                    continue;
                                case 6:
                                    System.out.println("Enter new price £ ");
                                    flightToEdit.setPrice(sc1.nextInt());
                                    continue;
                                case 7:
                                    System.out.println("Enter new capacity ");
                                    flightToEdit.setCapacity(sc1.nextInt());
                                    continue;
                                case 8:
                                    System.out.println("Enter new status ");
                                    flightToEdit.setStatus(Status.valueOf(sc1.nextLine().toUpperCase()));
                                    continue;
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
                            System.out.println("Which flight would you like to book?");
                            int optionCount = 0;
                            for (Flight flightOfList : flightlist.getFlights()) {
                                System.out.println("(" + optionCount + ")" + flightOfList.toString());
                                optionCount++;
                                continue;
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
                default:
                    //     if mainSelection is not 1 or 2 prompt a proper input
                    System.out.println("Please input an integer between 1 and 2: ");
            }


        }
    }







//      if selection is 2 display booking options
}

