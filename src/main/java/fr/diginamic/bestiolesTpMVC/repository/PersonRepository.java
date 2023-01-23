package fr.diginamic.bestiolesTpMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.bestiolesTpMVC.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

	List<Person> findByFirstNameContainsIgnoreCase(String fragment);

	@Query(value = "SELECT p.* FROM person p INNER JOIN person_animals pa on pa.person_id = p.id INNER JOIN animal a")
	List<Person> test(@Param("animalId") Integer animalId);

	@Query()

	List<Person> findDistinctPeopleByLastNameOrFirstName(String lastName, String firstName);

	List<Person> findByAgeOrderByAgeAsc(Integer age);

}