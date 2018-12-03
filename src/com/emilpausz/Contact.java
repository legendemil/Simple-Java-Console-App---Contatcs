package com.emilpausz;

public class Contact {

    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Phone number: " + phoneNumber);
    }

    public void updateData(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
