package com.emilpausz;

import java.util.ArrayList;

public class ContactsList {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private int currentItemIndex;

    public void showAll() {
        short size = (short)contacts.size();

        if(size > 0) {

            for (int i = 0; i < size; i++) {
                contacts.get(i).printDetails();
                System.out.println("---");
            }

        } else {
            System.out.println("There is no contacts.");
        }

    }

    private Contact getCurrentItem() {
        return contacts.get(currentItemIndex);
    }

    public void printCurrentItem () {
        getCurrentItem().printDetails();
    }

    public void add(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);
    }

    public void updateContract(String phoneNumber) {
        Contact contact = getCurrentItem();

        contact.updateData(phoneNumber);
    }

    public boolean isInList(String name) {
        boolean isInTheList = false;

        for (int i = 0; i < contacts.size(); i++) {
            currentItemIndex = -1;
            if (contacts.get(i).getName().equals(name)) {
                isInTheList = true;
                currentItemIndex = i;
                break;
            }
        }

        return  isInTheList;
    }

    public void removeContact() {
        contacts.remove(currentItemIndex);
    }
}
