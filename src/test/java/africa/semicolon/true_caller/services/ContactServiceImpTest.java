package africa.semicolon.true_caller.services;

import africa.semicolon.true_caller.data.models.Contact;
import africa.semicolon.true_caller.data.repositories.ContactRepository;
import africa.semicolon.true_caller.data.repositories.ContactRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImpTest {
    private ContactService contactService;
    private ContactRepository contactRepository;

    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryImp();
        contactService = new ContactServiceImp(contactRepository);
    }
    @Test
    void saveContact_findContactReturnsContact(){
        contactService.addContact("Ismail", "Simisola", "08136460991");
        Contact contact = contactService.findById(1);

        assertEquals("Ismail",contact.getFirstName());
        assertEquals("Simisola",contact.getLastName());
        assertEquals("08136460991",contact.getPhoneNumber());
        assertEquals(1,contactRepository.count());
    }
    @Test
    void saveContact_DeleteContact(){
        contactService.addContact("Ismail", "Simisola", "08136460991");
        Contact contact1 = contactService.findById(1);

        contactService.addContact("George-Depo", "Damilola","09075238788");
        Contact contact2 = contactService.findById(2);

        Contact removeContact =contactService.deleteContact(contact2);
        assertEquals(1,contactRepository.count());
    }

}