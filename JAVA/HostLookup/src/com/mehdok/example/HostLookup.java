package com.mehdok.example;

import java.util.Scanner;
import java.net.*;

public class HostLookup {

	/**
	 * @param args
	 */
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("welcome to ip lookup application");
		String host;
		do
		{
			System.out.println("Enter a host name :");
			host = sc.nextLine();
			
			try
			{
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for(InetAddress ip : addresses)
					System.out.println(ip.toString());
				
			}
			catch(UnknownHostException e)
			{
				System.out.println("Unknown host");
			}
		}while(doAgain());

	}
	
	private static boolean doAgain()
	{
		System.out.println();
		String s;
		while(true)
		{
			System.out.println("another lookup? (Y or N)");
			s = sc.nextLine();
			if(s.equalsIgnoreCase("y"))
				return (true);
			else if (s.equalsIgnoreCase("n"))
					return (false);
		}
	}

}
