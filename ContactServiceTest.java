 import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
    }

    @Test
    public void testAddContactDuplicateId() {
        Contact contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);
        assertFalse(service.addContact(contact2));
    }

    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Texas St");
        service.addContact(contact);
        assertTrue(service.deleteContact("12345"));
    }

    @Test
    public void testDeleteContactNotFound() {
        assertFalse(service.deleteContact("99999"));
    }

    @Test
    public void testUpdateContactSuccess() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Ohio St");
        service.addContact(contact);
        assertTrue(service.updateContact("123", "Jane", null, "0987654321", "456 Florida St"));
        assertEquals("Jane", service.getContact("123").getFirstName());
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    public void testUpdateContactNotFound() {
        assertFalse(service.updateContact("99999", "Jane", null, "0987654321", "456 Nevada St"));
    }
}