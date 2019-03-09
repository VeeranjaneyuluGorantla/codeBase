package javapro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DupsMap {
	public void findDups(String str)
	{
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		char[] chr=str.toCharArray();
		for(Character c:chr)
		{
			if(map.containsKey(c))
			{
				map.put(c,map.get(c)+1);
			}
			else
			{
				map.put(c,1);
			}
		}
	
	Set<Character> keys=map.keySet();
	for(Character c:keys)
	{
		if(map.get(c)>1)
		{
			System.out.println(c+"  "+map.get(c));
			
		}

	}
	
}
	public static void main(String[] args) {
		DupsMap dp=new DupsMap();
		dp.findDups("veeranjaneyulu");

	}

}
