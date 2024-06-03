package com.manuelvl.springboot.exercise_jpa_hibernate.services;

import com.manuelvl.springboot.exercise_jpa_hibernate.entities.Person;
import com.manuelvl.springboot.exercise_jpa_hibernate.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
