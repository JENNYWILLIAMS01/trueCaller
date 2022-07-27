package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

public class ContactService implements iContactService {
    @Override
    public Contact addNewContact(Contact contact) {
        return contact;
    }
}
