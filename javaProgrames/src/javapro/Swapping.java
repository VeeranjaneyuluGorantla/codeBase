package javapro;

import java.util.Scanner;

public class Swapping {

	public static void main(String[] args) 
	{
		int[] x=new int[5];
		Scanner sc=new Scanner(System.in);
		System.out.println("fill array");
		for(int i=0;i<5;i++)
		{
			x[i]=sc.nextInt();
			
		}
		//sorting
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j]<x[j+1])
				{
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
					
				}
			}
		}
		// Access data in array
		for(int i=0;i<5;i++)
		{
			System.out.println(x[i]);
		}
		// second hight number
		System.out.println(x[1]);

	}

}
