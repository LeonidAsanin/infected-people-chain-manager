package org.leonidasanin.infectedpeoplechainmanager.services;

import org.leonidasanin.infectedpeoplechainmanager.jsonObjects.Contacts;
import org.leonidasanin.infectedpeoplechainmanager.entities.Person;
import org.leonidasanin.infectedpeoplechainmanager.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactedPeopleService {
    private final PersonRepository personRepository;

    public ContactedPeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private Contacts getContactsByPerson(List<Person> personList, Person person) {
        Contacts contacts = new Contacts();
        String contactsString = person.getContacts();
        String[] contactsArray = contactsString.split(";");
        List<String> contactsList = Arrays.stream(contactsArray)
                .map(String::trim)
                .collect(Collectors.toList());
        for (String contactedPerson : contactsList) {
            Optional<Person> optionalPerson = personList.stream()
                    .filter(p -> p.getPerson().equals(contactedPerson))
                    .findAny();
            if (optionalPerson.isPresent()) {
                personList.remove(optionalPerson.get());
                contacts.addContacts(contactedPerson, getContactsByPerson(personList, optionalPerson.get()));
            } else {
                contacts.addContacts(contactedPerson, null);
            }
        }
        return contacts;
    }

    public Contacts getAllContacts() {
        LinkedList<Person> personList = new LinkedList<>(personRepository.findAll());

        Contacts contacts = new Contacts();
        while (!personList.isEmpty()) {
            Person person = personList.removeFirst();
            String name = person.getPerson();
            if (person.getContacts().equals("")) {
                contacts.addContacts(name, null);
            } else {
                contacts.addContacts(name, getContactsByPerson(personList, person));
            }
        }

        return contacts;
    }
}
