package Ex1;


import java.awt.Color;
import java.awt.Paint;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.colorchooser.ColorSelectionModel;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import de.*;


public class LinePlotter extends JFrame{

	/**
	 * 
	 * @param width - window width
	 * @param height - window height
	 * @param rx - Range for x axis
	 * @param ry Range for y Axis
	 * @param resolution - currently unavailable as it automatically rescales(can be anything)
	 * @param functions - the linked list of functions to draw into the map
	 */
	public LinePlotter(int width, int height, Range rx, Range ry, int resolution, LinkedList<function> functions) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		//DataTable data = new DataTable(Double.class, Double.class);

		double min = rx.get_min();
		double max = rx.get_max();
		double ymax = ry.get_max();
		double ymin = ry.get_min();

		//		for(function func: functions)
		//		{
		//
		//			for(double x = min; x <= max ; x+=0.01)
		//			{
		//				double y = func.f(x);
		//				if(y >= ymin && y <= ymax)
		//				{
		//					data.add(x, y);
		//				}
		//				else continue;
		//			}
		//
		//
		//		}
		//		XYPlot plot = new XYPlot(data);
		//		getContentPane().add(new InteractivePanel(plot));
		//		LineRenderer lines = new DefaultLineRenderer2D();
		//		plot.setLineRenderers(data, lines);
		//		Color color = new Color(0.0f, 0.3f, 1.0f);
		//		plot.getPointRenderers(data).get(0).setColor(color);
		//		plot.getLineRenderers(data).get(0).setColor(color);

		// Color[] colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};
		Color[] colors = {Color.BLACK};

		int i = 0;
		DataTable data = new DataTable(Double.class, Double.class);

		for(function func: functions)
		{
			for(double x = min; x <= max; x+=0.01)
			{
				double y = func.f(x);
				if(y >= ymin && y <=ymax)
				{
					data.add(x, y);
				}
				else continue;

			}

			XYPlot plot = new XYPlot(data);
			getContentPane().add(new InteractivePanel(plot));
			LineRenderer lines = new DefaultLineRenderer2D();
//			Color color = new Color(colors[i].getBlue(), colors[i].getRed(), colors[i].getGreen());
//			plot.setLineRenderers(data, lines);
//			plot.getPointRenderers(data).get(0).setColor(color);
//			plot.getLineRenderers(data).get(0).setColor(color);
			i++;
			if(i >= colors.length)
			{
				i = 0;
			}

		}
	}


}
