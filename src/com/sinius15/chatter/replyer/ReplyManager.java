package com.sinius15.chatter.replyer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import com.sinius15.chatter.Chatter;

/**
 * The {@link ReplyManager} handles all the replies. If someone askes somthing 
 * to this program, this ReplyManager will create a suitable response and send 
 * that response the the person who asked. 
 * 
 * This class keeps track of all the open askers and will respond to all of them.
 * 
 * @author Sinius15
 * @see www.sinius15.com
 */
public class ReplyManager implements Runnable{
	
	ServerSocket server;
	
	ArrayList<Replyer> replyers = new ArrayList<>();
	
	public ReplyManager() throws IOException{
		
		server = new ServerSocket(Chatter.CHATTER_PORT);
		
		new Thread(this).start();
	}
	
	public void close(){
		if(server.isClosed())
			return;
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(!server.isClosed()){
			try {
				replyers.add(new Replyer(this, server.accept()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
