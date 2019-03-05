package testing;

public class Sample3 {
	//members
	public int x;
	public float y;
	public char z;
	public String s;
	public boolean b;
	//methosd
	public Sample3() {
		y=(float) 20.3;
		s="veeru";
	}
	public Sample3(int a) {
		x=a;
		s="veeru";
	}
	public Sample3(float f) {
		y=f;
		s="veeru";
	}
	public Sample3(int a,String c) {
		x=a;
		s=c;
	}
	public void display() {
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(s);
		System.out.println(b);
	}

}
