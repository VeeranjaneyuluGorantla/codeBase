package testing;

import java.util.Scanner;

public class CharAt_Reverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a String");
		String x = sc.nextLine();
		for(int i=x.length()-1;i>=0;i--)
		{
			char y=x.charAt(i);
			System.out.print(y);
		}

	}

}
