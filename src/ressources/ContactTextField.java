package ressources;

import java.awt.Dimension;

import javax.swing.JTextField;

public class ContactTextField extends JTextField {
	
	public ContactTextField(int size) {
		super(size);
		setFont(Ressources.DEFAULT_FONT);
		setPreferredSize(new Dimension (170,40));

}
}
