package com.contact.service;

import com.contact.model.Contact;
import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contact> contacts = new ArrayList<>();

    // Validation
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    private boolean isDuplicatePhone(String phone) {
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) return true;
        }
        return false;
    }

    // Add Contact
    public String addContact(String name, String phone, String email) {
        if (!isValidPhone(phone)) return "Invalid phone! Must be 10 digits.";
        if (!isValidEmail(email)) return "Invalid email format!";
        if (isDuplicatePhone(phone)) return "Contact with this phone already exists!";
        contacts.add(new Contact(name, phone, email));
        return "Contact added successfully!";
    }

    // View All Contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    // Search Contact
    public void searchContact(String name) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("Contact not found.");
    }

    // Update Contact
    public String updateContact(String phone, String newName, String newEmail) {
        if (!isValidEmail(newEmail)) return "Invalid email format!";
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                c.setName(newName);
                c.setEmail(newEmail);
                return "Contact updated successfully!";
            }
        }
        return "Contact not found.";
    }

    // Delete Contact
    public String deleteContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                contacts.remove(c);
                return "Contact deleted successfully!";
            }
        }
        return "Contact not found.";
    }
}