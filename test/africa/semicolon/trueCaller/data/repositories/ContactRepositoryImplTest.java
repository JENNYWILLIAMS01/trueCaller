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
     public void findAllContactTest(){
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


         assertEquals(2,contactRepository.findAll().size());
     }
     @Test
     public void searchContactByNameTest(){
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
     public void backUpAllContactTest(){
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
 }

