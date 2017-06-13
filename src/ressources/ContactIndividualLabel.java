/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Samuel Pinto Da Silva
 * Created : June 11, 2017
 */
package ressources;

import java.awt.Dimension;


/**
 * The Class ContactIndividualLabel.
 * Création d'une classe donnant forme aux labels des infos contact
 */

public class ContactIndividualLabel extends DefaultTextLabel {

	/**
	 * Instantiates a new contact individual label.
	 *
	 * @param text the text
	 */
	public ContactIndividualLabel(String text) {
		super(text);
		//Ajout du font par défaut
		setFont(Ressources.DEFAULT_FONT);
		//Dimensionnement du label
		setPreferredSize(new Dimension (270,40));
	}

}
