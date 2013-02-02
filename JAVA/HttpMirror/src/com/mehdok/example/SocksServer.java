package com.mehdok.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

import socks.*;
import socks.server.*;


public class SocksServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//server listening port
		int serverListeningPort = 50352;
		
		//create a InetAddress for retriving localhost ip
		InetAddress localAddress = null;
		
		//try to retriving localhost ip
		try 
		{
			localAddress = InetAddress.getByName("localhost");
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//fake auth
		IdentAuthenticator au = new IdentAuthenticator();
		InetRange ra = new InetRange();
		try {
			ra.add(InetAddress.getByName("0.0.0.0"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		au.add(ra, null);
		
		//may be you can write a better authentication next time
		ServerAuthenticator auth = new ServerAuthenticatorNone();
		
		//this instance used for listening to a specific port
		ProxyServer pServer = new ProxyServer(auth);
		
		//setting log output, may be you must use is as static
		pServer.setLog(System.out);
		
		//starting server, listening will be start
		pServer.start(serverListeningPort, 5, localAddress);
	}
}
