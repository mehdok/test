package com.mehdok.jimer;

/**
 * this class is for holding information of the network adapter
 * @author MEHDOK
 *
 */
public class NetHolder 
{
	// info of the difference aspect of network adapter
	private String netName;
	private String type;
	private String state;
	private String adminState;
	
	// the constructor, nothing more.
	public NetHolder(String netName, String type, String state, String adminState)
	{
		this.netName = netName;
		this.type = type;
		this.state = state;
		this.adminState = adminState;
	}
	
	// setters method for network info
	public void setNetName(String netName)
	{
		this.netName = netName;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public void setAdminState(String adminState)
	{
		this.adminState = adminState;
	}
	
	// getters method for network info
	public String getNetName()
	{
		return (this.netName);
	}
	
	public String getType()
	{
		return (this.type);
	}
	
	public String getState()
	{
		return (this.state);
	}
	
	public String getAdminState()
	{
		return (this.adminState);
	}
}
