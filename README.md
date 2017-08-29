# A Star Search
Introduction
================
A* is an informed search algorithm, or a best-first search, meaning that it solves problems by searching among all possible paths to the solution (goal) for the one that incurs the smallest cost (least distance travelled, shortest time, etc.), and among these paths it first considers the ones that appear to lead most quickly to the solution. It is formulated in terms of weighted graphs: starting from a specific node of a graph, it constructs a tree of paths starting from that node, expanding paths one step at a time, until one of its paths ends at the predetermined goal node.


Input 
===========
A path file

Output
==========
Optimal path printed on output stream

Steps to execute
======================
1. Put the path map inside resources folder
2. Modify file path in src.main.astar.impl.PathFinder.java
3. Run as Java Application
