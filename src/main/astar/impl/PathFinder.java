package main.astar.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import main.astar.bean.AStar;
import main.astar.model.ICoordinate;
import main.astar.model.INode;

public class PathFinder {

	public static void main(String[] args) {
		try (BufferedReader reader =  Files.newBufferedReader(Paths.get("resources/map.txt"))) {
			String line = null;
			int lineNo = 0;
			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				lines.add(line);
				AStar.populateNodes(line, lineNo++);
			}
			INode finalNode = AStar.getBestPath();
			System.out.println("getBestPath ");
			while(finalNode != null){
				ICoordinate position = finalNode.getPosition();
				char[] chars = lines.get(position.getY()).toCharArray();
				chars[position.getX()] = '#';
				lines.set(position.getY(), String.valueOf(chars));
				finalNode = finalNode.getParent();
			}
			
			for(String aLine : lines){
				System.out.println(aLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
