package com.mehdok.example;

import socks.*;
import socks.server.ServerAuthenticator;
import socks.server.ServerAuthenticatorNone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocksMirror
{
	//static InetAddress clientAddress;
	//int clientPort;
	public static void main(String[] args)
	{
		
		/*
		//ServerSocket ss = null;
		try
		{
			int clientListenPort = 50352;
			
			System.out.println("creating authenticator");
			ServerAuthenticator auth = new ServerAuthenticatorNone();
			System.out.println("authenticator created");
			
			System.out.println("create proxy server");// jabeja
			ProxyServer pServer = new ProxyServer(auth);
			System.out.println("proxy server created");
			
			InetAddress add = InetAddress.getByName("127.0.0.1");
			//System.out.println(add.getHostName());

			
			//System.out.println("seting default proxy");
			//Proxy p = Proxy.getDefaultProxy();
			//p.setDefaultProxy(add, clientListenPort);
			//p = Proxy.getDefaultProxy();
			//System.out.println("default proxy created");
			
			//System.out.println("default proxy is" + p.toString());
			
			//System.out.println("set proxy for proxy server");
			//pServer.setProxy(p);
			//System.out.println("proxy was assgined to the server");
			
			//System.out.println("server proxy is" + pServer.getProxy().toString());
			
			System.out.println("setting log output");
			//OutputStream log = null;
			pServer.setLog(System.out);
			System.out.println("log assigned");
			
			//pServer.setIddleTimeout(30);
			
			System.out.println("start proxy listening to the port");
			pServer.start(clientListenPort, 5, add);
			//System.out.println(log.toString());
			
			System.out.println("we passed start method, may be connection stablished");
			
			System.out.println("reading browser request" + pServer.getProxy().toString());
			
			//ServerAuthenticator auth = new ServerAuthenticatorNone();
			//ProxyServer ps = new ProxyServer(auth);
			//System.out.println("starting proxy");
			//ps.start(port);
			//System.out.println("proxy started");
			//Proxy p = ps.getProxy();
			//p.start(50352);
			
			//System.out.println("create socks5 proxy");
			//Proxy p = new Socks5Proxy("127.0.0.1", port);
			//System.out.println("create server socket");
			
			
				//Proxy p = null;
				//System.out.println("create socks5 proxy");
				//Proxy.setDefaultProxy("", port);
				//p = Proxy.getDefaultProxy();
				//Proxy p = Proxy.parseProxy("127.0.0.1:50352");
				//System.out.println("create server socket");
				//if (p == null)
				//	System.out.println("proxy is null");
				//else
				//{
					//System.out.println("proxy is not null");
					//System.out.println(p.toString());
					//System.out.println("creating server socket");
				//	ss = new ServerSocket(port);// SocksServerSocket(p, "127.0.0.1", port);
					//System.out.println("server socket created");
					//
					//System.out.println("creating socks server socket");
					
					
				
				//}
					
			
			
				
			for(;;)
			{
				System.out.println("creating socket");
				Socket s = ss.accept();
				System.out.println("client port is: " + ss.getLocalPort());
				clientAddress = ss.getInetAddress();
				System.out.println("client address is: " + clientAddress.toString());	
				
				System.out.println("socket created");
				System.out.println("set default proxy");
				Proxy.setDefaultProxy("127.0.0.1", port);
				System.out.println("creating socks socket");
				
				//create some thread
				s = new SocksSocket("127.0.0.1", 50351);
				
				//s.setKeepAlive(true);
				System.out.println("socks socket created");

				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				PrintWriter out = new PrintWriter(s.getOutputStream());
				
				String line;
				while((line = in.readLine()) != null) 
				{
					if (line.length() == 0) break;
					out.print(line + "\n");
					System.out.println(line);
				}
				
				out.close(); 
				in.close(); 
				s.close();
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
			System.err.println("Usage: java SocksMirror <port>");
		}*/
	}

}
