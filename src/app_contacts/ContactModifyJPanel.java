package app_contacts;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContactModifyJPanel extends JPanel {
	
	//Textfield --> attributs obligatoires pour un contact
    private JTextField fldFirstName;
    private JTextField fldLastName;
    private JTextField fldNumber;
    
    //Textfield --> attributs optionnels pour un contact
    private JTextField fldEMail;
    private JTextField fldImagePath;
    
    //Buttons OK et Cancel
    private JButton okButton;
    private JButton cancelButton;
    
    
}
