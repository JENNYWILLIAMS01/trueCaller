package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface iContactService {
    Contact addNewContact(Contact contact);

    List<Contact> getAllContacts();
}
