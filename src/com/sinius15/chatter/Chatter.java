package com.sinius15.chatter;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sinius15.chatter.asker.ClientManager;
import com.sinius15.chatter.replyer.ReplyManager;
import com.sinius15.chatter.ui.ChatFrame;

/**
 * Main class
 * 
 * @author Sinius15
 * @see www.sinius15.com
 */
public class Chatter {
	
	public static final int CHATTER_PORT = 4447;
	
	ChatFrame frame;
	ReplyManager replyer;
	ClientManager clients;
	
	public static String myName = System.getProperty("user.name");
	
	public Chatter() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ChatFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			replyer = new ReplyManager();
			clients = new ClientManager();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void Connect(String ip){
		
	}
	
	public static String getStatusInfo() {
		String ip = "unknown";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("Your name is " + myName + System.lineSeparator());
		builder.append("Your current ip is " + ip + System.lineSeparator());

		return builder.toString();
	}
	
	public static void main(String[] args) {
		new Chatter();
	}
	
}
