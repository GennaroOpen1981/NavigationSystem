package com.gomspace.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.gomspace.rest.model.Coordinates;
import com.gomspace.rest.model.MachinePositionOnTheGridMem;

public final class Utils {
	//this method print all the elements inside the black domain list, the rest of the squares are white
	//Save the list of black squares into the output.txt files
	public static void printElemntFromBalckDomain(final MachinePositionOnTheGridMem positionMemory) throws IOException {
		Set<Coordinates> set = positionMemory.getState().keySet();
		Object[] cordArray = set.toArray();
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
		writer.write("******** BLACK DOMAIN SQUARES ********\n");
		System.out.println("******** BLACK DOMAIN SQUARES ********\n");

		for(int i = 0; i < cordArray.length; i++)
		{
			writer.write("Element : "+ (i+1) +"\n");
			System.out.println("Element : "+ (i+1) +"\n");
			writer.write("Coordinate X : "+ ((Coordinates)cordArray[i]).getX()+"\n");
			System.out.println("Coordinate X : "+ ((Coordinates)cordArray[i]).getX()+"\n");
			writer.write("Coordinate Y : "+ ((Coordinates)cordArray[i]).getY() +"\n");
			System.out.println("Coordinate Y : "+ ((Coordinates)cordArray[i]).getY() +"\n");
			writer.write("***************************************\n");
			System.out.println("***************************************\n");

		}
		writer.write("*** The Other squares of the infinite space are white *****\n");
		System.out.println("*** The Other squares of the infinite space are white *****\n");
		writer.close();
	}

	public static MachinePositionOnTheGridMem removeElemntFromBalckDomain(MachinePositionOnTheGridMem positionMemory, Coordinates checkingCoord) {
		Set<Coordinates> set = positionMemory.getState().keySet();
		Iterator<Coordinates> it = set.iterator();
		while(it.hasNext())
		{
			Coordinates cordCheck = it.next();
			if(cordCheck.getX() == checkingCoord.getX() && cordCheck.getY() == checkingCoord.getY())
			{
				it.remove();
			}

		}
		return positionMemory;
	}
	//this method check if the current position is BLACK or not
	public static boolean checkElementIntoBalckDomain(MachinePositionOnTheGridMem positionMemory, Coordinates checkingCoord) {
		Set<Coordinates> set = positionMemory.getState().keySet();
		Iterator<Coordinates> it = set.iterator();
		boolean result = false;
		while(it.hasNext())
		{
			Coordinates cordCheck = it.next();
			if(cordCheck.getX() == checkingCoord.getX() && cordCheck.getY() == checkingCoord.getY())
			{
				return true;
			}
			else
			{
				result = false;
			}
		}
		return result;
	}

}
