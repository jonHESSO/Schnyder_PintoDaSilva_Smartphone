package app_contacts;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import ressources.Ressources;

public class ContactIndividualJPanel extends JPanel {
	
	private Contact currentContact ;

	public ContactIndividualJPanel(Contact currentContact){
		
		this.currentContact = currentContact ;
		
		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new BorderLayout());
		
		//Ajout des panels pour la photo, des infos et du modifyButton
		add(PicturePanel(), BorderLayout.NORTH);
		add(InformationPanel(), BorderLayout.CENTER);
		add(ModifyButtonPanel(), BorderLayout.SOUTH);
	}

	//Panel accueillant la photo
	private JPanel PicturePanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(450, 450));
		panel.add(new JLabel(currentContact.getImagePath()));
		return panel;
	}

	private JPanel InformationPanel() {
		//Création du panel contenant les informations
		JPanel panel = new JPanel(new FlowLayout());
		
		//Dimensionnement du panel
		panel.setPreferredSize(new Dimension(450, 150));
		
		//Ajout des attributs du currentContact
		panel.add(new JLabel(currentContact.getFirstName()));
		panel.add(new JLabel(currentContact.getLastName()));
		panel.add(new JLabel(currentContact.getNumber()));
		panel.add(new JLabel(currentContact.getEmail()));
		
		return panel;
	}

	private JPanel ModifyButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JButton modifButton = new JButton ("Modifier\n contact");
		
		modifButton.addActionListener(new Modif_Click());
		panel.add((modifButton), BorderLayout.EAST);
		
		return panel;
	}
	
	class Modif_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				JFrame jf =  new JFrame() ;
		        jf.add(new ContactModifyJPanel(currentContact));
		        jf.pack();
		        jf.setVisible(true);
			}
		}
	}
