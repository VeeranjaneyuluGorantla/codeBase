package javapro;

import java.util.ArrayList;

public class CompareDuplicateArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("hi");
		al1.add("how r u");
		al1.add("Goodmorning");
		al1.add("bye");
		al1.add("goodnight");
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("hello");
		al2.add("where r u");
		al2.add("call me");
		al2.add("bye");
		al2.add("goodnight");

		// Storing the comparison output in ArrayList<String>
		ArrayList<String> al3 = new ArrayList<String>();
		for (String temp : al1) {
			al3.add(al2.contains(temp) ? "Yes" : "No");
		}
		System.out.println(al3);
		ArrayList<String> al4 = new ArrayList<String>();
		for (String temp : al1) {
			al4.add(al2.contains(temp) ? "1" : "0");
		}
		System.out.println(al4);

	}

}
