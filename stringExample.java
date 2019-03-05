package testing;

public class stringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "veera";
		// charAt it has character return type
		System.out.println(s1.charAt(3));
		System.out.println(s1.charAt(0));
		System.out.println("----");

		// contains has been boolen return type
		System.out.println(s1.contains("e"));
		System.out.println(s1.contains("ra"));
		System.out.println(s1.contains("vee"));
		System.out.println(s1.contains("go"));
		System.out.println("----------");

		System.out.println(s1.concat("njaneyulu"));
		System.out.println(s1.concat(" gorantla"));
		System.out.println("-----------");

		String s2 = "veera anjaneyulu gorantla";
		String[] split = s2.split("");
		System.out.println(split[0]);
		System.out.println(split[5]);
		System.out.println(split[6]);
		System.out.println(split[8]);
		System.out.println("-----");

		String s3 = "veera anjaneyulu gorantla";
		String[] split1 = s3.split("anjaneyulu");
		System.out.println(split1[1]);
		System.out.println(split1[0]);
		// System.out.println(split1[2]);

	}

}
