package javapro;

import java.util.Scanner;

public class UncheckedException1 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a value");
		int x=sc.nextInt();
		if(x<18)
		{
			ArithmeticException obj1=new ArithmeticException("invalid to vote");
			throw(obj1);
		}
		else
		{
			System.out.println("valid to vote");
		}

	}

}
