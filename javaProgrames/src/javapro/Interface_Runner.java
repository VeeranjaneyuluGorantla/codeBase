package javapro;

public class Interface_Runner {

	public static void main(String[] args) {
		// create obj to interface with helf of concreate
		Interface1 obj1=new Interface2();
		int r1=obj1.add(10, 20);
		System.out.println(r1);
		int r2=obj1.sub(25, 10);
		System.out.println(r2);
		int r3=obj1.mul(25,12);
		System.out.println(r3);
		int r4=obj1.div(14, 5);
		System.out.println(r4);
		// create obj to concrete class
		Interface2 obj2=new Interface2();
		int res1=obj1.add(110,20);
		System.out.println(r1);
		int res2=obj1.sub(255, 10);
		System.out.println(r2);
		int res3=obj1.mul(25,125);
		System.out.println(r3);
		int res4=obj1.div(14, 65);
		System.out.println(r4);
		

	}

}
