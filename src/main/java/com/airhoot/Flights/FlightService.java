package com.airhoot.Flights;

import com.airhoot.person.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class FlightService {

    public static void addFlight() {
        System.out.println("Enter destination ");
        Scanner sc = new Scanner(System.in);
        String destination = sc.nextLine();

        System.out.println("Enter origin ");
        String origin = sc.nextLine();

        System.out.println("Enter departure date M/d/yyyy/hh/mm ");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy/hh/mm");
        String userInput = sc.nextLine();
        LocalDateTime departureDate = LocalDateTime.parse(userInput, dateFormat);

        System.out.println("Enter duration (minutes) ");
        int duration = sc.nextInt();

        System.out.println("Enter price (gbp) ");
        int price = sc.nextInt();

        System.out.println("Enter capacity (gbp) ");
        int capacity = sc.nextInt();
        
        System.out.println("Enter status ");
        String statusString = sc.nextLine();
        
        Status status;

        switch (statusString) {
            case "ON_TIME":
                status = Status.ON_TIME;
                break;
            case "DELAYED":
                status = Status.DELAYED;
                break;
            case "CANCELLED":
                status = Status.CANCELLED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + statusString);
        };

        Flight flight = new Flight(destination,origin,departureDate,duration,price, capacity, status);
        System.out.println("new flight created");
    }

    //Flight flight  = new Flight("Paris", "London", 2021-11-06, 180, 200, 150, 0, Status.ON_TIME);
    public static boolean addPassenger(Person person, Flight flight){
        if (flight.getCapacity() > flight.getCount() +1){
            flight.setPassengers(person, flight.getCount());
            return true;
        }else{
            return false;
        }
    };

    public static boolean removePassenger(Person person, Flight flight){
        Object[] currentPassengers = flight.getPassengers();
        if(Arrays.asList(currentPassengers).contains(person)){
            int index = Arrays.asList(currentPassengers).indexOf(person);
            flight.setPassengers(null, index);
            return true;
        }else{
            return false;
        }
    };

    public static boolean changeStatus(Flight flightToChange, Status newStatus){
        flightToChange.setStatus(newStatus);
        return true;
    };

    public static boolean addFlightToList(){
return true;
    };

    public static boolean cancelFlight(){
        return true;
    };

}
