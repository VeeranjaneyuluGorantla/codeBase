package javapro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DupNo {

	public static void main(String[] args) 
	{
		int[] intArr=new int[] {1,3,5,6,8,9,5,2,1,3,1,5,3,6,5,4,2};
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<intArr.length;i++)
		{
			int temp=intArr[i];
			int count=0;
			for(int j=0;j<intArr.length;j++)
			{
				if(temp==intArr[j])
				{
					count++;
				}
			}
			map.put(temp,count);
		}
		Set<Integer> duplicate=new HashSet<Integer>();
		Set<Integer> noDuplicate=new HashSet<Integer>();
		for(int i=0;i<intArr.length;i++) 
		{
			if(map.containsKey(intArr[i]))
			{
			System.out.println("Key :"+intArr[i]+"value : "+map.get(intArr[i]));
			if(map.get(intArr[i])>1)
			{
				duplicate.add(intArr[i]);
			}
			else
			{
				noDuplicate.add(intArr[i]);
			}
			
			
			}
		}
		System.out.println("Duplicate Chars :"+Arrays.toString(duplicate.toArray()));
		System.out.println("noDuplicate Chars :"+Arrays.toString(noDuplicate.toArray()));

	}

}
