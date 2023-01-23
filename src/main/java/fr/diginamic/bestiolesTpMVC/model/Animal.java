package fr.diginamic.bestiolesTpMVC.model;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.bestiolesTpMVC.enums.Sex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/** Classe Athlete 
 * 
 * @author Quentin
 */

@Entity
@Table(name="animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "color", length = 50, nullable= false)
    @NotEmpty
    @Size(max = 50)
    private String color;

    @Column(name = "name", length = 50, nullable= false)
    @NotEmpty
    @Size(max = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    @Size(max = 50)
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;
    
    @ManyToMany(mappedBy = "animals")
	public List<Person> persons = new ArrayList<Person>();
    
    /**
	 * Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut color
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setter pour l'attribut color
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Getter pour l'attribut name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter pour l'attribut name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter pour l'attribut sex
	 * @return the sex
	 */
	public Sex getSex() {
		return sex;
	}

	/**
	 * Setter pour l'attribut sex
	 * @param sex the sex to set
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	/**
	 * Getter pour l'attribut species
	 * @return the species
	 */
	public Species getSpecies() {
		return species;
	}

	/**
	 * Setter pour l'attribut species
	 * @param species the species to set
	 */
	public void setSpecies(Species species) {
		this.species = species;
	}

	/**
	 * Getter pour l'attribut persons
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * Setter pour l'attribut persons
	 * @param persons the persons to set
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

    public String toString() {
        return "Animal n°"+ id +" contient [ color = "+ color +", name = "+ name +", sex = "+ sex +", specieId = "+ species +" ]";
    }

}
