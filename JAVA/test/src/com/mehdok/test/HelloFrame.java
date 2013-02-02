package com.mehdok.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class HelloFrame extends JFrame
{
	protected static JButton button1;
	protected static JButton exitButton;
	
	public static void main(String[] args)
	{
		new HelloFrame();
	}
	
	public  HelloFrame()
	{
		/*
		this.setSize(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("HEllo World");
		//this.setLocationRelativeTo(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int x = d.width - 200;
		int y = (d.height / 2) - this.getHeight();
		this.setLocation(x, y);
		
		this.setVisible(true);
		*/
		//====================================================
		/*
		this.setSize(200, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Hello World");
		
		JPanel panel1 = new JPanel();
		JLabel lable1 = new JLabel("Hello World");
		
		JButton button1 = new JButton();
		button1.setText("OK");
		
		panel1.add(button1);
		panel1.add(lable1);
		this.add(panel1);
		
		this.setVisible(true);
		*/
		//=================================================================
		
		this.setSize(200, 100);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("I'm Listening");
		
		JPanel panel = new JPanel();
		button1 = new JButton("Click Me");
		exitButton = new JButton("Exit");
		ButtonListener bl = new ButtonListener();
		button1.addActionListener(bl);
		exitButton.addActionListener(bl);
		panel.add(button1);
		panel.add(exitButton);
		
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new Closer());
		this.setVisible(true);
		
	}
}