package org.leonidasanin.infectedpeoplechainmanager.entities;

import javax.persistence.*;

@Entity
@Table(name = "person_contacts")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "person", length = 50, unique = true, nullable = false)
    private String person;

    @Column(name = "contacts", length = 1000, nullable = false)
    private String contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
