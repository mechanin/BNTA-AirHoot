package com.airhoot.Flights;

import com.airhoot.Flights.Flight;
import com.airhoot.Flights.Status;
import com.airhoot.person.Person;

import java.util.Arrays;

public class FlightService {
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

    public static void bookFlight{

    }

}
