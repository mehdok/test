package com.mehdok.test;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pizza extends JFrame
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new Pizza();
	}
	
	private JButton buttonOK;
	private JRadioButton small, medium, large;
	private JCheckBox pepperoni, mushrooms, anchovies;
	
	public Pizza()
	{
		this.setSize(320, 200);
		this.setTitle("order your pizza");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonListener3 bl = new ButtonListener3();
		
		JPanel mainPanel = new JPanel();
		JPanel sizePanel = new JPanel();
		
		Border b1 = BorderFactory.createTitledBorder("size");
		sizePanel.setBorder(b1);
		ButtonGroup sizeGroup = new ButtonGroup();
		small = new JRadioButton("Small");
		small.setSelected(true);
		sizePanel.add(small);
		sizeGroup.add(small);
		
		medium = new JRadioButton("Medium");
		sizePanel.add(medium);
		sizeGroup.add(medium);
		
		large = new JRadioButton("Large");
		sizePanel.add(large);
		sizeGroup.add(large);
		
		mainPanel.add(sizePanel);
		JPanel topPanel = new JPanel();
		Border b2 = BorderFactory.createTitledBorder("Toppings");
		topPanel.setBorder(b2);
		
		pepperoni = new JCheckBox("Pepperoni");
		topPanel.add(pepperoni);
		
		mushrooms = new JCheckBox("Mushrooms");
		topPanel.add(mushrooms);
		
		anchovies = new JCheckBox("Anchovies");
		topPanel.add(anchovies);
		
		mainPanel.add(topPanel);
		buttonOK = new JButton("OK");
		buttonOK.addActionListener(bl);
		mainPanel.add(buttonOK);
		
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	private class ButtonListener3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == buttonOK)
			{
				String tops = "";
				if(pepperoni.isSelected())
					tops += "Pepperoni\n";
				if(mushrooms.isSelected())
					tops += "Mushrooms\n";
				if(anchovies.isSelected())
					tops += "Ancovies\n";
				
				String msg = "You Ordered a ";
				if(small.isSelected())
					msg += "small pizaa with ";
				if(medium.isSelected())
					msg += "Medium Pizza With ";
				if(large.isSelected())
					msg += "Large Pizza With ";
				
				if (tops.equals(""))
					msg += "no toppings.";
				else
					msg += "the following toppings:\n" + tops;
				
				JOptionPane.showMessageDialog(
						buttonOK, 
						msg,
						"Your Order",
						JOptionPane.INFORMATION_MESSAGE);
				
				pepperoni.setSelected(false);
				mushrooms.setSelected(false);
				anchovies.setSelected(false);
				small.setSelected(true);
			}
		}
	}

}
