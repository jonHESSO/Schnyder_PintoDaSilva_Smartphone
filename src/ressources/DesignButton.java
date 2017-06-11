package ressources;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DesignButton extends JButton {
	
	public DesignButton(ImageIcon icon){
		super(icon);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
}
