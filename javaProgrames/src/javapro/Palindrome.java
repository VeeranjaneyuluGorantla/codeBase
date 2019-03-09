package javapro;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a name");
		String x=sc.nextLine();
		String z="";
		for(int i=x.length()-1;i>=0;i--)
		{
			char y=x.charAt(i);
			z=z+y;
		}
		System.out.println(z);
		if(x.equals(z))
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not palendrome");
		}

	}

}
