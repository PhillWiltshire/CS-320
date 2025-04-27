import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        // Initialize the ContactService before each test
        contactService = new ContactService();
    }

    @Test
    public void testAddContactWithUniqueId() {
        // Create a new contact with a unique ID
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Assert that the contact is successfully added
        assertEquals(contact, contactService.getContact("12345"));
    }

    @Test
    public void testAddContactWithDuplicateIdThrowsException() {
        // Create two contacts with the same ID
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Doe", "0987654321", "456 Elm St");

        // Add the first contact
        contactService.addContact(contact1);

        // Assert that an exception is thrown when trying to add a contact with the same ID
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    public void testDeleteExistingContact() {
        // Create and add a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Delete the contact
        contactService.deleteContact("12345");

        // Assert that the contact is deleted (should return null)
        assertNull(contactService.getContact("12345"));
    }

    @Test
    public void testDeleteNonExistentContactDoesNothing() {
        // Assert that no exception is thrown when trying to delete a non-existent contact
        assertDoesNotThrow(() -> contactService.deleteContact("nonexistent"));
    }

    @Test
    public void testUpdateFirstNameWithValidId() {
        // Create and add a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update first name
        contactService.updateFirstName("12345", "Jane");

        // Assert that the first name has been updated
        assertEquals("Jane", contactService.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateFirstNameWithInvalidIdThrowsException() {
        // Assert that an exception is thrown when trying to update a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("nonexistent", "NewName");
        });
    }

    @Test
    public void testUpdateLastNameWithValidId() {
        // Create and add a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update last name
        contactService.updateLastName("12345", "Smith");

        // Assert that the last name has been updated
        assertEquals("Smith", contactService.getContact("12345").getLastName());
    }

    @Test
    public void testUpdateLastNameWithInvalidIdThrowsException() {
        // Assert that an exception is thrown when trying to update a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("nonexistent", "NewLastName");
        });
    }

    @Test
    public void testUpdatePhoneWithValidId() {
        // Create and add a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update phone number
        contactService.updatePhone("12345", "0987654321");

        // Assert that the phone number has been updated
        assertEquals("0987654321", contactService.getContact("12345").getPhone());
    }

    @Test
    public void testUpdatePhoneWithInvalidIdThrowsException() {
        // Assert that an exception is thrown when trying to update a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("nonexistent", "0987654321");
        });
    }

    @Test
    public void testUpdateAddressWithValidId() {
        // Create and add a contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        // Update address
        contactService.updateAddress("12345", "456 Elm St");

        // Assert that the address has been updated
        assertEquals("456 Elm St", contactService.getContact("12345").getAddress());
    }

    @Test
    public void testUpdateAddressWithInvalidIdThrowsException() {
        // Assert that an exception is thrown when trying to update a non-existent contact
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("nonexistent", "456 Elm St");
        });
    }

    @Test
    public void testUpdateNonExistentContactDoesNothing() {
        // Assert that no exception is thrown when trying to update a non-existent contact
        assertDoesNotThrow(() -> {
            contactService.updateFirstName("nonexistent", "UpdatedName");
        });
    }
}
