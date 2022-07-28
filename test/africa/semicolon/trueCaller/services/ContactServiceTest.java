package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp(){
        contactService = new ContactService();
    }

    @Test
    void addNewContact() {
        Contact contact = new Contact();
        contact.setPhoneNumber("0908076585465");
        contact.setFirstName("omotola");
        contact.setLastName("williams");
        contact.setEmail("divajay@gmail.com");

        contactService.addNewContact(contact);

        assertEquals(1, contactService.getAllContacts().size());
        assertNotEquals(0, contact.getId());
    }

}