package algorithms;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{


	private DGraph dgraph;

	Queue<node_data> nodeQueue = new LinkedList<>();

	@Override
	public void init(graph g) {

		dgraph = (DGraph) g;
	}

	
	
	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub

	}

	/**
	 * Uses a non-recursive implementation of depth-first-search to mark all connected nodes.
	 */



	public boolean DFS(Node nd)
	{

		Stack<node_data> stack = new Stack<node_data>();
		stack.push(nd);

		while(!stack.isEmpty())
		{
			Node w = (Node) stack.pop();

			if(w.getTag() == 0) // the node has not been seen before
			{
				w.setTag(1);
				//travel to all of its connections
				try
				{
					Iterator<edge_data> it = dgraph.getE(w.getKey()).iterator();

				}
				catch(NullPointerException e){
					return false;
				}
				Iterator<edge_data> it = dgraph.getE(w.getKey()).iterator();
				while(it.hasNext())
				{
					Edge next = (Edge) it.next();
					stack.push(dgraph.getNode(next.getDest()));
				}

			}

		}

		for(node_data n: dgraph.getV())
		{
			if(n.getTag() == 0)
			{
				return false;
			}
			n.setTag(0); // resets the node
		}

		return true;
	}

	public boolean isConnected() {

		
		Collection<node_data> col = dgraph.getV();
		
		System.out.println(dgraph.getV());
		return DFS((Node) col.iterator().next());
	}









	//	
	//	Stack<node_data> stack = new Stack<node_data>();
	//	
	//	stack.push(dgraph.getV().iterator().next()); // push first node
	//	
	//	while(!stack.isEmpty())
	//	{
	//		Node v = (Node)stack.pop();
	//		if(v.getTag() == 0)
	//		{
	//			v.setTag(1);
	//			
	//			for(node_data w: dgraph.getV())
	//			{
	//				stack.push(w);
	//			}
	//		}
	//  }

	//	for(node_data nd: dgraph.getV())
	//	{
	//		if(nd.getTag() == 0)
	//		{
	//			return false;
	//		}
	//		nd.setTag(0); // resets the node
	//	}
	//	
	//	
	//	return true;
	//	




	@Override
	public double shortestPathDist(int src, int dest) {
		this.Dijkstra(src);
		
		return dgraph.getNode(dest).getWeight();
		
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		
				
		
		return myList;
		
	}

	private Node min(LinkedList<Node> adjacentNodes) {
		Iterator<node_data> it = dgraph.getV().iterator();
		Node min = null;
		while(it.hasNext())
		{
			Node temp = (Node) it.next();
			if(min.getWeight() > temp.getWeight())
			{
				min = temp;
			}
			
		}
		
		return min;
	}



	public Node min(Collection<node_data> mySet)
	{
		
		
		Iterator<node_data> it = mySet.iterator();
		Node min = (Node) it.next();
		while(it.hasNext())
		{
			Node temp = (Node) it.next();
			if(temp.getWeight() < min.getWeight())
			{
				min = temp;
			}	
		}
		
		return min;
	}

	public void Dijkstra(int src)
	{

		//initialization

		Iterator<node_data> it = dgraph.getV().iterator();

		while(it.hasNext())
		{
			Node temp = (Node) it.next();
			if(temp.getKey() == src)
			{
				temp.setWeight(0);
			}
			else
			{
				temp.setWeight(Double.MAX_VALUE);
			}
		}

		Node optimal = null;
		LinkedList<node_data> mySet = new LinkedList<node_data>();
		
		mySet.addAll(dgraph.getV());
		String best;
		while(!mySet.isEmpty())
		{

			Node u = min(mySet);
			mySet.remove(u);

			try {
				dgraph.adjacentNodes(u);
			}
			catch(NullPointerException e){
				continue;
			}
			for(Node adj: dgraph.adjacentNodes(u))
			{
				if(!mySet.contains(adj))
				{
					continue;
				}
				double alt = u.getWeight() + dgraph.length(u, adj);
				if(alt < adj.getWeight())
				{
					adj.setWeight(alt);
				}


			}



		}


	}


	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
