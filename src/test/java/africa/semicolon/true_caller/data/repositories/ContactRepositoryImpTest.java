package africa.semicolon.true_caller.data.repositories;

import africa.semicolon.true_caller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImpTest {
    private ContactRepository contactRepository;

    @BeforeEach
    public void startWithThis(){
        contactRepository = new ContactRepositoryImp();
    }
    @Test
    public void saveContact_countIsOne(){
        Contact contact = new Contact();
        contact.setFirstName("Sharon");

        Contact contact2 = new Contact();
        contact.setFirstName("Simisola");


        Contact savedContact = contactRepository.save(contact);
        assertEquals(1,savedContact.getId());

        Contact savedContact2 = contactRepository.save(contact2);
        assertEquals(2,savedContact2.getId());
        assertEquals(2,contactRepository.count());
    }
    @Test
    public void saveContact_findByIdReturnsContact(){
        Contact contact = new Contact();
        contact.setFirstName("Sharon");


        Contact contact2 = new Contact();
        contact2.setFirstName("Simi");


        Contact savedContact = contactRepository.save(contact);
        Contact savedContact2 = contactRepository.save(contact2);

        Contact foundContact = contactRepository.findById(1);
        Contact foundContact2 = contactRepository.findById(2);

        assertEquals(1,foundContact.getId());
        assertEquals(2,foundContact2.getId());

        assertEquals("Sharon",foundContact.getFirstName());
        assertEquals("Simi",foundContact2.getFirstName());
    }
    @Test
    public void saveContact_findByFirstName(){
        Contact contact = new Contact();
        contact.setFirstName("Sharon");


        Contact contact2 = new Contact();
        contact2.setFirstName("Simi");

        Contact savedContact = contactRepository.save(contact);
        Contact savedContact2 = contactRepository.save(contact);

        Contact foundContact = contactRepository.findByFirstName("Sharon");
        Contact foundContact2 = contactRepository.findByFirstName("Simi");

        assertEquals("Sharon",foundContact.getFirstName());


    }
    @Test
    public void saveContact_deleteContact(){
        Contact contact = new Contact();
        contact.setFirstName("Sharon");

        Contact contact2 = new Contact();
        contact2.setFirstName("Simi");

        Contact savedContact = contactRepository.save(contact);
        Contact savedContact2 =contactRepository.save(contact2);
        contactRepository.deleteContact(contact);
//        assertTrue(contactRepository.deleteContact(contact));
        assertEquals(1,contactRepository.count());


    }
    @Test
    public void updateContact(){
        Contact contact = new Contact();
        contact.setFirstName("Sharon");

        Contact contact2 = new Contact();
        contact2.setFirstName("Simi");

        contactRepository.updateContact(contact2,"Mimi");
        contact2.setFirstName("Mimi");

        assertEquals("Mimi",contact2.getFirstName());
    }

}