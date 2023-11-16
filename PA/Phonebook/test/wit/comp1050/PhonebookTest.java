package wit.comp1050;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest
{
    Phonebook _pb = null;

    @BeforeEach
    void initPhonebook() {
        _pb = new Phonebook();
        _pb.addContact(new Contact("Ariana", "Grande", null, null, LocalDate.parse("1993-06-26")));
        _pb.addContact(new Contact("Justin", "Bieber", "jb@singer.com", null, LocalDate.parse("1994-03-01")));
        _pb.addContact(new Contact("Billie", "Eilish", "be@popstar.com", "404-234-5567",
                LocalDate.parse("2001-12-18")));
        _pb.addContact(new Contact("Taylor", "Swift", "ts@country.org", "999-555-1234", LocalDate.parse("1989-12-13")));
        _pb.addContact(new Contact("Cardi", "B", "cb@up.com", null, null));

    }

    @Test
    void getAllContactsTest() {
        List<Contact> entries = _pb.getAllContacts();
        int count = entries.size();
        assertEquals(5, count);
    }

    @Test
    void invalidContactTest() {
        Contact c = null;
        assertAll("Bad names",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact("Bad", "", null, null, null)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new Contact(null, "Jones", "email@test.com", null, null)));

    }

    @Test
    void findContact1Test() {
        List<Contact> matches = _pb.find("Taylor");
        assertEquals(1, matches.size());
    }

    @Test
    void findContact2Test() {
        List<Contact> matches = _pb.find("i");
        assertEquals(5, matches.size());
    }

    @Test
    void findContact3Test() {
        List<Contact> matches = _pb.find("s");
        assertEquals(3, matches.size());
    }

    @Test
    void removeTest() {
        Contact justin = new Contact("Justin", "Bieber");
        Contact billie = new Contact("Billie", "Eilish");
        _pb.remove(justin);
        _pb.remove(billie);
        List<Contact> remaining = _pb.getAllContacts();
        assertEquals(3, remaining.size());
    }

    @Test
    void writeToFileTest() throws Exception {
        _pb.remove(new Contact("Cardi", "B"));
        _pb.saveToFile("phonebook.out");
    }

    @Test
    void readFromFileTest() throws Exception {
        Phonebook pbook = new Phonebook();
        pbook.readFromFile("phonebook.out");
        assertEquals(4, pbook.getAllContacts().size());
    }
}
