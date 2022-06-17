package africa.semicolon.true_caller.data.repositories;

import africa.semicolon.true_caller.data.models.Contact;

public interface ContactRepository {
    Contact save(Contact contact);
    Contact findByFirstName(String firstName);
    Contact findById(int id);
    int count();

    Contact deleteContact(Contact contact);

    boolean updateContact(Contact contact, String firstName);
}
