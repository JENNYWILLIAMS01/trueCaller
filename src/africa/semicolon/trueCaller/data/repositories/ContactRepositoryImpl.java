package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    private int counter;
    private List<Contact> contacts = new ArrayList<>();
    private List<Contact> cloud = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
        Contact foundContact = findById(contact.getId());
        if (foundContact != null) {
            contact.setFirstName(contact.getFirstName());
            contact.setLastName(contact.getLastName());
            contact.setEmail(contact.getEmail());
            contact.setPhoneNumber(contact.getPhoneNumber());
        } else {
            counter++;
            contact.setId(counter);
            contacts.add(contact);
        }
        return contact;

    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
        cloud.add(contact);
    }

    @Override
    public void delete(int id) {
        Contact foundContact = findById(id);
        contacts.remove(foundContact);
        cloud.add(foundContact);
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(name)) {
                return contact;
            }
            break;
        }
        return null;
    }

    @Override
    public Contact backUpContactsOnCloud(Contact contact) {
        cloud.add(contact);
        return contact;
    }

    public Contact getContactFromCloud(int contactId) {
        for (Contact contact : cloud) {
            if (contact.getId() == contactId) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public void sortContact(String j) {

    }

}