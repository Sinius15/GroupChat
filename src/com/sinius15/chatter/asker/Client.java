package com.sinius15.chatter.asker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	
	public Client(Socket clientSocket) throws IOException{
		this.socket = clientSocket;
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	private String getInputString() throws IOException{
		return in.readLine();
	}
	
	public boolean ping(){
		try {
			out.println("ping");
			String response = getInputString();
			return response.equals("pong");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void close() throws IOException {
		socket.close();
		out.close();
		in.close();
	}
	
}
