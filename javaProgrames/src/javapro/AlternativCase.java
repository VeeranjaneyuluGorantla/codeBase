package javapro;

public class AlternativCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "VEEranjaNEYUlu";
		for (int i = 0; i < x.length(); i++) {
			char ch = x.charAt(i);// talking characters
			if (i % 2 == 0) {
				System.out.print(Character.toLowerCase(ch));
			}else {
				System.out.print(Character.toUpperCase(ch));
			}
		}
		
	}

}
