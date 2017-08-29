package main.astar.model;

import java.util.List;
import java.util.Map;

import main.astar.bean.Coordinate;

public interface INode {

	void setCost(char type);
	
	int getCost();

	INode getParent();

	void setParent(INode parent);

	double getHeuristicCost();

	void setHeuristicCost(ICoordinate position);

	int getGCost();

	void setGCost(int gCost);

	int getFullCost();

	void setFullCost();

	ICoordinate getPosition();

	boolean isGoal();
	
	List<INode> getSuccessors(Map<Coordinate ,INode> theMap);
}
