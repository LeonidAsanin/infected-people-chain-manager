package org.leonidasanin.infectedpeoplechainmanager.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;
import java.util.TreeMap;

public class Contacts {
    private final Map<String, Contacts> contactsMap;

    public Contacts() {
        contactsMap = new TreeMap<>();
    }

    @JsonAnyGetter
    public Map<String, Contacts> getContactsMap() {
        return contactsMap;
    }

    public void addContacts(String infectedPersonName, Contacts contacts) {
        contactsMap.put(infectedPersonName, contacts);
    }
}
