package fr.diginamic.bestiolesTpMVC.enums;

/** Enumeration des Sexes des bestioles 
 * 
 * @author Quentin
 */

public enum Sex {
	
	F ("Female"),
	M ("Male");
	
	public String libelle;
	
	Sex (String libelle) {
		this.libelle = libelle;
		
	}
	
	/**
	 * Getter pour l'attribut libelle
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter pour l'attribut libelle
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
