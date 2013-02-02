package com.mehdok.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Namer extends JFrame
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Namer();
	}
	
	private JButton buttonOK;
	private JTextField textName;
	
	public Namer()
	{
		this.setSize(325, 100);
		this.setTitle("Who Are You?");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonListener2 bl = new ButtonListener2();
		
		JPanel panel1 = new JPanel();
		
		panel1.add(new JLabel("Enter your name: "));
		textName = new JTextField(15);
		panel1.add(textName);
		
		buttonOK = new JButton("OK");
		buttonOK.addActionListener(bl);
		panel1.add(buttonOK);
		
		this.add(panel1);
		
		this.setVisible(true);
	}
	
	private class ButtonListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == buttonOK)
			{
				String name = textName.getText();
				
				if(name.length() == 0)
				{
					JOptionPane.showMessageDialog(
							Namer.this,
							"you didn't",
							"moron",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(
							Namer.this,
							"good morning " + name,
							"salutation",
							JOptionPane.INFORMATION_MESSAGE);
				}
				textName.requestFocus();
			}
		}
	}

}
