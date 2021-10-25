package com.airhoot.flight;

import java.util.ArrayList;

public class FlightsList {
    private ArrayList<Flight> flights;

    public FlightsList() {
        this.flights = new ArrayList<>();
    }


    public boolean addFlight(Flight flight) {
        flights.add(flight);
        return true;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
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

