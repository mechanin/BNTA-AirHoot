package com.airhoot.flight;

import com.airhoot.person.Person;

import java.time.LocalDate;

public class Flight {
    private Airport destination;
    private Airport origin;
    private LocalDate departureDate;
    private Person[] passengers;
    private int duration;
    private int price;
    private int capacity;
    private int count;
    private Status status;


    public Flight(Airport destination, Airport origin, LocalDate departureDate, int duration, int price, int capacity, int count, Status status) {
        this.destination = destination;
        this.origin = origin;
        this.departureDate = departureDate;
        this.duration = duration;
        this.price = price;
        this.capacity = capacity;
        this.count = count;
        this.status = status;
        this.passengers = new Person[capacity];
    }

    public Person[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Person person, int index) {
        this.passengers[index] = person;
    }

    public boolean setDestination(Airport destination) {
        this.destination = destination;
        return true;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getOrigin() {
        return origin;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return count;
    }

    public Status getStatus() {
        return status;
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
        return "DEPARTING FROM " + getOrigin().toString() + " TO " + getDestination().toString() +" ON " + getDepartureDate().toString();
    }
}


