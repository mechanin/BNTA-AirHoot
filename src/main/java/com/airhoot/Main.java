package com.airhoot;

import com.airhoot.Flights.FlightService;

import java.util.Scanner;

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
        System.out.println("(3)CANCEL EXISTING FLIGHT");
        int adminSelection = sc.nextInt();
        switch(adminSelection) {
            case 1:
                FlightService.addFlight();
                break;
        }

//      if mainSelection is 2 display booking options
    } else if (selection == 2) {
        System.out.println("Select function to perform: ");
        System.out.println("(1)BOOK A FLIGHT");
        System.out.println("(2)EDIT/CANCEL A BOOKING");
        int bookingSelection = sc.nextInt();

    }
//     if mainSelection is not 1 or 2 prompt a proper input
    else {
        System.out.println("Please enter a number between 1 and 2");
    }



//      if selection is 2 display booking options
}
}
