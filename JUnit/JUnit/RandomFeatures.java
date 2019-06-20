import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RandomFeatures {
	
	Map<Long, String> contacts = new HashMap<Long, String>();
	
	public int findMax(int[] arr) {
		int max=arr[0];
		for(int i=0;i<arr.length;i++)
			if(arr[i]>max)
				max=arr[i];
		return max;
	}
	
	public void addContact(long phoneNumber,String name) {
		contacts.put(phoneNumber,name);
	}
	
	public long searchContact(String name) {
		long phoneNumber=0; 
		for (Entry<Long, String> entry : contacts.entrySet()) {
	            if (entry.getValue().equals(name)) {
	                phoneNumber=entry.getKey();
	            }
	        }
		return phoneNumber;
	}
	
	public int getFrequency(ArrayList<String> arr,String element)
	{
		int freuency=0;
		Iterator i = arr.iterator();
		while(i.hasNext())
		{
			if(i.next()==element)
				freuency++;
		}
		return freuency;
	}
}
