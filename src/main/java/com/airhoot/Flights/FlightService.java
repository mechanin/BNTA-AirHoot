

import com.airhoot.Flights.Flight;
import com.airhoot.Flights.Status;
import com.airhoot.person.Person;

import java.util.Arrays;

public class FlightService {
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

    public static boolean changeStatus{

    };

    public static boolean addFlightToList(){

    };

    public static boolean cancelFlight(){

    };

}
