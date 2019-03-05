package testing;

import java.util.HashMap;
import java.util.Map;

public class Hash_Map {

	public static void main(String[] args) {
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		hm.put(101, "veeru");
		hm.put(102, "gorantla");
		for(Map.Entry e:hm.entrySet())
		{
			System.out.print("key is: "+e.getKey()+ " & Value is: ");
			System.out.println(" "+e.getValue());
		}

	}

}
