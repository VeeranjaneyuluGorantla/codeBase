package testing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Charcount_Map {

	static void charCount(String y) {
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		char[] strArray = y.toCharArray();
		for (char c : strArray) {
			if (m.containsKey(c)) {
				m.put(c, m.get(c) + 1);
			} else {
				m.put(c, 1);
			}
		}
		for (Map.Entry entry : m.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
	}
	public static void main(String[] args) {
		// Charcount_Map cm=new Charcount_Map();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a name");
		String x = sc.nextLine();
		charCount(x);
	}
}
