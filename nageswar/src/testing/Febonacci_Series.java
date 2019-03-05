package testing;

import java.util.Scanner;

public class Febonacci_Series {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter limit");
		int l = sc.nextInt();
		int x=0;
		int y=1;
		System.out.print(x+" "+y+" ");
		do
		{
			int z=x+y;
			System.out.print(z+" ");
			x=y;
			y=z;
		}while((x+y)<l);

	}

}
