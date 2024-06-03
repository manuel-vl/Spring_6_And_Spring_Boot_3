package com.manuelvl.springboot.exercise_jpa_hibernate.repositories;

import com.manuelvl.springboot.exercise_jpa_hibernate.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
}
