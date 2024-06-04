package com.manuelvl.springboot.exercise_jpa_hibernate.controllers;

import com.manuelvl.springboot.exercise_jpa_hibernate.entities.Person;
import com.manuelvl.springboot.exercise_jpa_hibernate.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // GETS
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(personService.getAll());
    }
    @GetMapping("/programming-language/{programmingLanguage}")
    public ResponseEntity<?> getByProgrammingLanguage(@PathVariable String programmingLanguage){
        return ResponseEntity.ok(personService.getByProgrammingLanguage(programmingLanguage));
    }
    @GetMapping("/name/{id}")
    public ResponseEntity<?> getNameById(@PathVariable Long id){
        return ResponseEntity.ok(personService.getNameById(id));
    }
    @GetMapping("/programming-language/{programmingLanguage}/name/{name}")
    public ResponseEntity<?> buscarByProgrammingLanguageAndName(@PathVariable String programmingLanguage, @PathVariable String name){
        return ResponseEntity.ok(personService.buscarByProgrammingLanguageAndName(programmingLanguage, name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPersonData(@PathVariable Long id){
        return ResponseEntity.ok(personService.findById(id));
    }
    @GetMapping("/mix")
    public ResponseEntity<?> findAllMixPerson(){
        return ResponseEntity.ok(personService.findAllMixPerson());
    }

    // POSTS
    @PostMapping("")
    public ResponseEntity<?> createPerson(@RequestBody Person person){
        return ResponseEntity.ok(personService.createPerson(person));
    }

    // PUTS
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person){
        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    // DELETES
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id){
        return ResponseEntity.ok(personService.deletePerson(id));
    }

}
