package com.mehdok.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import socks.*;
import socks.server.*;

public class SocksClient 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		SocksServerSocket sock = null;
		try {
			sock = new SocksServerSocket("127.0.0.1", 50352);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sock.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*
		//it must be filled with address of clientListener, actually localhost
		String clientListener = "localhost";
		
		//the port that clientListener is listening to it
		int clientListenerPort = 50352;
		
		SocksSocket clientServerSocket = null;
		
		//set default proxy, the way to connect to server
		try 
		{
			Proxy.setDefaultProxy(clientListener, clientListenerPort);
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create a simple auth, later complex method will be used
		Authentication auth = new AuthenticationNone();
		
		//getting the proxy
		Proxy clientServerBridge = Proxy.getDefaultProxy();
		//clientServerbridge.setAuthenticationMethod(0, auth);
		
		//this is the address of the server
		String serverHost = "lcoalhost";
		
		//this the port that server is listening
		int serverPort = 1080;
		
		//tring to connect to server via proxy
		try 
		{
			clientServerSocket = new SocksSocket(clientServerBridge, serverHost, serverPort);
		}
		catch (SocksException | UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//========================================
		//creating listener
		
		//local port that local Listener must listen to it
		int localListenerPort = 0;
		
		//local host that listener must listen to it
		String localListenerHost = null;
		
		//create a InetAddress for retriving localhost ip
		InetAddress localAddress = null;
		
		//tring conver localListenerHost to ip
		try 
		{
			localAddress = InetAddress.getByName(localListenerHost);
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//may be you can write a better authentication next time
		ServerAuthenticator serverAuth = new ServerAuthenticatorNone();
				
		//this instance used for listening to a specific port
		ProxyServer pServer = new ProxyServer(serverAuth);
		
		//pServer.setProcy(clientServerBridge)
				
		//setting log output, may be you must use is as static
		pServer.setLog(System.out);
				
		//starting server, listening will be start
		pServer.start(localListenerPort, 5, localAddress);
		
		*/

	}

}
