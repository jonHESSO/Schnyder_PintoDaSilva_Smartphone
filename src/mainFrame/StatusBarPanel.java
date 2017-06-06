/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 6, 2017
 */

package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBarPanel extends JPanel implements ActionListener
{
	JLabel time ;
	DateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss") ;
	Timer timer=new Timer(1000, this);


	StatusBarPanel()
	{
		timer.start();// Start the timer here.
		time = new JLabel(getDate()) ;
		add(time) ;
		



	}
	public void actionPerformed(ActionEvent ev){
		if(ev.getSource()==timer){
			time.setText(getDate());// this will call at every 1 second
		}
	}




	private String getDate()
	{
		return dFormat.format(new Date(System.currentTimeMillis())) ;
	}
}
