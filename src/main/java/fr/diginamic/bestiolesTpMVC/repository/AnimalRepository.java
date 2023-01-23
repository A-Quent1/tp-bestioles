package fr.diginamic.bestiolesTpMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.bestiolesTpMVC.model.Animal;
import fr.diginamic.bestiolesTpMVC.model.Species;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

	@Query(value = "SELECT * FROM animal WHERE sex = :sex1", nativeQuery = true)
	List<Animal> findAllBySex(@Param("sex1") String sex1);

	@Query(value = "SELECT IF((SELECT COUNT(*) FROM person as p INNER JOIN person_animals as p_a ON p.id  p_a.person_id"
			+ "WHERE p_animals_id = a1), 'TRUE','FALSE')")
	Boolean existPersonWithAnimal(@Param("a1") Integer a1);

	List<Animal> findBySpecies(Species species);

	List<Animal> findByColorIn(List<String> listColor);
}
