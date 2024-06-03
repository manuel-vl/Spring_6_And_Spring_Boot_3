package com.manuelvl.springboot.exercise_jpa_hibernate.services;

import com.manuelvl.springboot.exercise_jpa_hibernate.entities.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAll();
}
