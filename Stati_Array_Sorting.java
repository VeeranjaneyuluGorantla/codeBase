package testing;

import java.util.Scanner;

public class Stati_Array_Sorting 
{
	public static void main(String[] args) {
		//declare static array
		int[] x= new int[5];
		//fill array with data
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Array values");
		for(int i=0;i<5;i++)
		{
			x[i]=sc.nextInt();
			
		}
		//sorting
        for(int i=0;i<5;i++)
        {
        	for(int j=0;j<4;j++)
        	{
        		if(x[j]>x[j+1])
        		{
        			int temp=x[j];
        			x[j]=x[j+1];
        			x[j+1]=temp;
        		}
        	}
        }
        //Access data in array
        System.out.println("Sortin of Array");
        for(int i=0;i<5;i++)
        {
        	
        	System.out.println(x[i]);
        }
	}

}
