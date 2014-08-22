package com.sinius15.chatter.asker;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.sinius15.chatter.Chatter;

/**
 * This class manages all the request to the different clients. 
 * This class will also keep track of all the people in the group.
 * 
 * @author Sinius15
 * @see www.sinius15.com
 */
public class ClientManager {
	
	ArrayList<Client> clients = new ArrayList<>();
	
	public ClientManager(){
		
	}
	
	public void addClient(String ip){
		try {
			Socket clientSocket = new Socket(ip, Chatter.CHATTER_PORT);
			Client greenBoy = new Client(clientSocket);
			clients.add(greenBoy);
			System.out.println(greenBoy.ping());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
