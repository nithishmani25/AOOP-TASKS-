import java.util.HashMap;
import java.util.Map;

class ContactManager {
    private Map<String, String> contacts;

    public ContactManager() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (name == null || phoneNumber == null || name.trim().isEmpty() || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Name and phone number cannot be null or empty");
        }
        contacts.put(name.trim(), phoneNumber.trim());
    }

    public void removeContact(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        contacts.remove(name.trim());
    }

    public void updateContact(String name, String newPhoneNumber) {
        if (name == null || newPhoneNumber == null || name.trim().isEmpty() || newPhoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Name and phone number cannot be null or empty");
        }
        if (!contacts.containsKey(name.trim())) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.put(name.trim(), newPhoneNumber.trim());
    }

    public String getContact(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        String phoneNumber = contacts.get(name.trim());
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        return phoneNumber;
    }

    public Map<String, String> getAllContacts() {
        return new HashMap<>(contacts);
    }

    public boolean contactExists(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return contacts.containsKey(name.trim());
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        try {
            contactManager.addContact("Alice Smith", "123-456-7890");
            contactManager.addContact("Bob Johnson", "987-654-3210");
            contactManager.addContact("Charlie Brown", "555-555-5555");

            System.out.println("All contacts after adding:");
            Map<String, String> allContacts = contactManager.getAllContacts();
            for (Map.Entry<String, String> entry : allContacts.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
            }

            System.out.println("\nGetting Alice's phone number: " + contactManager.getContact("Alice Smith"));

            contactManager.updateContact("Bob Johnson", "777-888-9999");
            System.out.println("Bob's updated phone number: " + contactManager.getContact("Bob Johnson"));

            contactManager.removeContact("Charlie Brown");
            System.out.println("\nAll contacts after removing Charlie:");
            allContacts = contactManager.getAllContacts();
            for (Map.Entry<String, String> entry : allContacts.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
            }

            System.out.println("\nDoes Alice exist? " + contactManager.contactExists("Alice Smith"));
            System.out.println("Does Charlie exist? " + contactManager.contactExists("Charlie Brown"));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}