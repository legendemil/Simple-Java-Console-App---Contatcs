package com.emilpausz;

import java.util.Scanner;

public class MobilePhone {

    private ContactsList contacts;
    private static Scanner scanner = new Scanner(System.in);

    public MobilePhone() {
        this.contacts = new ContactsList();
    }

    public void run() {

        byte option;

        do {
            printMenu();

            option = scanner.nextByte();
            scanner.nextLine();

            runOption(option);

        } while (option != 6);


    }

    private void runOption(byte option) {
        System.out.println("\n");
        switch(option) {

            case 1:
                showAllContracts();
                break;

            case 2:
                addContract();
                break;

            case 3:
                updateContract();
                break;

            case 4:
                removeContact();
                break;

            case 5:
                findContact();
                break;

            case 6:
                quit();
                break;
            default:
                System.out.println("Invalid option number.");

        }
        System.out.println("\n");
    }

    private void findContact() {
        String name;

        System.out.println("==Find a Contact==");
        System.out.println("Enter a name: ");
        name = scanner.nextLine();

        if(contacts.isInList(name)) {
            contacts.printCurrentItem();
        } else {
            System.out.println("There is no such a contact.");
        }
    }

    private void removeContact() {
        String name;

        System.out.println("==Remove Contact==");
        System.out.println("Enter a name: ");
        name = scanner.nextLine();

        if(contacts.isInList(name)) {
            contacts.removeContact();
            System.out.println("Contact has been removed.");
        } else {
            System.out.println("There is no such a contact.");
        }


    }

    private void quit() {

        System.out.println("Mobile phone is turned off.");

    }


    private void printMenu() {

        System.out.println("==Menu==");
        System.out.println("\t1.Show Contacts.");
        System.out.println("\t2.Add New Contact.");
        System.out.println("\t3.Update Contact Details.");
        System.out.println("\t4.Remove Contact.");
        System.out.println("\t5.Find a Contact.");
        System.out.println("\t6.Quit");
        System.out.println("==End of Menu==");

    }

    private void showAllContracts() {
        System.out.println("==Show All Contacts==");
        contacts.showAll();
    }

    private void addContract() {
        String name, phoneNumber;

        System.out.println("==Create New Contract==");
        System.out.println("Enter a Name: ");
        name = scanner.nextLine();

        if (!contacts.isInList(name)) {
            System.out.println("Enter a Phone Number: ");
            phoneNumber = scanner.nextLine();

            contacts.add(name, phoneNumber);
            System.out.println("Contact has been added.");
        } else {
            System.out.println("Contact is already in the list.");
        }

    }

    private void updateContract() {
        String name;

        System.out.println("==Updating Contract==");

        System.out.println("Enter a Contact Name to Edit: ");
        name = scanner.nextLine();

        if(contacts.isInList(name)) {
            String phoneNumber;

            System.out.println("Enter a New Phone Number: ");
            phoneNumber = scanner.nextLine();

            contacts.updateContract(phoneNumber);

            System.out.println("Contact has been edited.");
        } else {
            System.out.println("There is no such a Contact.");
        }
    }

}
