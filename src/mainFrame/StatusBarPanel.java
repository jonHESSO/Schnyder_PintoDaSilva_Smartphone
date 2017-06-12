/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 6, 2017
 */

package mainFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ressources.DefaultTextLabel;
import ressources.Kernel32;
import ressources.Ressources;
import ressources.SmallTextLabel;

public class StatusBarPanel extends JPanel implements ActionListener
{
	JLabel time ;
	JLabel batteryPercent ;
	JLabel batteryState ;
	DateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm") ;
	Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
	
	Timer timer=new Timer(5000, this);
	


	StatusBarPanel()
	{
		
		setLayout(new BorderLayout());
		setPreferredSize(Ressources.STATUSBAR_DIMENSION);
		timer.start();// Start the timer here.
		
		Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
		
		batteryPercent = new SmallTextLabel(getBatteryPercent()+"  "+getBatteryState());
//		batteryPercent.setFont(new Font("Comic Sans MS", Font.PLAIN, 10)) ;
//		batteryState = new SmallTextLabel(getBatteryState()) ;
		time = new SmallTextLabel(getDate()) ;
		
		JPanel batteryPanel = new JPanel() ;
		add(time,BorderLayout.WEST) ;
		add(batteryPercent,BorderLayout.EAST) ;
//		batteryPanel.add(batteryState);
//		batteryPanel.add(batteryPercent) ;
//		add(batteryPanel,BorderLayout.EAST) ;
		
	}
	
	public void actionPerformed(ActionEvent ev){
		if(ev.getSource()==timer){
			Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
			time.setText(getDate());// this will call at every 1 second
			batteryPercent.setText(getBatteryPercent()+"  "+getBatteryState());
//			batteryState.setText(getBatteryState());
		}
	}

	private String getDate()
	{
		return dFormat.format(new Date(System.currentTimeMillis())) ;
	}
	
	private String getBatteryPercent()
	{
		  
		return batteryStatus.getBatteryLifePercent() ;
	}
	
	private String getBatteryState()
	{
		return batteryStatus.getBatteryStateString();
	}
}
