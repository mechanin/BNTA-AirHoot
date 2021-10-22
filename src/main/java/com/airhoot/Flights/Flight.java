package com.airhoot.Flights;

import java.time.LocalDateTime ;

public class Flight {
    private String destination;
    private String origin;
    private LocalDateTime departuredate;
    private int duration;
    private int price;
    private int capacity;
    private int count;
    private Status status;

    public Flight(String destination, String origin, LocalDateTime departuredate, int duration, int price, int capacity, int count, Status status) {
        this.destination = destination;
        this.origin = origin;
        this.departuredate = departuredate;
        this.duration = duration;
        this.price = price;
        this.capacity = capacity;
        this.count = count;
        this.status = status;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDeparturedate(LocalDateTime departuredate) {
        this.departuredate = departuredate;
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

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public LocalDateTime getDeparturedate() {
        return departuredate;
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
        return super.toString();
    }
}


