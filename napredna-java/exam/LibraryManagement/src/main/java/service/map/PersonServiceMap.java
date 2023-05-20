package service.map;

import model.abstracts.Person;
import service.PersonService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class PersonServiceMap implements PersonService {
    private Map<UUID, Person> persons;

    public PersonServiceMap() {
        this.persons = new HashMap<>();
    }

    @Override
    public void addPerson(UUID id, Person person) {
        persons.put(id, person);
    }

    @Override
    public void removePerson(UUID id) {
        persons.remove(id);
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return Optional.of(persons.get(id));
    }
}
