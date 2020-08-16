package com.gomspace.rest.model;

import java.util.HashMap;
//this class represent the history of the switching White/Black squares with coordinates
public class MachinePositionOnTheGridMem {
	private HashMap<Coordinates, Colors> state = new HashMap<Coordinates, Colors>();

	public HashMap<Coordinates, Colors> getState() {
		return state;
	}

	public void setState(HashMap<Coordinates, Colors> state) {
		this.state = state;
	}
}
