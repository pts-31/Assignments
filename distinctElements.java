import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class distinctElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfElements;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter number of elements");
		noOfElements=sc.nextInt();
		String[] input=new String[noOfElements];
		
		Map<String,Integer> map=new HashMap<>(); 
		System.out.println("Enter the elements");
		for(int i=0;i<noOfElements;i++)
		{
			input[i]=sc.next();
			String value=input[i];
			int freq;
			if(map.containsKey(value))
			{
				freq=map.get(value);
				map.put(value, freq+1);
			}
			else
				map.put(value, 1);
			
		}
		
		List<Map.Entry<String,Integer>> list=new LinkedList<Map.Entry<String, Integer> >(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String , Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
			{
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		List<String> ans=new ArrayList<String>();
		
		for(Map.Entry<String, Integer> tmp: list)
		{
			ans.add(tmp.getKey());
		}
		
		Collections.reverse(ans);
		System.out.println(ans);
	
	}

}
