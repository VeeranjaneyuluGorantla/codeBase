package javapro;

public class SingletonClass 
{
	public int x;
	private  SingletonClass()
	{
		x=50;
		
	}

	public static SingletonClass create()
	{
		SingletonClass obj1=new SingletonClass();
		return(obj1);
	}
	public void display()
	{
		System.out.println("hi this is veeru");
		System.out.println(x);
	}

}
