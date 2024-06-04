package com.manuelvl.springboot.exercise_jpa_hibernate.services;

import com.manuelvl.springboot.exercise_jpa_hibernate.dtos.response.PersonDTO;
import com.manuelvl.springboot.exercise_jpa_hibernate.entities.Person;
import com.manuelvl.springboot.exercise_jpa_hibernate.exceptions.NotFoundException;
import com.manuelvl.springboot.exercise_jpa_hibernate.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService{
    @Autowired
    private IPersonRepository personRepository;

    // Implementacion metodos de busqueda
    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
    @Override
    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));

        return new PersonDTO(person.getName(), person.getLastname());
    }

    @Override
    public String getNameById(Long id) {
        String name = personRepository.getFullNameById(id);

        if(name == null){
            throw new NotFoundException("Person not found");
        }

        return name;
    }
    @Override
    public List<Person> getByProgrammingLanguage(String programmingLanguage) {
        return personRepository.findByProgrammingLanguage(programmingLanguage);
    }
    @Override
    public List<Person> buscarByProgrammingLanguageAndName(String programmingLanguage, String name) {
        return personRepository.buscarByProgrammingLanguageAndName(programmingLanguage, name);
    }
    @Override
    public List<Object[]> obtenerPersonData(Long id) {
        return personRepository.obtenerPersonData(id);
    }

    @Override
    public List<Object[]> findAllMixPerson() {
        List<Object[]> persons= personRepository.findAllMixPerson();

        persons.forEach(person -> {
            System.out.println("Name: " + person[0]);
            System.out.println("Programming Language: " + person[1]);
        });

        return personRepository.findAllMixPerson();
    }

    // Crear una persona
    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // Actualizar una persona
    @Override
    public Person updatePerson(Long id, Person person) {
        Person personToUpdate= personRepository.findById(id).orElseThrow(()-> new NotFoundException("Person not found"));

        personToUpdate.setName(person.getName());
        personToUpdate.setLastname(person.getLastname());
        personToUpdate.setProgrammingLanguage(person.getProgrammingLanguage());

        return personRepository.save(personToUpdate);
    }

    // Eliminar una persona
    @Override
    public String deletePerson(Long id) {
        Person personToDelete= personRepository.findById(id).orElseThrow(()-> new NotFoundException("Person not found"));

        personRepository.delete(personToDelete);

        return "Person deleted successfully";
    }
}
