package testing;

public class EqualsIgnoreCase {

	public static void main(String[] args) {
		String x="Veeranjaneyulu GORANTLA";
		String y="veeranjaneyulu gorantla";
		if(x.equalsIgnoreCase(y))
		{
			System.out.println("same");
		}
		else {
			System.out.println("not same");
		}

	}

}
