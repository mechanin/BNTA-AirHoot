package com.airhoot;

import com.airhoot.flight.*;
import com.airhoot.person.BookingService;
import com.airhoot.person.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //    ADMIN or BOOKING
    public static void main(String[] args) {
//    I'm initializing a new flightlist where we will store all the flights
//    This particular line uses the public flightslist constructor
        FlightsList flightlist = new FlightsList(new ArrayList<>());
        flightlist.addFlight(new Flight(Airport.PARIS, Airport.AMSTERDAM, LocalDate.now(), 64, 64, 64, 0, Status.ON_TIME));
        flightlist.addFlight(new Flight(Airport.LONDON, Airport.LAS_VEGAS, LocalDate.now(), 64, 64, 64, 0, Status.ON_TIME));
        flightlist.addFlight(new Flight(Airport.ATLANTA, Airport.BEIJING, LocalDate.now(), 64, 64, 64, 0, Status.ON_TIME));
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
                            Person passenger = BookingService.createNewPassenger();
    //                    Display all flights
                    }
                default:
                    //     if mainSelection is not 1 or 2 prompt a proper input
                    System.out.println("Please input an integer between 1 and 2: ");
            }

        }
    }







//      if selection is 2 display booking options
}

