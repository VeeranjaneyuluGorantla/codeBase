package testing;

import java.util.Scanner;

public class SubString_Method {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String x=sc.nextLine();
		String y=x.substring(6);
		System.out.println(y);
		String z=x.substring(4,10);
		System.out.println(z);

	}

}
