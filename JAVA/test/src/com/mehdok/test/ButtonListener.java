package com.mehdok.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener
{

	private int clickCount = 0;
	
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	*/

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		/*
		if(arg0.getSource() == HelloFrame.button1)
			HelloFrame.button1.setText("you Clicked");
		*/
		
		if(arg0.getSource() == HelloFrame.button1)
		{
			clickCount++;
			if(clickCount == 1)
				HelloFrame.button1.setText("I've been clicked");
			else
				HelloFrame.button1.setText("I've been clicked " + clickCount +" Times");
		}
		else if(arg0.getSource() == HelloFrame.exitButton)
		{
			if(clickCount > 0)
				System.exit(0);
			else
			{
				JOptionPane.showMessageDialog(null, 
						"you must click at least once!", 
						"not So fast buddy", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
