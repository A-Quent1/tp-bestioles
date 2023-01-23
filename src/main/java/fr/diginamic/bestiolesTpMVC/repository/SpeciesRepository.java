package fr.diginamic.bestiolesTpMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.bestiolesTpMVC.model.Species;

@Repository
public interface SpeciesRepository extends CrudRepository<Species, Integer> {
	
	@Query(value = "SELECT * FROM species s ORDER BY s.common_name ASC")
	List<Species> findBySpeciesOrderByCommonNameAsc();

	@Query(value = "SELECT * FROM species s WHERE s.common_name LIKE ('La%')")
	List<Species> findSpeciesCommonNameLike();

	Species findFirstByCommonName(String commonName);

	List<Species> findByLatinNameContainsIgnoreCase(String latinName);

}