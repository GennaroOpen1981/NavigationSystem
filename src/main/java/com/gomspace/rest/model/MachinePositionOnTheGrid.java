package com.gomspace.rest.model;
//this class represent the machine in this moment with cordinates, facing and color 
public class MachinePositionOnTheGrid {
	private Facing face;
	public Coordinates coordinates;
	public Colors color;

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}

	public Facing getFace() 
	{
		return face;
	}

	public void setFace(Facing face) 
	{
		this.face = face;
	}


	public MachinePositionOnTheGrid() 
	{
		this.coordinates = new Coordinates();
	}



}
