import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class frequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		s=sc.nextLine();
		System.out.println(s);
		String uppercase=s.toUpperCase();
		Map<Character,Integer> m=new TreeMap<>();
		for(int i=0;i<s.length();i++)
		{
			if(uppercase.charAt(i)>=65 && uppercase.charAt(i)<=90)
			{
				if(m.containsKey(uppercase.charAt(i)))
				{
					int value=m.get(uppercase.charAt(i));
					m.put(uppercase.charAt(i), value+1);
				}
				else
					m.put(uppercase.charAt(i), 1);
			}
			else
				continue;
			
		}
		
		Set set = m.entrySet();
		Iterator itr = set.iterator();
		
		while(itr.hasNext())
		{
			Map.Entry me = (Map.Entry)itr.next();
			
			int count = (int) me.getValue();
			
			System.out.print(me.getKey()+"\t");
			for(int i=0;i<count;i++)
				System.out.print("#");
			System.out.println();
		}
	}

}
