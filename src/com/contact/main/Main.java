package com.contact.main;

import com.contact.service.ContactService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContactService service = new ContactService();
        boolean continueApp = true;

        while (continueApp) {

            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter phone (10 digits): ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.println(service.addContact(name, phone, email));
                        break;
                    case 2:
                        service.viewContacts();
                        break;
                    case 3:
                        System.out.print("Enter name to search: ");
                        String searchName = scanner.nextLine();
                        service.searchContact(searchName);
                        break;
                    case 4:
                        System.out.print("Enter phone of contact to update: ");
                        String updatePhone = scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        System.out.println(service.updateContact(updatePhone, newName, newEmail));
                        break;
                    case 5:
                        System.out.print("Enter phone of contact to delete: ");
                        String deletePhone = scanner.nextLine();
                        System.out.println(service.deleteContact(deletePhone));
                        break;
                    case 6:
                        continueApp = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}