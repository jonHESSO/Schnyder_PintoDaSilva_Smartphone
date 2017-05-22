package app_contacts;
//Imports
import java.awt.event.*;

//imports layouts
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//imports J***
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContactCreationJpanel extends JPanel {
	
	//Textfield --> attributs obligatoires pour un contact
    private JTextField fieldFirstName;
    private JTextField fieldLastName;
    private JTextField fieldNumber;
    
    //Textfield --> attributs optionnels pour un contact
    private JTextField fieldEmail;
    private JTextField fieldImagePath;
    
    //Buttons OK et Cancel
    private JButton okButton;
    private JButton cancelButton;
    
    //Panel accueillant le panel avec les JTexfields et celui avec les JButtons
    public void FormPanel() {

        setLayout(new BorderLayout());
        add(contactFieldsPanel());
        add(buttonsFieldsPanel(), BorderLayout.SOUTH);
    }
    
    //Panel accueillant les buttons "Ok" et "Cancel"
    public JPanel buttonsFieldsPanel() {
    	
        JPanel panel = new JPanel(new FlowLayout());
        JButton CancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new Cancel_Click());
        //Ajout des buttons
        panel.add((okButton = new JButton("Ok")));
        panel.add(cancelButton);

        return panel;
    }
    
	class Cancel_Click implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int ret = JOptionPane.showConfirmDialog(null, "Voulez-vous annuler la création du contact ?", "Confirmation d'annulation"
													, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
			if (ret == JOptionPane.YES_OPTION)
				//Ferme uniquement la fenêtre:
				//a faire plus tard, revient sur la fenetre precedente (liste de contacts)
		}
	}
    


    public JPanel contactFieldsPanel(){
    	JPanel panel = new JPanel(new FlowLayout());
    	//Ajout des textfields
    		//attributs obligatoires pour un contact
    		panel.add(fieldFirstName);
    		panel.add(fieldLastName);
    		panel.add(fieldNumber);
    		//attributs optionnels pour un contact
    		panel.add(fieldEmail);
    		panel.add(fieldImagePath);
    	return panel;
    }
}
