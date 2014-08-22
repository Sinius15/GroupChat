package com.sinius15.chatter.replyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.sinius15.chatter.Chatter;

/**
 * This class will respond to the request made by a requester.
 * @author Sinius15
 * @see www.sinius15.com
 */
public class Replyer extends Thread{

	Socket socket;
	
	PrintWriter out;
	BufferedReader in;
	
	ReplyManager parent;
	
	public Replyer(ReplyManager parent, Socket sok) throws IOException {
		this.parent = parent;
		this.socket = sok;
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		start();
	}
	
	@Override
	public void run() {
		try {
			String request;
			while ((request = in.readLine()) != null) {
				handleRequest(request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				out.close();
				in.close();
				parent.replyers.remove(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleRequest(String request) {
		System.out.println("Got request from " + socket.getInetAddress() + ". Request: " + request);
		if(request.equals("ping"))
			out.println("pong");
		if(request.equals("name"))
			out.println("name:" +  Chatter.getInstance().myName);
	}
	
}
