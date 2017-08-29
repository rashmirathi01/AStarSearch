package main.astar.bean;

import main.astar.model.ICoordinate;

public class Coordinate implements ICoordinate {
	private int x;
	private int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	/* (non-Javadoc)
	 * @see main.astar.bean.ICoordinate#getX()
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/* (non-Javadoc)
	 * @see main.astar.bean.ICoordinate#getY()
	 */
	@Override
	public int getY() {
		return y;
	}

	public Coordinate[] getSuccessorCoordinates(){
		Coordinate[] successors = new Coordinate[8];
		successors[0] = new Coordinate(x-1, y-1);
		successors[1] = new Coordinate(x-1, y);
		successors[2] = new Coordinate(x-1, y+1);
		successors[3] = new Coordinate(x, y-1);
		successors[4] = new Coordinate(x, y+1);
		successors[5] = new Coordinate(x+1, y-1);
		successors[6] = new Coordinate(x+1, y);
		successors[7] = new Coordinate(x+1, y+1);
		return successors;
	}
	
	public boolean equals(Object o){
		if(o.getClass() != Coordinate.class)
			return false;
		Coordinate position = (Coordinate)o;
		return this.x == position.x && this.y == position.y;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
}
