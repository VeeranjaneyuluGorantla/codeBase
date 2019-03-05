package testing;

import java.util.Scanner;

public class CharAt_Method1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a String");
		String a = sc.nextLine();
		for (int i =0; i<a.length(); i++) {
			char b = a.charAt(i);
			System.out.print(b);
		}
		String x = "chack de India";
		char y = x.charAt(9);
		System.out.println("\n"+y);

	}

}
