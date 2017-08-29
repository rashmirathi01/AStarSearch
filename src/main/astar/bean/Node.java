package main.astar.bean;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import main.astar.model.ICoordinate;
import main.astar.model.INode;

public class Node implements INode{
	
	private ICoordinate position;
	private int cost;
	private int heuristicCost;
	private int gCost;
	private int fullCost;
	private INode parent;
	private boolean isGoal;
	
	public Node(Coordinate position, char type) {
		this.position = position;
		setCost(type);
	}

	@Override
	public ICoordinate getPosition() {
		return position;
	}
	
	/* (non-Javadoc)
	 * @see main.astar.bean.INode#getCost(char)
	 */
	@Override
	public void setCost(char type) {
		switch (type) {
			case '*': cost = 2;break;
			case '^': cost = 3;break;
			case 'X': isGoal = true;
			default: cost = 1;break;
		}
	}
	
	@Override
	public int getCost() {
		return cost;
	}
	/* (non-Javadoc)
	 * @see main.astar.bean.INode#getParent()
	 */
	@Override
	public INode getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see main.astar.bean.INode#setParent(main.astar.bean.INode)
	 */
	@Override
	public void setParent(INode parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see main.astar.bean.INode#getHeuristicCost()
	 */
	@Override
	public double getHeuristicCost() {
		return heuristicCost;
	}

	/* (non-Javadoc)
	 * @see main.astar.bean.INode#setHeuristicCost(int, int)
	 */
	@Override
	public void setHeuristicCost(ICoordinate position) {
		heuristicCost = Math.abs(this.position.getX() - position.getX())+
				Math.abs(this.position.getY() - position.getY());
	}

	/* (non-Javadoc)
	 * @see main.astar.bean.INode#getGCost()
	 */
	@Override
	public int getGCost() {
		return gCost;
	}

	/* (non-Javadoc)
	 * @see main.astar.bean.INode#setGCost(int)
	 */
	@Override
	public void setGCost(int gCost) {
		this.gCost = gCost + cost;
	}

	/* (non-Javadoc)
	 * @see main.astar.bean.INode#getFullCost()
	 */
	@Override
	public int getFullCost() {
		return fullCost;
	}

	/* (non-Javadoc)
	 * @see main.astar.bean.INode#setFullCost()
	 */
	@Override
	public void setFullCost() {
		this.fullCost = this.gCost + this.heuristicCost;
	}
	

	public boolean isGoal(){
		return this.isGoal;
	}
	
	public List<INode> getSuccessors(Map<Coordinate ,INode> theMap){
		List<INode> successors = new ArrayList<INode>();
		Coordinate[] successorCoordinates = this.position.getSuccessorCoordinates();
		for(Coordinate c : successorCoordinates){
			if(theMap.containsKey(c)){
				successors.add(theMap.get(c));
			}
		}
		return successors;
	}
	
	public String toString(){
		String strValue = null;
		strValue = "{("+this.position.getX()+","+this.position.getY()+"), ";
		if(this.parent != null)
			strValue = strValue.concat("Parent : ("+this.parent.getPosition().getX()+", "+this.parent.getPosition().getY()+")}");
		return strValue;
	}
	
	public boolean equals(Object o){
		if(o.getClass() != Node.class)
			return false;
		Node node = (Node)o;
		return this.position == node.position;
	}
	
}

class NodeCostComparator implements Comparator<INode> {
	public int compare(INode a, INode b) {
		if (a.getFullCost() == b.getFullCost()) {
			return (int) (a.getGCost() - b.getGCost());
		} else {
			return (int) (a.getFullCost() - b.getFullCost());
		}
	}
}


