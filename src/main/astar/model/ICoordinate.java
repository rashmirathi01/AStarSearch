package main.astar.model;

import main.astar.bean.Coordinate;

public interface ICoordinate {

	int getX();

	int getY();

	Coordinate[] getSuccessorCoordinates();
}