package algorithms;

import java.awt.Color;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.StdDraw;

public class Graph_GUI {
	private  DGraph g;
	private Graph_Algo algo;
	
	public Graph_GUI(DGraph gr, Graph_Algo algo) {
		g = gr;
		this.algo = algo;
	}
	public void init() {
		StdDraw.setCanvasSize(800, 800);
	}
	
	public void remove(Node n)
	{
		double x = n.getLocation().x();
		double y = n.getLocation().y();
		double radius = 0.01;
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.circle(n.getLocation().x(), n.getLocation().y(),radius);
		StdDraw.filledCircle(n.getLocation().x(), n.getLocation().y(),radius);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.setPenRadius(0.001);
		StdDraw.text(x, y + 0.025, Integer.toString(n.getTag()));
		StdDraw.setPenRadius();
	}

	public void drawNode(node_data nd) {
		
		double x = nd.getLocation().x();
		double y = nd.getLocation().y();
		
		double radius = 0.01;
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.circle(x, y,radius);
		StdDraw.filledCircle(x, y,radius);
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.setPenRadius(0.001);
		StdDraw.text(x, y + 0.025, Integer.toString(nd.getKey()));
		StdDraw.setPenRadius();

		
	}

	public void drawEdge(edge_data e) {
		double x0 , x1, y0, y1;
		x0=g.getNode(e.getSrc()).getLocation().x();
		x1=g.getNode(e.getDest()).getLocation().x();
		y0=g.getNode(e.getSrc()).getLocation().y();
		y1=g.getNode(e.getDest()).getLocation().y();
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.004);
		StdDraw.setPenRadius();

		StdDraw.line(x0,y0,x1,y1);	
		StdDraw.setPenColor(Color.YELLOW);
		double x =(( (((x1 + x0)/2)+x1)/2   ) + x1) / 2; 
		double y =(( (((y1 + y0)/2)+y1)/2   ) + y1) / 2; 
		StdDraw.circle(x, y, 0.007);

		StdDraw.filledCircle(x, y, 0.007);
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.003);
		StdDraw.text((x1 + x0)/2, (y1 + y0)/2, Double.toString(e.getWeight()));
		StdDraw.setPenRadius();	
	}
	public void drawGraph() {
		for(node_data nd : g.getV())
		{
			drawNode(nd);
			try {
				for(edge_data e: g.getE(nd.getKey()))
				{
					drawEdge(e);
				}
			}
			catch(NullPointerException e)
			{
				continue;
			}
			
		}
//		while(it.hasNext())
//		{
//			Node curr = (Node) it.next();
//			drawNode(curr);
//			try {
//				for(edge_data e: g.getE(curr.getKey()))
//				{
//					drawEdge((Edge) e);
//				}
//			}
//			catch(NullPointerException e)
//			{
//				continue;
//			}
//		}




	}
	public void colorRoute(List<node_data> shortest) {
		if(shortest.isEmpty())
		{
			return;
		}
		for(node_data nd : shortest)
		{
			drawNodeColorful(nd);
			try {
				for(edge_data e: g.getE(nd.getKey()))
				{
					drawEdgeColorful(e);
				}
			}
			catch(NullPointerException e)
			{
				continue;
			}
		
	}
}
	private void drawEdgeColorful(edge_data e) {
		double x0 , x1, y0, y1;
		x0=g.getNode(e.getSrc()).getLocation().x();
		x1=g.getNode(e.getDest()).getLocation().x();
		y0=g.getNode(e.getSrc()).getLocation().y();
		y1=g.getNode(e.getDest()).getLocation().y();
		StdDraw.setPenColor(Color.PINK);
		StdDraw.setPenRadius(0.004);
		StdDraw.setPenRadius();

		StdDraw.line(x0,y0,x1,y1);	
		StdDraw.setPenColor(Color.YELLOW);
		double x =(( (((x1 + x0)/2)+x1)/2   ) + x1) / 2; 
		double y =(( (((y1 + y0)/2)+y1)/2   ) + y1) / 2; 
		StdDraw.circle(x, y, 0.007);

		StdDraw.filledCircle(x, y, 0.007);
		StdDraw.setPenColor(Color.PINK);
		StdDraw.setPenRadius(0.003);
		StdDraw.text((x1 + x0)/2, (y1 + y0)/2, Double.toString(e.getWeight()));
		StdDraw.setPenRadius();			
	}
	private void drawNodeColorful(node_data nd) {
		
		
		double x = nd.getLocation().x();
		double y = nd.getLocation().y();
		
		double radius = 0.01;
		StdDraw.setPenColor(Color.PINK);
		StdDraw.circle(x, y,radius);
		StdDraw.filledCircle(x, y,radius);
		StdDraw.setPenColor(Color.PINK);
		StdDraw.setPenRadius(0.1);
		StdDraw.text(x, y + 0.025, Integer.toString(nd.getKey()));
		StdDraw.setPenRadius();
	}
	}