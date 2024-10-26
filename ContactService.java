import java.util.HashMap;
import java.util.Map;

public class ContactService {
    public Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a new contact
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            return false; // Contact ID already exists
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    // Delete a contact by ID
    public boolean deleteContact(String contactId) {
        if (contacts.containsKey(contactId)) {
            contacts.remove(contactId);
            return true;
        }
        return false; 
    }

    // Update a contact's information
    public boolean updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            if (firstName != null) contact.setFirstName(firstName);
            if (lastName != null) contact.setLastName(lastName);
            if (phone != null) contact.setPhone(phone);
            if (address != null) contact.setAddress(address);
            return true;
        }
        return false; 
    }

    // Fetch a contact 
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}