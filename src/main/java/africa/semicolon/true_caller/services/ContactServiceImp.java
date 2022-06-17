package africa.semicolon.true_caller.services;

import africa.semicolon.true_caller.data.models.Contact;
import africa.semicolon.true_caller.data.repositories.ContactRepository;

public class ContactServiceImp implements ContactService{

    private ContactRepository contactRepository;

    public ContactServiceImp(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    @Override
    public void addContact(String firstName, String lastName, String phoneBook) {
        Contact contact = new Contact(firstName,lastName,phoneBook);
        contactRepository.save(contact);

    }

    @Override
    public Contact findById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact deleteContact(Contact contact) {
        contactRepository.deleteContact(contact);
        return contact;
    }
}
