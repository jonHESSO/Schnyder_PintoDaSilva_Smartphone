package ressources;

import java.awt.Dimension;

// Création d'une classe donnant forme aux labels des infos contact
public class ContactIndividualLabel extends DefaultTextLabel {

	public ContactIndividualLabel(String text) {
		super(text);
		//Ajout du font par défaut
		setFont(Ressources.DEFAULT_FONT);
		//Dimensionnement du label
		setPreferredSize(new Dimension (270,40));
	}

}
