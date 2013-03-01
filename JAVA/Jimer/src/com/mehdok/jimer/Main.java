package com.mehdok.jimer;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
*/

public class Main 
{
	
	
	//final string for disabling network.
	//private static final String DISABLED = "disabled";
			
	// final string for enabling network.
	//private static final String ENABLED = "enabled";
	
	//network adapter state, can be choosed between enabled or diasbled.
	//private String netAdapterState = DISABLED;	
	
	public static void main(String[] args) 
	{	
		NetworkStuff netStuff = new NetworkStuff();
		boolean result = netStuff.findNetInfo();
		int count = 0;
		//System.out.println(result);
		if (result)	
		{
			count = netStuff.netHolder.size();
			for (int i = 0; i < count; i++)
			{
				System.out.println(netStuff.netHolder.get(i).getNetName());
				System.out.println(netStuff.netHolder.get(i).getState());
				System.out.println(netStuff.netHolder.get(i).getType());
				System.out.println(netStuff.netHolder.get(i).getAdminState());
			}
		}
		// name of the network that command will execute on it.
		//String networkName = "";
		
		//test
		//getCurrentTime();
		//System.out.println(year + "\n" + month + "\n" + day + "\n" + hour + "\n" + minute + "\n" + second);
		
		// command that will execute in DOS (cmd WIN).
		//String cmdCommand = "";
		
		// cmd command for enabling specific network adapter.
		//String disableNetwork = "netsh interface set interface name=\"" + networkName + "\"admin=enabled";
		
		// cmd command for disabling specific network adapter.
		//String enableNetwork = "netsh interface set interface name=\"" + networkName + "\"admin=disabled";
	}	
}
