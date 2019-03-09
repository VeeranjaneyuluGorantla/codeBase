package javapro;

public class Exception1 {

	public static void main(String[] args)
	{
		int x=10;
		int y=0;
		try
		{
			int z=x/y;
			System.out.println(z);
		}
		catch(Exception ex)
		{
			ex.getMessage();
			System.out.println(ex);
		}

	}

}
