package testing;

import java.util.Scanner;

public class Javapro9_Evn_or_Odd {

	public static void main(String[] args) {
		//get data from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int x=sc.nextInt();
		//check for even or odd
		if(x%2==0)
		{
			System.out.println(x+"is even no");
		}else {
			System.out.println(x+"is odd no");
		}
	}

}
