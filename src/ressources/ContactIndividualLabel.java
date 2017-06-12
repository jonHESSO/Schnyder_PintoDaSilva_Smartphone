package ressources;

import java.awt.Dimension;

public class ContactIndividualLabel extends DefaultTextLabel {

	public ContactIndividualLabel(String text) {
		super(text);
		setFont(Ressources.DEFAULT_FONT);
		setPreferredSize(new Dimension (170,40));
	}

}
