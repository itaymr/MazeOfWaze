package gameClient;

import Ex1.StdDraw;
import Server.Game_Server;
import Server.game_service;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.Node;
import gui.Graph_GUI;
import utils.Point3D;

public class MyGameGUI {

	public static void main(String[] args)
	{
		
		game_service game = Game_Server.getServer(20);
		String str = game.getGraph();

	
		DGraph dg = new DGraph();
		dg.init(str);
		
		Graph_Algo algo = new Graph_Algo(dg);
		
		Graph_GUI gui = new Graph_GUI(dg, algo);
		gui.init();
		
	
		for(int i = 0; i < 10; i++)
		{
			System.out.println(dg.getNode(i).getLocation());
		}
		gui.drawGraph();

	}
	

}
