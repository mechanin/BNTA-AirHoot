import java.util.ArrayList;
import java.util.List;

public class FlightsList {
    private List<FlightsList> flights;

    public FlightsList(List<FlightsList> flights) {
        this.flights = flights;
    }

    public List<FlightsList> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightsList> flights) {
        this.flights = flights;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

