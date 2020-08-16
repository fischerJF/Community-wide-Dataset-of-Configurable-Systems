package vending;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class  DispenserInput {

	protected static  int a[];
	protected static int b[];
	
	private static List<String> left= new ArrayList<String>();
	private static List<String> right = new ArrayList<String>();
	
	
	public static void leitor() {

		File dir = new File("dispenserInput.txt");

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {
				System.out.println(listas.get(i));
				left.add(l.splitLine(listas.get(i)).get(0));
				right.add(l.splitLine(listas.get(i)).get(1));
		}
		a=new int[left.size()];
		b=new int[right.size()];
		
		for (int i = 0; i < left.size(); i++) {
		    	a[i]=Integer.parseInt(left.get(i));
		    	b[i]=Integer.parseInt(right.get(i));
		}
		
		}

}
