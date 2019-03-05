package testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Hash_Map_Methods {

	public static void main(String[] args) {
		HashMap<Integer,String> hmap=new HashMap<Integer,String>();
		hmap.put(5,"veeru");
		hmap.put(82,"prasad");
		hmap.put(45,"venky");
		hmap.put(58,"anil");
		hmap.put(785, "hari");
		//display content using Iterator
		Set s=hmap.entrySet();
		Iterator ir=s.iterator();
		while(ir.hasNext())
		{
			Map.Entry e=(Map.Entry)ir.next();
			System.out.print(e.getKey());
			System.out.println(" "+e.getValue());

		}
		//get value based on key
		String x=hmap.get(58);
		System.out.println("Value at 58 is: "+x);
       // remove one key 
       hmap.remove(5);
     //display content using Iterator
     
     		for(Map.Entry e1:hmap.entrySet())
     		{
     			System.out.print(e1.getKey());
     			System.out.println(" "+e1.getValue());

     		}
	}

}
