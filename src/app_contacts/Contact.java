/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Samuel Pinto Da Silva
 * Created : May 10, 2017
 */
package app_contacts;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * The Class Contact.
 */
public class Contact implements Serializable {

	/** The last name. */
	private String lastName; 
	
	/** The first name. */
	private String firstName; 
	
	/** The number. */
	private String number; 	
	
	/** The email. */
	private String email;	
	
	/** The picture. */
	private ImageIcon picture; 	
	
	/**
	 * Instantiates a new contact.
	 *
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param number the number
	 * @param email the email
	 * @param picture the picture
	 */

	public Contact(String lastName, String firstName, String number, String email, ImageIcon picture) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.number = number;
		this.email = email ;
		this.picture = picture ;
	}


	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	// ***GETTERS*** 
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Gets the picture.
	 *
	 * @return the picture
	 */
	public ImageIcon getPicture() {
		return picture;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	// ***SETTERS***
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the picture.
	 *
	 * @param picture the new picture
	 */
	public void setPicture(ImageIcon picture) {
		this.picture = picture;
	}

}
