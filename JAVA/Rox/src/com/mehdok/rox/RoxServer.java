package com.mehdok.rox;

import java.net.*;
import java.io.*;

/**
 * 
 * @author MEHDOK
 * ROX Server Implementation, it create a listening socket and wait for 
 * client connection, then run a new thread for sending and reciving data
 *
 */
public class RoxServer 
{
	
	private static String desHostAddr; //create a method for retriving host address, i can use URL Class instead of String
	private static int desHostPort; //create some method for retriving host port
	private static int serverPort; //it can be  a constant defined in seperate file with static modifier
		
	public static void main(String[] args)
	{
		startServer();
	}
	
	private static void startServer()
	{
		try 
		{
			ServerSocket listeningServerSocket = new ServerSocket(serverPort);
			
			while(true)
			{
				Socket serverClientSocket/*clientSocket   serverClientSocket*/ = listeningServerSocket.accept();
				
				//InputStream clientToServer/*serverInput*/ = serverClientSocket.getInputStream();
				//OutputStream serverToClient/*serverOutput*/ = serverClientSocket.getOutputStream();

				//may be find host address and port goes here
				
				Socket serverHostSocket/*hostSocket*/ = new Socket(desHostAddr, desHostPort);
				
				//InputStream hostToServer/*hostInput*/ = serverHostSocket.getInputStream();
				//OutputStream serverToHost/*hostOutput*/ = serverHostSocket.getOutputStream();
				
				//may be a new thread
				Thread sendDataThread = new Thread(new sendData(serverClientSocket, serverHostSocket));
				sendDataThread.start();
				/*
				int readedByte;
				byte[] clientOutBuffer = new byte[2048];
				while((readedByte = clientToServer.read(clientOutBuffer)) != -1)
				{
					serverToHost.write(clientOutBuffer, 0, readedByte);
					serverToHost.flush();
				}*/
				
				//may be a new thread
				Thread reciveDataThread = new Thread(new reciveData(serverClientSocket, serverHostSocket));
				reciveDataThread.start();
				/*
				int readedByte2;
				byte[] clientInputBuffer = new byte[4096];
				while((readedByte2 = hostToServer.read(clientInputBuffer)) != -1)
				{
					serverToClient.write(clientInputBuffer, 0, readedByte2);
					serverToClient.flush();
				}*/
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * 
 * @author MEHDOK
 * this class create a new thread for sending data from client to host
 *
 */
class sendData implements Runnable
{
	private Socket server_client_socket;
	private Socket server_host_socket;
	
	private InputStream clientToServer;
	//private OutputStream serverToClient;
	
	//private InputStream hostToServer;
	private OutputStream serverToHost;
	
	sendData(Socket scs, Socket shs)
	{
		server_client_socket = scs;
		server_host_socket = shs;
		
		try 
		{
			clientToServer/*serverInput*/ = server_client_socket.getInputStream();
			//serverToClient/*serverOutput*/ = server_client_socket.getOutputStream();
			//hostToServer/*hostInput*/ = server_host_socket.getInputStream();
			serverToHost/*hostOutput*/ = server_host_socket.getOutputStream();

		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	private InputStream client_to_server;
	private OutputStream server_to_host;
	sendData(InputStream cts, OutputStream sth)
	{
		client_to_server = cts;
		server_to_host = sth;
	}
	*/
	
	public void run()
	{
		int readedByte;
		byte[] clientOutBuffer = new byte[2048];
		try 
		{
			while((readedByte = clientToServer.read(clientOutBuffer)) != -1)
			{
				serverToHost.write(clientOutBuffer, 0, readedByte);
				serverToHost.flush();
			}
			
			server_client_socket.close();
			server_host_socket.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}

/**
 * 
 * @author MEHDOK
 * this class create a new thread for reciving data from host to client
 *
 */
class reciveData implements Runnable
{
	private Socket server_client_socket;
	private Socket server_host_socket;
	
	//private InputStream clientToServer;
	private OutputStream serverToClient;
	
	private InputStream hostToServer;
	//private OutputStream serverToHost;
	
	reciveData(Socket scs, Socket shs)
	{
		server_client_socket = scs;
		server_host_socket = shs;
		
		try 
		{
			//clientToServer/*serverInput*/ = server_client_socket.getInputStream();
			serverToClient/*serverOutput*/ = server_client_socket.getOutputStream();
			hostToServer/*hostInput*/ = server_host_socket.getInputStream();
			//serverToHost/*hostOutput*/ = server_host_socket.getOutputStream();

		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	private InputStream host_to_server;
	private OutputStream server_to_client;
	
	reciveData(InputStream hts, OutputStream stc)
	{
		host_to_server = hts;
		server_to_client = stc;
	}
	*/
	public void run()
	{
		int readedByte;
		byte[] clientInputBuffer = new byte[4096];
		try 
		{
			while((readedByte = hostToServer.read(clientInputBuffer)) != -1)
			{
				serverToClient.write(clientInputBuffer, 0, readedByte);
				serverToClient.flush();
			}
			
			server_client_socket.close();
			server_host_socket.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
