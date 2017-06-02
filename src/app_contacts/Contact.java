package app_contacts;

import java.io.Serializable;

public class Contact implements Serializable {

	private String lastName; 	// nom du contact
	private String firstName; 	// prenom du contact
	private String number; 		// numero du contact
	private String email;		// mail du contact
	private String imagePath; 	// Chemin systeme de(s) image(s) associee(s) au contact

	// Constructeur pour contact
	public Contact(String lastName, String firstName, String number) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.number = number;
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
	
	public String getEmail() {
		return email;
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
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
