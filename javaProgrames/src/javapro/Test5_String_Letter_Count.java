package javapro;

import java.util.Scanner;

public class Test5_String_Letter_Count {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = null;
		System.out.println("Enter a string name");
		str = s.nextLine();
		int[] count = new int[255];
		int length = str.length();
		
		for (int i = 0; i < length; i++) {
			count[str.charAt(i)]++;

		}
		//read the string
		System.out.println(length);
		
		int[] ch = new int[str.length()];
		System.out.println(ch.length);
		
		for (int i = 0; i < length; i++) {
			ch[i] = str.charAt(i);
			int find = 0;
			for (int j = 0; j <= i; j++) {
				if (str.charAt(i) == ch[j])
					find++;
			}
			if (find == 1) {
				System.out.println("Number of Occurrence of " + str.charAt(i) + " letter is:" + count[str.charAt(i)]);
			}
		}
	}

}
