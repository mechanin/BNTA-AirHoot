package com.airhoot.flight;

import com.airhoot.person.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class FlightService {
    public static boolean addPassenger(Person person, Flight flight){
        int count = flight.getCount();
        if (flight.getCapacity() > count +1){
            flight.setPassengers(person, flight.getCount());
            count += 1;
            return true;
        }else{
            return false;
        }
    }

    public static boolean removePassenger(Person person, Flight flight){
        Object[] currentPassengers = flight.getPassengers();
        if(Arrays.asList(currentPassengers).contains(person)){
            int index = Arrays.asList(currentPassengers).indexOf(person);
            flight.setPassengers(null, index);
            return true;
        }else{
            return false;
        }
    }

    public static boolean changeStatus(Flight flightToChange, Status newStatus){
        flightToChange.setStatus(newStatus);
        return true;
    };


    public static Flight createNewFlight(){
//        Prompt user to input flight details
        System.out.println("Input destination: ");
        Scanner sc = new Scanner(System.in);
        Airport destination = Airport.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Input origin: ");
        Airport origin = Airport.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Input departure date M/d/yyyy: ");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate departureDate = LocalDate.parse(sc.nextLine(), dateFormat);
        System.out.println("Input duration min: ");
        int duration = sc.nextInt();
        System.out.println("Input price £ ");
        int price = sc.nextInt();
        System.out.println("Input capacity ");
        int capacity = sc.nextInt();
//        Pass flight detail variables into a new flight object, set count to 0 and status to ON_TIME
        Flight flight = new Flight(destination, origin, departureDate, duration, price, capacity, 0, Status.ON_TIME);


        return flight;
    };

    public static boolean cancelFlight(){
        return true;
    };

    public static LocalDate getRandomDate() {
        LocalDate start = LocalDate.now();
        long weeks = ChronoUnit.WEEKS.between(start, start.plusYears(1));
        LocalDate randomDate = start.plusWeeks(new Random().nextInt((int) weeks + 1));
        return randomDate;
    }

    public static void editFlight(int propertyToEdit, Flight flightToEdit) {
        Scanner sc = new Scanner(System.in);
        switch (propertyToEdit) {
            case 1:
                boolean newDestination = false;
                while (newDestination == false) {
                    System.out.println("Enter new destination: ");
                    try {
                        flightToEdit.setDestination(Airport.valueOf(sc.nextLine().toUpperCase()));
                        newDestination = true;
                        System.out.println("Success");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: PLEASE ENTER VALID AIRPORT");
                    }
                }
                break;
            case 2:
                boolean newOrigin = false;
                while (newOrigin == false) {
                    System.out.println("Enter new origin: ");
                    try {
                        flightToEdit.setOrigin(Airport.valueOf(sc.nextLine().toUpperCase()));
                        newOrigin = true;
                        System.out.println("Success");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: PLEASE ENTER VALID AIRPORT");
                    }
                }
                break;
            case 3:
                boolean newDepartureDate = false;
                while (newDepartureDate == false) {
                    System.out.println("Enter new departure date M/d/yyyy: ");
                    try {
                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
                        flightToEdit.setDepartureDate(LocalDate.parse(sc.nextLine(), dateFormat));
                        newDepartureDate = true;
                        System.out.println("Success");
                        continue;
                    } catch (DateTimeParseException e) {
                        System.out.println("ERROR: PLEASE ENTER VALID DATE");
                    }

                }
                break;
            case 4:
////                            TODO Edit passengers here
            case 5:
                boolean newDuration = false;
                while (newDuration == false) {
                    System.out.println("Enter new duration min: ");
                    try {
                        flightToEdit.setDuration(sc.nextInt());
                        newDuration = true;
                        System.out.println("Success");
                        continue;
                    }
                    catch(InputMismatchException e){
                        System.out.println("ERROR: PLEASE ENTER AN INTEGER");
                        sc.next();
                    }
                }
                break;
            case 6:
                boolean newPrice = false;
                while(newPrice == false) {
                    System.out.println("Enter new price £ ");
                    try {
                        flightToEdit.setPrice(sc.nextInt());
                        newPrice = true;
                        System.out.println("Success");
                        continue;
                    } catch(InputMismatchException e){
                        System.out.println("ERROR: PLEASE ENTER AN INTEGER");
                        sc.next();
                    }
                }
                break;

            case 7:
                boolean newCapacity = false;
                while(newCapacity == false) {
                    System.out.println("Enter new capacity ");
                    try {
                        flightToEdit.setCapacity(sc.nextInt());
                        newCapacity = true;
                        System.out.println("Success");
                    } catch(InputMismatchException e){
                        System.out.println("ERROR: PLEASE ENTER AN INTEGER");
                        sc.next();
                    }
                }
                break;
            case 8:
                boolean newStatus = false;
                while (newStatus == false) {
                    System.out.println("Enter new status: ");
                    try {
                        flightToEdit.setStatus(Status.valueOf(sc.nextLine().toUpperCase()));
                        newStatus = true;
                        System.out.println("Success");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR: PLEASE ENTER VALID STATUS");
                    }
                }
                break;

        }
    }



    /*public static FlightsList createFlightsList() {
        List<Flight> flights = new ArrayList<>();
        FlightsList flightsList = new FlightsList(flights);
        final List<Airport> AIRPORTS =
                List.of(Airport.values());
        final int SIZE = AIRPORTS.size();
        Random rand = new Random();
        for(int i = 0; i < 7; i++){
            Airport destination = AIRPORTS.get(rand.nextInt(SIZE));
            Airport origin = AIRPORTS.get(rand.nextInt(SIZE));
            do {
                if (destination.equals(origin)) {
                    origin = AIRPORTS.get(rand.nextInt(SIZE));
                } else {
                    break;
                }
            } while (true);
            LocalDate departuredate = getRandomDate();
            int capacity = rand.nextInt(200) + 200;
            Object[] passengers = new Object[capacity];
            int duration = rand.nextInt(600) + 45;
            int price = rand.nextInt(800) + 50;
            int count = 0;
            Status status = Status.ON_TIME;
        }
    }*/

}
