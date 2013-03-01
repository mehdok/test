package com.mehdok.jimer;

import java.util.TimerTask;

/**
 * this class is for running a new thread which execute the desired task at
 * specific time.
 * @author MEHDOK
 *
 */
public class DoTask extends TimerTask
{	
	// action to be performed.
	private int act;
	
	// name of the network adapter.
	private String networkName;
	
	// constructor.
	public DoTask(int action)
	{
		this( action, "");
	}
	
	// another constructor.
	public DoTask(int action, String netName)
	{
		act = action;
		networkName = netName;
	}
	
	// running the task as thread.
	public void run() 
	{
		switch(act)
		{
		case NetworkStuff.DISABLE_NETWORK :
			NetworkStuff netStuff = new NetworkStuff();
			boolean result = netStuff.toggleNetAdapter(networkName, NetworkStuff.DISABLE);
			// do some thing with result.
			break;
		case NetworkStuff.ENABLE_NETWORK :
			NetworkStuff netStuff1 = new NetworkStuff();
			boolean result1 = netStuff1.toggleNetAdapter(networkName, NetworkStuff.ENABLE);
			// do some thing with result.
			break;
		}
	}
}
