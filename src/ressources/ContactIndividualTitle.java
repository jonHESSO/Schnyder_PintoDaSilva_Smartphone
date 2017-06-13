/*
 * 
 */
package ressources;

import java.awt.Dimension;

/**
 * The Class ContactIndividualTitle.
 * Création d'une classe donnant forme aux titres des infos contact
 */

public class ContactIndividualTitle extends DefaultTextLabel{

	/**
	 * Instantiates a new contact individual title.
	 *
	 * @param text the text
	 */
	public ContactIndividualTitle(String text) {
		super(text);
		//Ajout du font par défaut
		setFont(Ressources.CONTACT_FONT_TITLE);
		//Dimensionnement du label
		setPreferredSize(new Dimension (170,40));
		
	}

}
