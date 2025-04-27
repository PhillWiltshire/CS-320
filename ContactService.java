import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    // Adds contact only if the ID is unique
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact with this ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Deletes contact by ID
    public void deleteContact(String contactID) {
        contacts.remove(contactID);  // No need to throw an exception if the contact doesn't exist
    }

    // Helper method to get a contact or throw an error
    private Contact getExistingContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return contacts.get(contactID);
    }

    // Update methods
    public void updateFirstName(String contactID, String newFirstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setFirstName(newFirstName);
    }

    public void updateLastName(String contactID, String newLastName) {
        getExistingContact(contactID).setLastName(newLastName);
    }

    public void updatePhone(String contactID, String newPhone) {
        getExistingContact(contactID).setPhone(newPhone);
    }

    public void updateAddress(String contactID, String newAddress) {
        getExistingContact(contactID).setAddress(newAddress);
    }

    // Public getter for contact
    public Contact getContact(String contactId) {
        return contacts.get(contactId);  // Should return null if the contact is deleted
    }
}