package com.manuelvl.springboot.exercise_jpa_hibernate.repositories;

import com.manuelvl.springboot.exercise_jpa_hibernate.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    Optional<Person> findById(Long id);
    @Query("SELECT p.name FROM Person p WHERE p.id = ?1")
    String getNameById(Long id);
    // Concat
    @Query("SELECT CONCAT(p.name, ' ', p.lastname) FROM Person p WHERE p.id =?1")
    String getFullNameById(Long id);
    @Query("SELECT p, p.programmingLanguage FROM Person p")
    List<Object[]> findAllMixPerson();
    // Like and Containing
    //@Query("SELECT p FROM Person p WHERE p.name like %?1%")
    //Optional<Person> obtenerLikeName(String name);
    //Optional<Person> findByNameContaining(String name);
    @Query("SELECT p FROM Person p WHERE p.programmingLanguage = ?1 AND p.name = ?2")
    List<Person> buscarByProgrammingLanguageAndName(String programmingLanguage, String name);
    @Query("SELECT p.name, p.programmingLanguage FROM Person p WHERE p.id = ?1")
    List<Object[]> obtenerPersonData(Long id);
    // Distinct
    //@Query("SELECT DISTINCT(p.name) FROM Person p")
    //List<Person> obtenerDistinctName();
    // Concat
    //@Query("SELECT UPPER(CONCAT(p.name, ' ', p.lastname)) FROM Person p")
    //List<Person> findAllFullNameConcatUpper();
    // Order by
    @Query("SELECT p FROM Person p WHERE p.id BETWEEN ?1 AND ?2 ORDER BY p.name ASC, p.programmingLanguage DESC")
    List<Person> buscarByIdRange(Long startRange, Long endRange);
    //List<Person> findAllOrderByNameAsc();
    // Count
    //@Query("SELECT COUNT(p) FROM Person p WHERE p.programmingLanguage = ?1")
    //Long totalPersonByProgrammingLanguage(String programmingLanguage);
    // Min and Max
    //@Query("SELECT MIN(p.id) FROM Person p")
    //Long minIdPerson();
    // Length
    //@Query("SELECT p FROM Person p WHERE LENGTH(p.name) > ?1")
    //List<Person> personWithLengthHigherThan(int length);
    //@Query("SELECT MIN(LENGTH(p.name)) FROM Person p")
    //Integer getMinLengthName();
    // Sum
    //@Query("SELECT SUM(p.id) FROM Person p")
    //Long sumIdPerson();
    // Avg
    //@Query("SELECT AVG(LENGTH(p.name)) FROM Person p")
    //Double avgLengthName();
    // Subquery
    //@Query("SELECT p FROM Person p WHERE p.id IN (SELECT MAX(p.id) FROM Person p)")
    //List<Person> findPersonWithMaxId();
    //@Query("SELECT p.name, LENGTH(p.name) FROM Person p WHERE LENGTH(p.name)=(SELECT MAX(LENGTH(p.name)) FROM Person p)")
    //List<Object[]> findPersonWithMaxLengthName();

}
