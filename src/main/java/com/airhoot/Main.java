package com.airhoot;

import com.airhoot.Flights.Flight;
import com.airhoot.Flights.FlightsList;

import java.util.Scanner;

import static com.airhoot.person.BookingService.createNewPassenger;

public class Main {
//    ADMIN or BOOKING
public static void main(String[] args) {

    System.out.println("Function to Access?: ");
    System.out.println("(1)ADMIN");
    System.out.println("(2)BOOKING");
    Scanner sc = new Scanner(System.in);
    int selection = sc.nextInt();
//      if mainSelection is 1 display admin options
    if (selection == 1) {
        System.out.println("Select function to perform: ");
        System.out.println("(1)CREATE NEW FLIGHT");
        System.out.println("(2)EDIT EXISTING FLIGHT");
        System.out.println("(3)CANCEL EXISTING");
        int adminSelection = sc.nextInt();

//      if mainSelection is 2 display booking options
    } else if (selection == 2) {
        System.out.println("Select function to perform: ");
        System.out.println("(1)BOOK A FLIGHT");
        System.out.println("(2)EDIT/CANCEL A BOOKING");
        int bookingSelection = sc.nextInt();
        if(selection == 1){
            createNewPassenger();

        }

    }

//     if mainSelection is not 1 or 2 prompt a proper input

//      if selection is 2 display booking options
}
}
