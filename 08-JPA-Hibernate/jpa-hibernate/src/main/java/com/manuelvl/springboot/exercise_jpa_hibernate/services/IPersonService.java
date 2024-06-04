package com.manuelvl.springboot.exercise_jpa_hibernate.services;

import com.manuelvl.springboot.exercise_jpa_hibernate.dtos.response.PersonDTO;
import com.manuelvl.springboot.exercise_jpa_hibernate.entities.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {
    List<Person> getAll();
    PersonDTO findById(Long id);
    String getNameById(Long id);
    List<Person> getByProgrammingLanguage(String programmingLanguage);
    List<Person> buscarByProgrammingLanguageAndName(String programmingLanguage, String name);
    List<Object[]> obtenerPersonData(Long id);
    Person createPerson(Person person);
    Person updatePerson(Long id, Person person);
    String deletePerson(Long id);
    List<Object[]> findAllMixPerson();
}
