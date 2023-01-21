package ru.skadidonovan.springapp.dao;

import org.springframework.stereotype.Component;
import ru.skadidonovan.springapp.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Jeffrey", 26, "jeff@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Evan",18, "evan@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alex",30, "alex@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",47, "mike@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdate = show(id);

        personToBeUpdate.setName(updatePerson.getName());
        personToBeUpdate.setAge(updatePerson.getAge());
        personToBeUpdate.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);

    }
}
