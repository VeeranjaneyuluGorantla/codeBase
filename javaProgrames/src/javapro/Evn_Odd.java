package javapro;

import java.util.Scanner;

public class Evn_Odd {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int x=sc.nextInt();
		if(x%2==0)
		{
			System.out.println(x+ " is even number");
		}
		else
		{
			System.out.println(x+" is odd numbrer");
		}

	}

}
