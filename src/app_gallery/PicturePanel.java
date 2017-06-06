/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 5, 2017
 */

package app_gallery;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

import ressources.Ressources;

public class PicturePanel extends JPanel
{
	Picture currentPicture ;
	JButton deleteButton = new JButton("Delete") ;
	GalleryPanel parentPanel ;
	JPanel buttons ;
	

	public PicturePanel(Picture selectedPicture, GalleryPanel parentPanel){
		this.parentPanel=parentPanel ;
		this.currentPicture = selectedPicture ;
		setLayout(new BorderLayout());
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		ImageIcon bImage = selectedPicture.getPicture() ;
		JLabel picLabel = new JLabel(bImage);
		picLabel.setVerticalAlignment(JLabel.CENTER);
		add(picLabel, BorderLayout.CENTER);
		deleteButton.setSize(Ressources.DEFAULT_BUTTON_DIMENSION);
		deleteButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				int ret = JOptionPane.showConfirmDialog(null,"Etes vous sur ?");
				if (ret == JOptionPane.YES_OPTION){
					SwingUtilities.getWindowAncestor(PicturePanel.this).dispose() ;
					parentPanel.deletePicture( selectedPicture );
				}


			}
		});
		add(deleteButton, BorderLayout.SOUTH) ;
	}
	

}
