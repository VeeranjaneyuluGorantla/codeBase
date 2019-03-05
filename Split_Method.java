package testing;

import java.util.Scanner;

public class Split_Method {

	public static void main(String[] args) {
		//String x="my name is veeranjaneyulu";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a line of text");
		String x=sc.nextLine();
		String[] y=x.split(" ");
				
		for(int i=0;i<y.length;i++)
		{
			
		System.out.println(y[i]);
		}

	}

}
