package ressources;

import java.awt.Dimension;

// Cr�ation d'une classe donnant forme aux labels des infos contact
public class ContactIndividualLabel extends DefaultTextLabel {

	public ContactIndividualLabel(String text) {
		super(text);
		//Ajout du font par d�faut
		setFont(Ressources.DEFAULT_FONT);
		//Dimensionnement du label
		setPreferredSize(new Dimension (270,40));
	}

}
