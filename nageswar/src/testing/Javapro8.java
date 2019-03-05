package testing;

public class Javapro8 {

	public static void main(String[] args) 
	{
		Sample12 obj1=new Sample12();
		int r1=obj1.x=20;
		int r2=obj1.y=25;
		System.out.println(r1);
		System.out.println(r2);
		Sample13 obj2 = new Sample13();
		obj2.x=56;
		obj2.y=58;
	    obj2.display();
	}

}
