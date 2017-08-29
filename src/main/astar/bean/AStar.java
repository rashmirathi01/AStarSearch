package main.astar.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.astar.model.ICoordinate;
import main.astar.model.INode;

public class AStar {

	private static Map<Coordinate ,INode> pathMap = new HashMap<Coordinate, INode>() ;
	private static NodeCostComparator theComparator = new NodeCostComparator();
	private static INode source;
	private static ICoordinate goalPosition;

	public static void populateNodes(String line, int lineNo){
		char[] characters = line.toCharArray();
		for(int x = 0 ; x < characters.length; x++){
			if(characters[x] == '~'){
				continue;
			}
			Coordinate position = new Coordinate(x, lineNo);
			pathMap.put(position, new Node(position, characters[x]));
			if(characters[x] == '@'){
				source = pathMap.get(position);
			}else if(characters[x] == 'X'){
				goalPosition = position;
			}
		}
	}

	public static INode getBestPath() {
		List<INode> closedList = new ArrayList<INode>();
		List<INode> openList = new ArrayList<INode>();
		openList.add(source);
		INode currentNode = null;
		while(!openList.isEmpty()){
			currentNode = Collections.min(openList, theComparator);
			if(currentNode.isGoal()){
				closedList.add(currentNode);
				break;
			}
			List<INode> successors = currentNode.getSuccessors(pathMap);
			for(INode node : successors){
				if(isNodeExistingInListBetter(openList, node.getPosition(), currentNode)
						|| isNodeExistingInListBetter(closedList, node.getPosition(), currentNode)){
					continue;
				}
				node.setParent(currentNode);
				node.setGCost(currentNode.getGCost());
				node.setHeuristicCost(goalPosition);
				node.setFullCost();
				openList.add(node);
			}
			closedList.add(currentNode);
			openList.remove(currentNode);
		}
		return currentNode;
	}

	private static boolean isNodeExistingInListBetter(List<INode> aList, ICoordinate position, INode currentNode) {
		for(INode aNode : aList){
			if(aNode.getPosition() == position){
				if(aNode.getGCost() > (currentNode.getGCost() + aNode.getCost())){
					aList.remove(aNode);
					return false;
				}
				return true;
			}
		}
		return false;
	}




}
