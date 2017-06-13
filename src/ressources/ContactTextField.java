/*
 * 
 */
package ressources;

import java.awt.Dimension;

import javax.swing.JTextField;

/**
 * The Class ContactTextField.
 * Nothing fancy, just changes the font
 */
public class ContactTextField extends JTextField {
	
	/**
	 * Instantiates a new contact text field.
	 *
	 * @param size the size
	 */
	public ContactTextField(int size) {
		super(size);
		setFont(Ressources.DEFAULT_FONT);
		setPreferredSize(new Dimension (170,40));

}
}
