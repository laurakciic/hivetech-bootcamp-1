package service;

import model.abstracts.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    void addPerson(UUID id, Person person);

    void removePerson(UUID id);

    Optional<Person> getPersonById(UUID id);
}
