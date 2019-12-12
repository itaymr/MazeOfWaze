package Ex1Testing;

import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.Polynom;
import Ex1.Range;

public class Test {

	
	public static void main(String[] args)
	{
		testFunc();
		testmult();
		testdiv();
		testplus();
		testcomp();
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
