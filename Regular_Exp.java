package testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_Exp {

	public static void main(String[] args) {
		String x="fbcbsf5585xscb78 d5 gc 8883";
		Pattern p=Pattern.compile("[0-9]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}

	}

}
