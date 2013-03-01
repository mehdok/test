package com.mehdok.jimer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * this class performing all network related stuff.
 * @author MEHDOK
 *
 */
public class NetworkStuff 
{
	// this i sthe output result of executing command.
	private InputStream stdin = null;
	
	// arraylist for holding network info
	public ArrayList<NetHolder> netHolder = new ArrayList<NetHolder>();
	
	// final item for comparison and other stuff. 
	public static final int DISABLE_NETWORK = 1;
	public static final int ENABLE_NETWORK  = 2;
	public static final String DISABLE = "disabled";
	public static final String ENABLE = "enabled";
	
	
	/**
	 * this method toggle the given netadapter, beside the boolean return value
	 * it also set the set the stdin (the global variable), which is result of
	 * executing this command.
	 * 
	 * @param netName, is the network adapter name, which you want to do something to it.
	 * @param netState, is the value of network you want to toggle.
	 * @return , if command execute with success rutern true or otherwise.
	 */
	public boolean toggleNetAdapter(String netName, String netState)
	{
		// set the command for executing
		String command = "netsh interface set interface name=\"" + netName + "\"admin=" + netState;
		
		// try to execute the command
		try
		{
			// getting runtime envirounment for executing command.
			Runtime runtime = Runtime.getRuntime();
			
			// execute the command.
			Process proc = runtime.exec(command);
			
			// getting result from executed command.
			stdin = proc.getInputStream();
			
			// command executed, so return true.
			return (true);
		}
		catch (Throwable t)
        {
            t.printStackTrace();
            
            // something went wrong so return false.
            return (false);
        }
	}
	
	
	
	/**
	 * this method find information about all network adapter and store them in
	 * an arraylist of NetHolder.
	 * @return, true if every things went right, including execute command and
	 * reading from result of executing it,, if something goes wrong it return 
	 * false.
	 */
	public boolean findNetInfo()
	{
		// the command for finding all network adapter.
		String command = "netsh interface show interface";
		
		// this process used to find result of executing command.
		Process proc = null;
		
		// getting runtime envirounment.
		Runtime runtime = Runtime.getRuntime();
		
		// try to execute the command.
		try 
		{
			 proc = runtime.exec(command);
		} 
		catch (IOException e) 
		{
			return (false);
		}
		
		// getting result of executing command.
		stdin = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(stdin);
		BufferedReader br = new BufferedReader(isr);
		
		// try to parse the result.
		String line = "";
		int itemCount = 0;
		try 
		{
			while (!(line = br.readLine()).startsWith("-----"))
			{
				// skip line start with -----
			}
			
			//netHolder.ensureCapacity(10);
			while ((line = br.readLine()) != null)
			{
				if (line.trim().equals(""))
					continue;
				itemCount++;
				String[] splat = line.split("  +", 4);
				//System.out.println("split succ");
				/*
				netHolder.ensureCapacity(itemCount);
				netHolder.get(itemCount).setNetName(splat[3]);
				netHolder.get(itemCount).setType(splat[2]);
				netHolder.get(itemCount).setState(splat[1]);
				netHolder.get(itemCount).setAdminState(splat[0]);	
				*/
				netHolder.ensureCapacity(itemCount);
				netHolder.add(new NetHolder(splat[3], splat[2], splat[1] , splat[0]));
				//itemCount++;
			}
		}
		catch (IOException e) 
		{
			return (false);
		}
			
		return (true);		
	}	
}
