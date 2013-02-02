package com.mehdok.test;

import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.*;

public class PizzaApplet extends JApplet
{
	private JButton buttonOK;	
	private JRadioButton small, medium, large;	
	private JCheckBox pepperoni, mushrooms, anchovies;
	
	public void init()
	{
		this.setSize(320, 200);
		ButtonListener4 bl = new ButtonListener4();
		
		JPanel mainPanel = new JPanel();
		
		JPanel sizePanel = new JPanel();
		
		Border b1 = BorderFactory.createTitledBorder("size");
		sizePanel.setBorder(b1);
		
		ButtonGroup sizeGroup = new ButtonGroup();
		small = new JRadioButton("small");
		small.setSelected(true);
		
		sizePanel.add(small);
		sizeGroup.add(small);
		
		medium = new JRadioButton("medium");
		sizePanel.add(medium);
		sizeGroup.add(medium);
		
		large = new JRadioButton("large");
		sizePanel.add(large);
		sizeGroup.add(large);
		
		mainPanel.add(sizePanel);
		
		JPanel topPanel = new JPanel();
		Border b2 = BorderFactory.createTitledBorder("Toppings");
		topPanel.setBorder(b2);
	
		pepperoni = new JCheckBox("pepperoni");
		pepperoni.add(pepperoni);
		
		mushrooms = new JCheckBox("mushrooms");
		topPanel.add(mushrooms);
		
		anchovies = new JCheckBox("anchovies");
		topPanel.add(anchovies);
		
		mainPanel.add(topPanel);
		
		buttonOK = new JButton("OK");
		buttonOK.addActionListener(bl);
		mainPanel.add(buttonOK);
		
		this.add(mainPanel);
		
		this.setVisible(true);
	}
	
	private class ButtonListener4 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == buttonOK)
			{
				String tops = "";
				if (pepperoni.isSelected())
		            tops += "Pepperoni\n";
		         if (mushrooms.isSelected())
		            tops += "Mushrooms\n";

		         if (anchovies.isSelected())
		            tops += "Anchovies\n";

		         String msg = "You ordered a ";
		         if (small.isSelected())
		            msg += "small pizza with ";
		         if (medium.isSelected())
		            msg += "medium pizza with ";
		         if (large.isSelected())
		            msg += "large pizza with ";

		         if (tops.equals(""))
		            msg += "no toppings.";
		         else
		            msg += "the following toppings:\n"
		                + tops;
		         JOptionPane.showMessageDialog(buttonOK,
		            msg, "Your Order",
		            JOptionPane.INFORMATION_MESSAGE);
		         
		            pepperoni.setSelected(false);
		            mushrooms.setSelected(false);
		            anchovies.setSelected(false);
		            small.setSelected(true);
			}
		}
		
	}
}
