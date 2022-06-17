package africa.semicolon.true_caller.services;

import africa.semicolon.true_caller.data.models.Contact;

public interface ContactService {
    public void addContact(String FirstName, String LastName, String PhoneBook);

    Contact findById(int i);

    Contact deleteContact(Contact contact);
}
