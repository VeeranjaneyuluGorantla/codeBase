package testing;

public class Sample9 
{
   public int x;
   private Sample9()
   {
	   x=20;
   }
   public static Sample9 crete()
   {
	   Sample9 obj1 = new Sample9();
	   return(obj1);
   }
   public void display(){
	   {
		   System.out.println(x);
	   }
   }

}
