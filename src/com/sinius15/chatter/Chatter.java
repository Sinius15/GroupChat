package com.sinius15.chatter;

import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Main class
 * 
 * @author Sinius15
 * @see www.sinius15.com
 */
public class Chatter {
	
	ChatFrame frame;
	public static String myName = System.getProperty("user.name");
	public static Room room;
	
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
