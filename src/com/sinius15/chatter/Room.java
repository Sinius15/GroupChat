package com.sinius15.chatter;

import java.util.ArrayList;

public class Room {
	
	private String name, id;
	private ArrayList<Message> messages = new ArrayList<>();
	private ArrayList<Client> clients = new ArrayList<>();
	
	public Room(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	
	
}
