package com.Sravani.informationsystem.service;

import com.Sravani.informationsystem.model.Person;

import java.util.List;

public interface PersonService {
    public Person savePerson(Person person);
    public List<Person> getAllPersons();
}
