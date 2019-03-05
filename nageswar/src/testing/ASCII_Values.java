package testing;

import java.util.Scanner;

public class ASCII_Values {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a line of text");
		String x=sc.nextLine();
		int nod=0;
		int nol=0;
		int nou=0;
		int nosc=0;
		for(int i=0;i<x.length();i++)
		{
			char y=x.charAt(i);
			if(y>=48 && y<=57)
			{
				nod=nod+1;
			}
			else if(y>=97 && y<=122)
			{
				nol=nol+1;
			}
			else if(y>=65 && y<=90)
			{
				nou=nou+1;
			}
			else
			{
				nosc=nosc+1;
			}
		}
		System.out.println("no:of digits: "+nod);
		System.out.println("no:of lower case alphabet: "+nol);
		System.out.println("no:of upper case alphabet: "+nou);
		System.out.println("no:of special characters: "+nosc);

	}
}
