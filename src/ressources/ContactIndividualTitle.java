package ressources;

import java.awt.Dimension;

public class ContactIndividualTitle extends DefaultTextLabel{

	public ContactIndividualTitle(String text) {
		super(text);
		setFont(Ressources.CONTACT_FONT_TITLE);
		setPreferredSize(new Dimension (170,40));
	}

}
