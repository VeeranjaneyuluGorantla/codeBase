package javapro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExp {

	public static void main(String[] args) {
		String x= "abc edrj458 kiv869 487 vheuns";
		Pattern p=Pattern.compile("[0-9]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}

	}

}
