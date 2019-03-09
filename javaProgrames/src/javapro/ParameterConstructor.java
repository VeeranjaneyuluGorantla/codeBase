package javapro;

public class ParameterConstructor {
	int id;
	String name;
	int age;
	public ParameterConstructor(int i,String y)
	{
		id=i;
		name=y;
	}
	public ParameterConstructor(int i,String y,int z)
	{
		id=i;
		name=y;
		age=z;
	}
	public void display()
	{
		//System.out.println(id+" "+name+" ");
		System.out.println(id+" "+name+" "+age+" ");
	}
	

	public static void main(String[] args) {
		
		ParameterConstructor s1=new ParameterConstructor(1,"veeru");
		ParameterConstructor s2=new ParameterConstructor(2,"abc",23);
		s1.display();
		s2.display();
	}

}
