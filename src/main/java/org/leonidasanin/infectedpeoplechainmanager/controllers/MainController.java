package org.leonidasanin.infectedpeoplechainmanager.controllers;

import org.leonidasanin.infectedpeoplechainmanager.entities.Contacts;
import org.leonidasanin.infectedpeoplechainmanager.services.ContactedPeopleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/infectedPeople")
public class MainController {
    private final ContactedPeopleService contactedPeopleService;

    public MainController(ContactedPeopleService contactedPeopleService) {
        this.contactedPeopleService = contactedPeopleService;
    }

    @GetMapping
    public Contacts getInfectedPeople() {
        return contactedPeopleService.getAllContacts();
    }
}
