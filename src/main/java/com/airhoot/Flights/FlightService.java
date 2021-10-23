package com.airhoot.Flights;

import com.airhoot.Flights.Flight;
import com.airhoot.Flights.Status;
import com.airhoot.person.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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

    public static boolean changeStatus{

    };


    public static boolean addFlightToList(){

    };

    public static boolean cancelFlight(){

    };

    public static LocalDate getRandomDate() {
        LocalDate start = LocalDate.now();
        long weeks = ChronoUnit.WEEKS.between(start, start.plusYears(1));
        LocalDate randomDate = start.plusWeeks(new Random().nextInt((int) weeks + 1));
        return randomDate;
    }

    public static FlightsList createFlightsList(){
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
    };

}
