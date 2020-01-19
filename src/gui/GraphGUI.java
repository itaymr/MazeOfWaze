package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class GraphGUI extends JFrame implements ActionListener {

	private graph gr;
	private JPanel panel;
	
	public int width=800, height=800;
	public GraphGUI(DGraph dgraph)
	{
		dgraph.addListener(this);
		this.gr = dgraph;
	}
	
	
	
	public void init(DGraph dgraph)
	{
		panel = new JPanel();
		this.setContentPane(panel);
		this.getContentPane().setVisible(true);
		this.setSize(width, height);;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
		
		
	}
	
	public void paint(Graphics d)
	{
		super.paint(d);
		d.drawLine(5, 5, 5, 5);
		Collection<node_data> nodes = gr.getV();
		for(node_data nd : nodes)
		{
			System.out.println("gets here");

			double x = nd.getLocation().x();
			double y = nd.getLocation().x();

			d.fillOval((int)x/2, (int)y/2, 5, 5);
			try {
				for(edge_data e: gr.getE(nd.getKey()))
				{
					double x0 , x1, y0, y1;
					x0=gr.getNode(e.getSrc()).getLocation().x();
					x1=gr.getNode(e.getDest()).getLocation().x();
					y0=gr.getNode(e.getSrc()).getLocation().y();
					y1=gr.getNode(e.getDest()).getLocation().y();
					((Graphics2D) d).draw(new Line2D.Double(x0, y0, x1, y1));
					
				}
			}
			catch(NullPointerException e)
			{
				continue;
			}
			
		}
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void update()
	{
		repaint();
	}
}
