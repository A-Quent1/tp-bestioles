package fr.diginamic.bestiolesTpMVC.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/** Classe Athlete 
 * 
 * @author Quentin
 */

@Entity
@Component
@Table(name="species")
public class Species {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "common_name", length = 50, nullable= false)
    @NotEmpty
    @Size(max = 50)
    private String commonName;

    @Column(name = "latin_name", length = 50, nullable= false)
    @NotEmpty
    @Size(max = 50)
    private String latinName;

    /**
	 * Getter pour l'attribut id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut commonName
	 * @return the commonName
	 */
	public String getCommonName() {
		return commonName;
	}

	/**
	 * Setter pour l'attribut commonName
	 * @param commonName the commonName to set
	 */
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	/**
	 * Getter pour l'attribut latinName
	 * @return the latinName
	 */
	public String getLatinName() {
		return latinName;
	}

	/**
	 * Setter pour l'attribut latinName
	 * @param latinName the latinName to set
	 */
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}

    public String toString() {
        return "Species n°"+ id +" contient [ common_name = "+ commonName +", latin_name = "+ latinName +" ]";
    }

}
