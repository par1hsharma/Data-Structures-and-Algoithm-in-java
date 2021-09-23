package Graphs;

import java.util.HashMap;


public class GraphClient {

	public static void main(String[] args) {
		
		Graph graph=new Graph();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 3);
		graph.addEdge("B", "C", 4);
		graph.addEdge("D", "C", 5);
		graph.addEdge("D", "E", 6);
		graph.addEdge("E", "F", 9);
		graph.addEdge("E", "G", 8);
		graph.addEdge("F", "G", 10);
		

		graph.display();
		
		System.out.println(graph.containsEdge("A", "B"));
		System.out.println(graph.containsEdge("A", "C"));
		
		System.out.println(graph.HasPath("A","F", new HashMap<>()));
		
		System.out.println(graph.BFS("A","F"));
		graph.removeEdge("D", "E");
		
		graph.BFT();
		System.out.println(graph.isCyclic());
		
		System.out.println(graph.getAllComponents());
	}
	

}
