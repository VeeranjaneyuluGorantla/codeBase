package testing;

public class Javapro3 {

	public static void main(String[] args) {
		// create constructors
		Sample3 obj1 = new Sample3();
		obj1.display();
		Sample3 obj2 = new Sample3(120);
		obj2.display();
		Sample3 obj3 = new Sample3((float)12.0);
        obj3.display();
        Sample3 obj4 = new Sample3(254,"anil");
        obj4.display();
	}

}
