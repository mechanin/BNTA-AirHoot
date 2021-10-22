package com.airhoot.person;

import java.util.Objects;

public class Person {
    private String name;
    private String email;
    private int phoneNumber;
    private int idNumber;
    private int passportNumber;

    public Person(String name, String email, int phoneNumber, int idNumber, int passportNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", idNumber=" + idNumber +
                ", passportNumber=" + passportNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber && idNumber == person.idNumber && passportNumber == person.passportNumber && Objects.equals(name, person.name) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber, idNumber, passportNumber);
    }
}
