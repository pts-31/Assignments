import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//inputs
		int noOfUsers,floorNumber;
		System.out.println("Enter the floor number");
		Scanner sc =new Scanner(System.in);
		floorNumber=sc.nextInt();
		System.out.println("Enter the number of users");
		noOfUsers=sc.nextInt();
		
		int[] destinations=new int[noOfUsers];
		
		System.out.println("Enter the user destinations");
		for(int i=0;i<noOfUsers;i++)
			destinations[i]=sc.nextInt();
		
		int[] difference=new int[noOfUsers];
		
		//Two lists with positive and negative differences from the floor
		List<Integer> A= new ArrayList<Integer>();
		List<Integer> B= new ArrayList<Integer>();
		
		for(int i=0;i<noOfUsers;i++)
		{
			difference[i]=destinations[i]-floorNumber;
			if(difference[i]>0)
				A.add(i+1);
			else
				B.add(i+1);
		}
		
		int remove,ct,value;
		
		if(A.size()>B.size())
		{
			ct=1;
			remove=(A.size()-B.size())/2;//remove the users from bigger list and add those to smaller one
			while(remove>0)
			{
				for(int i=0;i<noOfUsers;i++)
				{
					if(difference[i]==ct)
					{
						A.remove(new Integer(i+1));
						remove--;
						B.add(i+1);
						
						if(remove==0)
							break;
						
					}
				}
				ct++;
			}
		}
		else
		{
			ct=-1;
			remove=(B.size()-A.size())/2;//remove the users from bigger list and add those to smaller one
			while(remove>0)
			{
				for(int i=0;i<noOfUsers;i++)
				{
					if(difference[i]==ct)
					{
						B.remove(new Integer(i+1));
						remove--;
						A.add(i+1);
						
						if(remove==0)
							break;
					}
				}
				ct--;
			}
		}
		
		//maps to store the users and their destinations in two lifts
		Map<Integer,Integer> aMap=new HashMap<Integer, Integer>();
		Map<Integer,Integer> bMap=new HashMap<Integer, Integer>();
		
		for(int i=0;i<A.size();i++)
		{
			aMap.put(A.get(i), destinations[A.get(i)-1]);
			bMap.put(B.get(i), destinations[B.get(i)-1]);
		}
		
		//Order of exit from lift A
		// Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list1 = 
               new LinkedList<Map.Entry<Integer, Integer> >(aMap.entrySet()); 
  
        // Sort the list 
        Collections.sort(list1, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> LiftA = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list1) { 
            LiftA.put(aa.getKey(), aa.getValue()); 
        } 
		

		//Order of exit from lift A
        List<Map.Entry<Integer, Integer> > list2 = 
                new LinkedList<Map.Entry<Integer, Integer> >(bMap.entrySet()); 
   
         // Sort the list 
         Collections.sort(list2, new Comparator<Map.Entry<Integer, Integer> >() { 
             public int compare(Map.Entry<Integer, Integer> o1,  
                                Map.Entry<Integer, Integer> o2) 
             { 
                 return (o1.getValue()).compareTo(o2.getValue()); 
             } 
         }); 
           
         // put data from sorted list to hashmap  
         HashMap<Integer, Integer> LiftB = new LinkedHashMap<Integer, Integer>(); 
         for (Map.Entry<Integer, Integer> aa : list2) { 
             LiftB.put(aa.getKey(), aa.getValue()); 
         } 
 	      
         A.removeAll(A);
         B.removeAll(B);
         
         for (Map.Entry<Integer,Integer> entry : LiftA.entrySet())  
             A.add(entry.getKey());
         
         for (Map.Entry<Integer,Integer> entry : LiftB.entrySet())  
             B.add(entry.getKey());
                 
         //lifts A and B
		System.out.println(A);
		System.out.println(B);
		
	}
}
		