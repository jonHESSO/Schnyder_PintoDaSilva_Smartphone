/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Samuel Pinto Da Silva
 * Created : June 09, 2017
 */
package ressources;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class DesignButton.
 * Just a JButton without borders
 * that takes an imgageicon as parameter
 */
public class DesignButton extends JButton {
	
	/**
	 * Instantiates a new design button.
	 *
	 * @param icon the icon
	 */
	public DesignButton(ImageIcon icon){
		super(icon);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
}
