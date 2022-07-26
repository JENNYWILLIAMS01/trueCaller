package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactRepositoryImplTest {

    @Test
    public void saveTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Olaoluwa");
        contact.setLastName("oLAOLUWA");
        contact.setEmail("divajayjenny@gmail.com");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void saveContact_findByIdTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Olaoluwa");
        contact.setLastName("oLAOLUWA");
        contact.setEmail("divajayjenny@gmail.com");
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("Olaoluwa", savedContact.getFirstName());
    }

    @Test
    public void deleteContact_findByContactTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Olaoluwa");
        contact.setLastName("oLAOLUWA");
        contact.setEmail("divajayjenny@gmail.com");
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("Olaoluwa", savedContact.getFirstName());

        contactRepository.delete(contact);
        assertEquals(0, contactRepository.count());
    }

    @Test
    public void deleteContact_findByIdTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Olaoluwa");
        contact.setLastName("oLAOLUWA");
        contact.setEmail("divajayjenny@gmail.com");
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        Contact savedContact = contactRepository.findById(1);
        assertEquals("Olaoluwa", savedContact.getFirstName());

        contactRepository.delete(1);
        assertEquals(0, contactRepository.count());
    }

    @Test
    public void updateTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Olaoluwa");
        contact.setLastName("oLAOLUWA");
        contact.setEmail("divajayjenny@gmail.com");

        contactRepository.save(contact);
        Contact savedContact = contactRepository.findById(1);
        assertEquals("Olaoluwa", savedContact.getFirstName());

        contact.setPhoneNumber("09051617162");
        contact.setFirstName("Omotola");
        contact.setLastName("oMOTOLA");
        contact.setEmail("divajayjay@gmail.com");

        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());

        savedContact = contactRepository.findById(1);
        assertEquals("Omotola", savedContact.getFirstName());
    }

    @Test
    public void findAllContactTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Olaoluwa");
        contact.setLastName("oLAOLUWA");
        contact.setEmail("divajayjenny@gmail.com");

        contactRepository.save(contact);
        Contact savedContact = contactRepository.findById(1);
        assertEquals("Olaoluwa", savedContact.getFirstName());


        Contact contact2 = new Contact();
        contact2.setPhoneNumber("08174836318");
        contact2.setFirstName("Oluwatomisin");
        contact2.setLastName("oLUWATOMISIN");
        contact2.setEmail("olamide@gmail.com");

        contactRepository.save(contact2);
        savedContact = contactRepository.findById(2);
        assertEquals("Oluwatomisin", savedContact.getFirstName());


        assertEquals(2, contactRepository.findAll().size());
    }

    @Test
    public void searchContactByNameTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Olaoluwa");
        contact.setLastName("oLAOLUWA");
        contact.setEmail("divajayjenny@gmail.com");
        contactRepository.save(contact);

        Contact contact2 = new Contact();
        contact2.setPhoneNumber("08174836318");
        contact2.setFirstName("Oluwatomisin");
        contact2.setLastName("oLUWATOMISIN");
        contact2.setEmail("olamide@gmail.com");
        contactRepository.save(contact2);
        Contact foundContact = contactRepository.searchContact("Olaoluwa");
        assertEquals("Olaoluwa", foundContact.getFirstName());
    }

    @Test
    public void backUpAllContactTest() {
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08174836318");
        contact.setFirstName("Omotola");
        contact.setLastName("Williams");
        contact.setEmail("divajayjenny@gmail.com");
        contactRepository.save(contact);

        Contact contact2 = new Contact();
        contact2.setPhoneNumber("09155164798");
        contact2.setFirstName("Nifemi");
        contact2.setLastName("Daniel");
        contact2.setEmail("nifemidaniel50@gmail.com");
        contactRepository.save(contact2);

        contactRepository.delete(1);
        assertEquals(1, contactRepository.count());
        assertEquals("Omotola", contactRepository.getContactFromCloud(1).getFirstName());
    }

//    @Test
//    public void searchForContactAlphabeticallyTest() {
//        ContactRepository contactRepository = new ContactRepositoryImpl();
//        Contact contact = new Contact();
//        contact.setPhoneNumber("09028457986");
//        contact.setFirstName("Jennifer");
//        contact.setLastName("Deborah");
//        contact.setEmail("omotola@gmail.com");
//        contactRepository.save(contact);
//
//        Contact contact2 = new Contact();
//        contact2.setPhoneNumber("08167845361");
//        contact2.setFirstName("Seyi");
//        contact2.setLastName("Busola");
//        contact2.setEmail("seyi@gmail.com");
//        contactRepository.save(contact2);
//
//        Contact contact3 = new Contact();
//        contact3.setPhoneNumber("09080765478");
//        contact3.setFirstName("Joshua");
//        contact3.setLastName("Oladeji");
//        contact3.setEmail("Joshua@gmail.com");
//        contactRepository.save(contact3);
//
//        Contact contact4 = new Contact();
//        contact4.setPhoneNumber("07067890654");
//        contact4.setFirstName("Folourosho");
//        contact4.setLastName("Olamide");
//        contact4.setEmail("Olamide@gmail.com");
//        contactRepository.save(contact4);
//
//        Contact contact5 = new Contact();
//        contact5.setPhoneNumber("090605044536");
//        contact5.setFirstName("Joshua");
//        contact5.setLastName("Oladeji");
//        contact5.setEmail("Joshua@gmail.com");
//        contactRepository.save(contact5);
//
//        contactRepository.sortContact("j");
//        assertEquals(5, contactRepository.count());
//        assertEquals("", contactRepository.getContactFromCloud(1).getPhoneNumber());
//    }

}


