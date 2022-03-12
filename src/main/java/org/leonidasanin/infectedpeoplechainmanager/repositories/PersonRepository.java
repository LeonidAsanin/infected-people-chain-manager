package org.leonidasanin.infectedpeoplechainmanager.repositories;

import org.leonidasanin.infectedpeoplechainmanager.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}