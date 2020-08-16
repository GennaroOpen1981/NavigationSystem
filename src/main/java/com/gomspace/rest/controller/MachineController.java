package com.gomspace.rest.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomspace.rest.model.Colors;
import com.gomspace.rest.model.Coordinates;
import com.gomspace.rest.model.Facing;
import com.gomspace.rest.model.MachinePositionOnTheGrid;
import com.gomspace.rest.model.MachinePositionOnTheGridMem;
import com.gomspace.utils.Utils;

@RestController
@RequestMapping(path = "/machineSimulation")
public class MachineController 
{
	@PutMapping(path= "/")
	public void doSteps(@RequestBody int numOfSteps) 
			throws Exception 
	{       
		int posX;
		int posY;
		MachinePositionOnTheGridMem historyOnTheGrid = new MachinePositionOnTheGridMem();
		System.out.println("Starting conditions : position into the GRID (0,0), facing to the RIGHT");
		MachinePositionOnTheGrid machinePositionOnTheGrid = new MachinePositionOnTheGrid();
		machinePositionOnTheGrid.coordinates.setX(0);
		machinePositionOnTheGrid.coordinates.setY(0);
		machinePositionOnTheGrid.setFace(Facing.RIGHT);

		for (int i = 0; i < numOfSteps; i++) {
			System.out.println("Step number:" +(i+1)+ "\n");
			Facing next = null;
			posX = machinePositionOnTheGrid.coordinates.getX();
			posY = machinePositionOnTheGrid.coordinates.getY();
			Coordinates previousCord = new Coordinates(posX, posY);
			//check if the machine is on a Black square element
			Coordinates checkingCoord = new Coordinates(machinePositionOnTheGrid.coordinates.getX(),machinePositionOnTheGrid.coordinates.getY());
			if(Utils.checkElementIntoBalckDomain(historyOnTheGrid,checkingCoord))
			{
				System.out.println("Move 90° Counter Clock Wise");
				Utils.removeElemntFromBalckDomain(historyOnTheGrid, checkingCoord);

				if (machinePositionOnTheGrid.getFace() == Facing.RIGHT) 
				{
					next = Facing.UP;
					int newPosY = previousCord.getY() + 1;
					machinePositionOnTheGrid.coordinates.setY(newPosY);
				}
				else if (machinePositionOnTheGrid.getFace() == Facing.DOWN) 
				{
					next = Facing.RIGHT;
					int newPosX = previousCord.getX() + 1;
					machinePositionOnTheGrid.coordinates.setX(newPosX);
				}
				else if (machinePositionOnTheGrid.getFace() == Facing.LEFT) 
				{
					next = Facing.DOWN;
					int newPosY = previousCord.getY() - 1;
					machinePositionOnTheGrid.coordinates.setY(newPosY);
				}
				else if (machinePositionOnTheGrid.getFace() == Facing.UP) 
				{
					next = Facing.LEFT;
					int newPosX = previousCord.getX() - 1;
					machinePositionOnTheGrid.coordinates.setX(newPosX);
				}
			}
			else 
			{
				System.out.println("Move 90° Clock Wise");
				historyOnTheGrid.getState().put(previousCord, Colors.BLACK_SQUARE);

				if (machinePositionOnTheGrid.getFace() == Facing.RIGHT) 
				{
					next = Facing.DOWN;
					int newPosY = previousCord.getY() - 1;
					machinePositionOnTheGrid.coordinates.setY(newPosY);
				}
				else if (machinePositionOnTheGrid.getFace() == Facing.DOWN) 
				{
					next = Facing.LEFT;
					int newPosX = previousCord.getX() - 1;
					machinePositionOnTheGrid.coordinates.setX(newPosX);
				}
				else if (machinePositionOnTheGrid.getFace() == Facing.LEFT) 
				{
					next = Facing.UP;
					int newPosY = previousCord.getY() + 1;
					machinePositionOnTheGrid.coordinates.setY(newPosY);
				}
				else if (machinePositionOnTheGrid.getFace() == Facing.UP) 
				{
					next = Facing.RIGHT;
					int newPosX = previousCord.getX() + 1;
					machinePositionOnTheGrid.coordinates.setX(newPosX);
				}

			}
			machinePositionOnTheGrid.setFace(next);
			System.out.println("Actual position : X = " + machinePositionOnTheGrid.coordinates.getX() + "; Y = " + machinePositionOnTheGrid.coordinates.getY()+ "\n");
			System.out.println("Actual face = " + machinePositionOnTheGrid.getFace() + "\n");

		}
		Utils.printElemntFromBalckDomain(historyOnTheGrid);
	}
}
