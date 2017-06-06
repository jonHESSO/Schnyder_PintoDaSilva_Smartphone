package app_contacts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import ressources.Ressources;
import ressources.Serializer;


public class ContactCreationFrame extends JFrame{
	
	protected String contactPath = Ressources.CONTACT_DIRECTORY ;

	// Création et ajout du panel pour les buttons
	JPanel panel = new JPanel(new FlowLayout());

	// Ajout des buttons "OK" et "Cancel"
	JButton okButton = new JButton("OK");
	JButton cancelButton = new JButton("Cancel");
	ContactCreationJpanel cpanel = new ContactCreationJpanel() ;


	public ContactCreationFrame(){
//		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		// ajout de listener
		setLayout(new BorderLayout());
		panel.setPreferredSize(Ressources.DEFAULT_BUTTON_DIMENSION);
		okButton.addActionListener(new Ok_Click());
		cancelButton.addActionListener(new Cancel_Click());

		add(cpanel,BorderLayout.NORTH) ;
		// Ajout des buttons
		panel.add(okButton);
		panel.add(cancelButton);
		add(panel,BorderLayout.SOUTH) ;



		pack();
	}

	// Listener du button de creation de contact
	class Ok_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Ajout des listener sur chaque texfield pour l'ajout à la
			// ContactList
			cpanel.createNewContact();
			try {
				Serializer.serializableObject(cpanel.cl, contactPath);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose() ;
		}
	}

	// Listener du button de confirmation de quitter la ContactCreation
	class Cancel_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int reponse = JOptionPane.showConfirmDialog(null,
					"Voulez-vous quitter l'application",
					"Confirmation",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(reponse == JOptionPane.YES_OPTION ){
				dispose() ;
			}

		}

	}

}

