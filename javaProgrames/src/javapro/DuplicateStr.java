package javapro;

import java.util.Scanner;

public class DuplicateStr {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.nextLine();
		char[] dup=str.toCharArray();
		int cnt=0;
		System.out.println("Duplicate characters are:");
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(dup[i]==dup[j])
				{
					System.out.print(dup[j]);
					cnt++;
					break;
				}
			}
		}

	}

}
