package utils;

import java.awt.Color;

import java.util.Iterator;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.edge;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;

public class Graph_GUI {
	private  DGraph g;
	private Graph_Algo algo;

	public Graph_GUI(DGraph gr, Graph_Algo algo) {
		g = gr;
		this.algo = algo;
	}
	public void init() {
		StdDraw.setCanvasSize(1080, 1080);
	}

	public void drawNode(node n) {
		StdDraw.setPenColor(Color.RED);
		StdDraw.circle(n.getLocation().x(), n.getLocation().y(),0.01);
		StdDraw.filledCircle(n.getLocation().x(), n.getLocation().y(),0.01);
	}

	public void drawEdge(edge e) {
		double x0 , x1, y0, y1;
		x0=g.getNode(e.getSrc()).getLocation().x();
		x1=g.getNode(e.getDest()).getLocation().x();
		y0=g.getNode(e.getSrc()).getLocation().y();
		y1=g.getNode(e.getDest()).getLocation().y();
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.line(x0,y0,x1,y1);	
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.circle(((((x1 + x0)/2)+x1)/2), (((y1+y0)/2)+y1)/2, 0.005);
		StdDraw.filledCircle((((x1 + x0)/2)+x1)/2, (((y1+y0)/2)+y1)/2, 0.005);
	}
	public void drawGraph() {
		Iterator<node_data> it = g.getV().iterator();
		while(it.hasNext())
		{
			node curr = (node) it.next();
			drawNode(curr);
			try {
				for(edge_data e: g.getE(curr.getKey()))
				{
					drawEdge((edge) e);
				}
			}
			catch(NullPointerException e)
			{
				continue;
			}
		}




	}
}