import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        // Initialize contact object before each test
        contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    public void testConstructorValidData() {
        // Ensure the constructor initializes fields correctly
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdLengthValidation() {
        // Test contact ID length limit (should not be longer than 10 characters)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"); // 11 characters
        });
    }

    @Test
    public void testFirstNameLengthValidation() {
        // Test first name length limit (should not be longer than 10 characters)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "LongFirstName", "Doe", "1234567890", "123 Main St"); // 14 characters
        });
    }

    @Test
    public void testLastNameLengthValidation() {
        // Test last name length limit (should not be longer than 10 characters)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "LongLastName", "1234567890", "123 Main St"); // 14 characters
        });
    }

    @Test
    public void testPhoneLengthValidation() {
        // Test phone length (should be exactly 10 digits)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main St"); // Invalid phone number
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789012", "123 Main St"); // Invalid phone number (more than 10 digits)
        });
    }

    @Test
    public void testAddressLengthValidation() {
        // Test address length limit (should not be longer than 30 characters)
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "This is a very long address that exceeds thirty characters"); // Invalid address
        });
    }

    @Test
    public void testSetFirstName() {
        // Test the setter for first name
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        // Test the setter for last name
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetPhone() {
        // Test the setter for phone
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testSetAddress() {
        // Test the setter for address
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    public void testContactIdNotNull() {
        // Ensure that contactId cannot be null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameNotNull() {
        // Ensure that firstName cannot be null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameNotNull() {
        // Ensure that lastName cannot be null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testPhoneNotNull() {
        // Ensure that phone cannot be null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
    }

    @Test
    public void testAddressNotNull() {
        // Ensure that address cannot be null
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }
}




