package africa.semicolon.true_caller.data.repositories;

import africa.semicolon.true_caller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImp implements ContactRepository{


    ArrayList<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        contact.setId(contacts.size() + 1);
        contacts.add(contact);
        return contact;
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact foundContact = contacts.get(i);
            if(firstName.equals(foundContact.getFirstName())){
                return foundContact;
            }

        }
        throw new NullPointerException("Contact not found");
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id-1);

    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact deleteContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact foundContact = contacts.get(i);
            if(contact.equals(foundContact)){
                contacts.remove(contact);
            }
        }
        return contact;
    }

    @Override
    public boolean updateContact(Contact contact, String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact foundContact = contacts.get(i);
            if(contact.equals(foundContact)){
                foundContact.setFirstName(firstName);
                return true;
            }

        }
        return false;
    }
}
