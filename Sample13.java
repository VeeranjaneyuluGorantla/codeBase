package testing;

public class Sample13 extends Sample12
{
	public int x;
	public int y;
	public void display()
	{
		System.out.println(super.x);
		System.out.println(super.y);
		System.out.println(this.x);
		System.out.println(this.y);
	}

}
