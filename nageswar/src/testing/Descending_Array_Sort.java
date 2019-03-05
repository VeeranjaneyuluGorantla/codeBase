package testing;

import java.util.Scanner;

public class Descending_Array_Sort {

	public static void main(String[] args) {
		//declare static array
		int[] x=new int[6];
		// fill array with data
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array data");
		for(int i=0;i<6;i++)
		{
			x[i]=sc.nextInt();
		}
		//descending order
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(x[j]<x[j+1])
				{
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		// access data in array
		System.out.println("Descending order");
		for(int i=0;i<6;i++)
		{
			System.out.println(x[i]);
		}
	}

}
