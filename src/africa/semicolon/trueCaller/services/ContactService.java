package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

import java.util.Collection;
import java.util.List;

public class ContactService implements iContactService {
    private final ContactRepository contactRepo;

    public ContactService() {
        contactRepo = new ContactRepositoryImpl();
    }

    @Override
    public Contact addNewContact(Contact contact) {

        contactRepo.save(contact);

        return contact;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }
}