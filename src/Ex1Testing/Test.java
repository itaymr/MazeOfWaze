package Ex1Testing;

import java.util.LinkedList;
import java.util.List;

import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.Polynom;
import Ex1.Range;
import algorithms.Graph_Algo;
import algorithms.Graph_GUI;
import dataStructure.DGraph;
import dataStructure.Edge;
import dataStructure.Node;
import dataStructure.node_data;
import utils.Point3D;

public class Test {

	
	public static void main(String[] args)
	{
		testGraph();
		testGUI();
		testGUIRandom();
//		testFunc();
//		testmult();
//		testdiv();
//		testplus();
//		testcomp();
	}
	
	
	
	
	private static void testGUIRandom() {

		DGraph dg = new DGraph();
		Graph_Algo algo = new Graph_Algo();
		
		algo.init(dg);
		Graph_GUI gui = new Graph_GUI(dg, algo);

		for(int i = 0; i<100; i++)
		{
			Node n = new Node(new Point3D(Math.random(), Math.random(), Math.random()*5));
			dg.addNode(n);
		}
		double max, min;
		min = 0;
		int randomx, randomy, randomWeight;
		for(int i = 0; i<100; i++)
		{
			max = i;
			randomx = (int) ( (Math.random() * ((max - min) + 1)) + min);
			randomy = (int) ( (Math.random() * ((max - min) + 1)) + min);
			randomWeight = (int) ( (Math.random() * ((20 - 1) + 1)) + 1);
			
			if(Math.random() > 0.5)
			{
				dg.connect(randomx, randomy, randomWeight);
			}
			if(i % 1000 == 0)
			{
				System.out.println(i);
			}
		}
		
		algo.Dijkstra(0);
		
		dg.connect(1, 2, 3);
		dg.connect(2, 3, 3);
		dg.connect(3, 4, 3);

		
	//	List<node_data> shortest = algo.shortestPath(0, 4);
	

		gui.init();
		gui.drawGraph();

		
		
		//gui.drawGraph();
	}


	private static void testGUI() {
		
		DGraph dg = new DGraph();
		Graph_Algo al = new Graph_Algo();
		al.init(dg);
		//
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();

		Point3D p1 = new Point3D(0.2,0.3,0.4);
		Point3D p2 = new Point3D(0.1,0.2,0.3);
		Point3D p3 = new Point3D(0.5,0.7,0.9);
		Point3D p4 = new Point3D(0.3,0.5,0.7);
		
		n1.setLocation(p1);
		n2.setLocation(p2);
		n3.setLocation(p3);
		n4.setLocation(p4);

		dg.addNode(n1);
		dg.addNode(n2);
		dg.addNode(n3);
		dg.addNode(n4);

		dg.connect(n1.getKey(), n2.getKey(), 3);
		dg.connect(n1.getKey(), n3.getKey(), 2);
		dg.connect(n2.getKey(), n3.getKey(), 3);
		dg.connect(n2.getKey(), n4.getKey(), 3);
		Graph_GUI gui = new Graph_GUI(dg, al);
		
		gui.drawGraph();
		
		
		
	}


	public static void testGraph()
	{
		DGraph graph = new DGraph();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n5);
		graph.addNode(n6);

		
		

		
		graph.connect(n1.getKey(), n2.getKey(), 2);
		graph.connect(n2.getKey(), n3.getKey(), 2);
		graph.connect(n3.getKey(), n4.getKey(), 2);
		graph.connect(n1.getKey(), n5.getKey(), 1);
		graph.connect(n5.getKey(), n6.getKey(), 1);
		graph.connect(n6.getKey(), n3.getKey(), 1);

		



		System.out.println("n1 is: " + n1.getWeight());
		System.out.println("n2 is: " + n2.getWeight());
		System.out.println("n3 is: " + n3.getWeight());
		
		Graph_Algo ga = new Graph_Algo();
		ga.init(graph);

		ga.Dijkstra(n1.getKey());
		
		System.out.println("n1 is: " + n1.getWeight());
		System.out.println("n2 is: " + n2.getWeight());
		System.out.println("n3 is: " + n3.getWeight());
		System.out.println("n4 is: " + n4.getWeight());
		System.out.println("n5 is: " + n5.getWeight());
		System.out.println("n6 is: " + n6.getWeight());

		System.out.println("n1 info: " + n1.getInfo());
		System.out.println("n2 info: " + n2.getInfo());
		System.out.println("n3 info: " + n3.getInfo());
		System.out.println("n4 info: " + n4.getInfo());
		System.out.println("n5 info: " + n5.getInfo());
		System.out.println("n6 info: " + n6.getInfo());

		List<node_data> test = ga.shortestPath(n1.getKey(), n4.getKey());
		
		for(node_data nd: test)
		{
			System.out.println(nd.getWeight());
		}

		
		
		
		System.out.println("Graph is connected:" +  ga.isConnected());
	}
	public static void testFunc()
	{
		Functions_GUI fg = new Functions_GUI();
		fg.add(new Polynom("x^2"));
		Range rx = new Range(-10,10);
		fg.drawFunctions(460, 460, rx, rx, 0);
	}
	public static void testmult()
	{
		ComplexFunction cf1 = new ComplexFunction("x + 1");
		ComplexFunction cf2 = new ComplexFunction("x + 1");
		ComplexFunction cf3 = new ComplexFunction("x + 1");

		cf1.mul(cf2);

		System.out.println("Expected 4: " + cf1.f(1));
		cf1.mul(cf3);
		System.out.println("Expected 8: " + cf1.f(1));

	}
	public static void testdiv()
	{
		ComplexFunction cf1 = new ComplexFunction("x + 1");
		ComplexFunction cf2 = new ComplexFunction("x + 1");

		cf1.div(cf2);
		System.out.println("Expected: 1: " + cf1.f(1));
	}
	public static void testplus()
	{
		ComplexFunction cf1 = new ComplexFunction("x + 1");
		ComplexFunction cf2 = new ComplexFunction("x + 1");

		cf1.plus(cf2);
		System.out.println("Expected: 4: " + cf1.f(1));
	}
	public static void testcomp()
	{
		ComplexFunction cf1 = new ComplexFunction("x + 2");
		ComplexFunction cf2 = new ComplexFunction("x + 2");
		ComplexFunction cf3 = new ComplexFunction("x + 2");


		cf1.comp(cf2);
		System.out.println("Expected: 5: " + cf1.f(1));


	}
	
	
	
	
	
}
