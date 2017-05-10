package app_contacts;

import java.io.Serializable;

public class Contact implements Serializable {

	private String lastName; // nom du contact
	private String firstName; // prénom du contact
	private String number; // numéro de téléphone du contact
	private String mail;
	private String imagePath; // Chemin système de(s) image(s) associée(s) au contact

	// Constructeur pour contact
	public Contact(String lastName, String firstName, String number) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.number = number;
	}

	// Permet de modifier un contact
	public void modifications(String lastName, String firstName, String number, String imagePath) {

	}
	
	public void saveContact(String lastName, String firstName, String number, String imagePath){
		
	}

	// ***GETTERS***
	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getNumber() {
		return number;
	}

	public String getImagePath() {
		return imagePath;
	}

	// ***SETTERS***
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
