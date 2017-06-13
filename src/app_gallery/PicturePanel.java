/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 5, 2017
 */

package app_gallery;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

import ressources.Ressources;

// TODO: Auto-generated Javadoc
/**
 * The Class PicturePanel.
 * Contains the (kind of) fullscreen version
 * of the selected picture in the gallery
 */
public class PicturePanel extends JPanel
{
	
	/** The current picture. */
	Picture currentPicture ;
	
	/** The delete button. */
	JButton deleteButton = new JButton("Delete") ;;
	
	/** The buttons. */
	JPanel buttons ;
	

	/**
	 * Instantiates a new picture panel.
	 *
	 * @param selectedPicture the selected picture
	 */
	public PicturePanel(Picture selectedPicture){
		this.currentPicture = selectedPicture ;
		setLayout(new FlowLayout());
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		JPanel pictureContainer = new JPanel() ;
		pictureContainer.setPreferredSize(Ressources.GALLERY_PICTUREPANEL_DIMENSION);
		ImageIcon bImage = selectedPicture.getPicture() ;
		JLabel picLabel = new JLabel(bImage);
//		picLabel.setVerticalAlignment(JLabel.CENTER);
		pictureContainer.add(picLabel,BorderLayout.CENTER);
		add(pictureContainer) ;
		JPanel buttonContainer = new JPanel() ;
		deleteButton.setSize(Ressources.DEFAULT_BUTTON_DIMENSION);
		deleteButton.setFont(Ressources.DEFAULT_FONT);
		//adding a listener on the delete button
		deleteButton.addActionListener(new ActionListener()		
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//if the delete action is confirmed, fire a property change event to the parent panel
				//to indicate that the picture must be deleted
				int ret = JOptionPane.showConfirmDialog(Ressources.MAINFRAME,"Etes vous sur ?");
				if (ret == JOptionPane.YES_OPTION){
					PicturePanel.this.firePropertyChange("pictureDeleted", false, true);
				}
			}
		});
		buttonContainer.add(deleteButton) ;
		add(buttonContainer, BorderLayout.SOUTH) ;
	}
	

}
