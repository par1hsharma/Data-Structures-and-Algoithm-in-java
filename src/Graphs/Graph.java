package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVertex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vrt = new Vertex();
		vtces.put(vname, vrt);
	}

	public int numEdge() {

		ArrayList<String> list = new ArrayList<>(vtces.keySet());
		int count = 0;
		for (String val : list) {
			Vertex vtr = vtces.get(val);
			count = count + vtr.nbrs.size();
		}
		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);

		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {

			Vertex nbrsVtx = vtces.get(key);
			nbrsVtx.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}

	public void display() {

		System.out.println("------------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		for (String key : keys) {

			Vertex vtx = vtces.get(key);
			System.out.println(key + " " + vtx.nbrs);
		}
		System.out.println("-----------------");
	}

	public boolean HasPath(String vname1, String vname2, HashMap<String, Boolean> map) {

		map.put(vname1, true);

		if (containsEdge(vname1, vname2))
			return true;

		Vertex vtx = vtces.get(vname1);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {
			if (!map.containsKey(key) && HasPath(key, vname2, map)) {
				return true;
			}
		}
		return false;
	}

	class pair {

		String vname;
		String psf;
	}

//	dst=destination
	public boolean BFS(String src, String dst) { // BFS is similar to level order traversal of tree

		//BFS gives the smallest path DFS doesnt gives the smallest path
		
		LinkedList<pair> q = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		pair sp = new pair();

		sp.vname = src;
		sp.psf = src;

		q.addLast(sp);

		while (!q.isEmpty()) {

			pair rp = q.removeFirst();

			if (processed.containsKey(rp.vname))
				continue;

			// put removed pair in hashMap to handle infinite recursion
			processed.put(rp.vname, true);

			// check for direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}
			// check for the nbrs
			Vertex vtx = vtces.get(rp.vname);
			ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

			for (String key : keys) {
				if (!processed.containsKey(key)) {
					pair np = new pair();
					np.vname = key;
					np.psf = rp.psf + key;

					q.addLast(np);
				}
			}

		}
		return false;
	}

	public boolean DFS(String src, String dst) { // DFS is similar to pre/post order traversal of tree

		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		pair sp = new pair();

		sp.vname = src;
		sp.psf = src;

		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname))
				continue;

			// put removed pair in hashMap to handle infinite recursion
			processed.put(rp.vname, true);

			// check for direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}
			// check for the nbrs
			Vertex vtx = vtces.get(rp.vname);
			ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

			for (String key : keys) {
				if (!processed.containsKey(key)) {
					pair np = new pair();
					np.vname = key;
					np.psf = rp.psf + key;

					stack.addFirst(np);
				}
			}

		}
		return false;
	}

//	Breadth First Traversal
	public void BFT() { // BFS is similar to level order traversal of tree

		LinkedList<pair> q = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keyss = new ArrayList<>(vtces.keySet());

//		for disconncted graphs also it will print
		for (String keysss : keyss) {
			
			if(processed.containsKey(keysss)) {
				continue;
			}

			pair sp = new pair();

			sp.vname = keysss;
			sp.psf = keysss;

			q.addLast(sp);

			while (!q.isEmpty()) {

				pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// put removed pair in hashMap to handle infinite recursion
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname+" via "+rp.psf);

				// check for the nbrs
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					if (!processed.containsKey(key)) {
						pair np = new pair();
						np.vname = key;
						np.psf = rp.psf + key;

						q.addLast(np);
					}
				}

			}

		}

	}
	public void DFT() { 

		LinkedList<pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keyss = new ArrayList<>(vtces.keySet());

//		for disconncted graphs also it will print
		for (String keysss : keyss) {
			
			if(processed.containsKey(keysss)) {
				continue;
			}

			pair sp = new pair();

			sp.vname = keysss;
			sp.psf = keysss;

			stack.addFirst(sp);

			while (!stack.isEmpty()) {

				pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// put removed pair in hashMap to handle infinite recursion
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname+" via "+rp.psf);

				// check for the nbrs
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					if (!processed.containsKey(key)) {
						pair np = new pair();
						np.vname = key;
						np.psf = rp.psf + key;

						stack.addFirst(np);
					}
				}

			}

		}

	}
	
	public boolean isCyclic() { // BFS is similar to level order traversal of tree

		LinkedList<pair> q = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keyss = new ArrayList<>(vtces.keySet());

//		for disconncted graphs also it will print
		for (String keysss : keyss) {
			
			if(processed.containsKey(keysss)) {
				continue;
			}

			pair sp = new pair();

			sp.vname = keysss;
			sp.psf = keysss;

			q.addLast(sp);

			while (!q.isEmpty()) {

				pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname)) // for checking cyclic feature
					return true;

				// put removed pair in hashMap to handle infinite recursion
				processed.put(rp.vname, true);
				
		

				// check for the nbrs
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					if (!processed.containsKey(key)) {
						pair np = new pair();
						np.vname = key;
						np.psf = rp.psf + key;

						q.addLast(np);
					}
				}

			}

		}
		return false;

	}
	public boolean isConnected() { // BFS

		int flag=0;
		LinkedList<pair> q = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keyss = new ArrayList<>(vtces.keySet());

//		for disconncted graphs also it will print
		for (String keysss : keyss) {
			
			if(processed.containsKey(keysss)) {
				continue;
			}
			
			flag++; // if we are coming in this region again it means graph is disconnected.flag value is denoting the number of component

			pair sp = new pair();

			sp.vname = keysss;
			sp.psf = keysss;

			q.addLast(sp);

			while (!q.isEmpty()) {

				pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// put removed pair in hashMap to handle infinite recursion
				processed.put(rp.vname, true);
				
				

				// check for the nbrs
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					if (!processed.containsKey(key)) {
						pair np = new pair();
						np.vname = key;
						np.psf = rp.psf + key;

						q.addLast(np);
					}
				}

			}

		}
		if(flag>=2) {
			return false;
		}else {
			return true;
		}

	}
	
	public boolean isTree() { // Tree is an Acyclic and connected graph 
		return !isCyclic() && isConnected(); // Tree will have n-1 edges always
		
	}
	public ArrayList<ArrayList<String>> getAllComponents() { 

		ArrayList<ArrayList<String>> ans= new ArrayList<>();
		
		LinkedList<pair> q = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> keyss = new ArrayList<>(vtces.keySet());

//		for disconncted graphs also it will print
		for (String keysss : keyss) {
			
			if(processed.containsKey(keysss)) {
				continue;
			}
			//for new component create arraylist
			ArrayList<String> subans=new ArrayList<>();

			pair sp = new pair();

			sp.vname = keysss;
			sp.psf = keysss;

			q.addLast(sp);

			while (!q.isEmpty()) {

				pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname))
					continue;

				// put removed pair in hashMap to handle infinite recursion
				processed.put(rp.vname, true);
				
				//put in subans
				subans.add(rp.vname);

				// check for the nbrs
				Vertex vtx = vtces.get(rp.vname);
				ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

				for (String key : keys) {
					if (!processed.containsKey(key)) {
						pair np = new pair();
						np.vname = key;
						np.psf = rp.psf + key;

						q.addLast(np);
					}
				}

			}
			//add componet arraylist in ans arraylist
			ans.add(subans);
		}
		return ans;
	}

}








