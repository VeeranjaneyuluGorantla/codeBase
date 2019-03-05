package testing;

import java.util.ArrayList;
import java.util.Scanner;

public class Dynamic_Arry_Short {

	public static void main(String[] args) {
		ArrayList<Integer> x=new ArrayList<Integer>();
		// fill Data
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Array size");
		int n=sc.nextInt();
		System.out.println("fill data");
		for(int i=0;i<n;i++)
		{
			x.add(sc.nextInt());
		}
		//sorting
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x.get(j)>x.get(j+1))
				{
					int temp=x.get(j);
					x.set(j,x.get(j+1));
					x.set((j+1), temp);
				}
			}
		}
		// Acces data
		System.out.println("Accendin data");
		for(int i=0;i<n;i++)
		{
			System.out.println(x.get(i));
		}
	}

}
