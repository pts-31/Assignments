import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class cellPhone implements phone{
	ArrayList<Call> callHistory = new ArrayList<Call>();
	static HashMap<Long, String> contactList= new HashMap<Long, String>();
	
	@Override
	public void redial() {
		// TODO Auto-generated method stub
		Call call=getRecentCall();
		String name=call.name;
		System.out.println("Calling "+name+" ......");
		callHistory.add(call);
	}
	
	@Override
	public void makeCall() {
		// TODO Auto-generated method stub
		System.out.println("Choose what to do:\n1.Redial\n2.Enter number\n3.Search Name");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		if(option==1)
		{
			Call call=getRecentCall();
			System.out.println("Calling "+call.name+" ......");
			java.util.Date t1=new java.util.Date(); 
			System.out.println("Enter 0 to end call");
			while(true)
			{
				if(sc.nextInt()==0)
					break;
			}
			java.util.Date t2=new java.util.Date(); 
			String duration=call.getDuration(t1, t2);
			call.duration=duration;
			callHistory.add(call);
		}
		
		else if(option==2)
		{
			System.out.println("Enter number");
			long phoneNumber=sc.nextLong();
			System.out.println("Calling "+phoneNumber+" ......");
			
			java.util.Date t1=new java.util.Date(); 
			System.out.println("Enter 0 to end call");
			while(true)
			{
				if(sc.nextInt()==0)
					break;
			}
			java.util.Date t2=new java.util.Date(); 
			short type=0;
			Call call = new Call("Unknown Contact", phoneNumber, t1, t2, type);
			String duration=call.getDuration(t1, t2);
			call.duration=duration;
			
			System.out.println("Save number?\n1.Yes\n2.No");
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Enter name of the person");
				String name=sc.next();
				contactList.put(phoneNumber,name);
				call.name=name;
			}
			callHistory.add(call);
		}
		
		else if(option==3)
		{
			System.out.println("Enter name of the person:");
			String name=sc.next();
			if(contactList.containsValue(name))
			{
				System.out.println("Calling "+name+" ......");
				long phoneNumber=0;
				for (Entry<Long ,String> entry : contactList.entrySet()) {
			        if (entry.getValue().equals(name)) {
			            phoneNumber=entry.getKey();
			        }
			    }

				java.util.Date t1=new java.util.Date(); 
				System.out.println("Enter 0 to end call");
				while(true)
				{
					if(sc.nextInt()==0)
						break;
				}
				java.util.Date t2=new java.util.Date(); 
				short type=0;
				Call call = new Call(name, phoneNumber, t1, t2, type);
				String duration=call.getDuration(t1, t2);
				call.duration=duration;
				callHistory.add(call);
			}
		}
	}
	
	@Override
	public void receiveCall(long phno) {
		// TODO Auto-generated method stub
		java.util.Date t1=new java.util.Date(); 
		System.out.println("Enter 0 to end call");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			if(sc.nextInt()==0)
				break;
		}
		java.util.Date t2=new java.util.Date(); 
		short type=1;
		String name;
		if(contactList.containsKey(phno))
		{
			name=contactList.get(phno);
		}
		else
		{
			System.out.println("Save Number?\n1.Yes\n2.No");
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Enter name of the person");
				name=sc.next();
				contactList.put(phno,name);
			}
			else
				name="Unknown Contact";
		}
		Call call = new Call(name, phno, t1, t2, type);
		String duration=call.getDuration(t1, t2);
		call.duration=duration;
		callHistory.add(call);
	}
	
	@Override
	public void getCallHistory() {
		// TODO Auto-generated method stub
		if(callHistory.size()==0)//No history yet
			System.out.println("No calls yet!");
		System.out.println("This is your call history:");
		for(int i=0;i<callHistory.size();i++)
		{
			Call call=callHistory.get(i);
			short type=call.type;
			String callType;
			if(type==0)
				callType="Outgoing";
			else
				callType="Incoming";
			
			System.out.println(callType+"    "+call.name+ "    "+call.duration);
		}
	}
	
	@Override
	public Call getRecentCall() {
		// TODO Auto-generated method stub
		if(callHistory.size()==0)
		{
			System.out.println("No calls yet!");
			return null;
		}
		
		Call call=callHistory.get(callHistory.size()-1);
		return call;
	}

	@Override
	public long searchContact(String srch) {
		// TODO Auto-generated method stub
		long phoneNumber=0;
		for (Entry<Long ,String> entry : contactList.entrySet()) {
	        if (entry.getValue().equals(srch)) {
	            phoneNumber=entry.getKey();
	        }
	    }
		if(phoneNumber==0)
		{
			System.out.println("No such contact in your contacts!");
			System.out.println("Save Number");
			System.out.println("Enter number of the person");
			Scanner sc=new Scanner(System.in);
			long number=sc.nextLong();
			contactList.put(number,srch);
		}
		return phoneNumber;
	}
	
	@Override
	public void addContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter name of the person");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		System.out.println("Enter number of the person");
		long phoneNumber=sc.nextLong();
		cellPhone.addToTheList(phoneNumber, name);
	}

	public static void addToTheList(long phoneNumber, String name) {
		// TODO Auto-generated method stub
		contactList.put(phoneNumber,name);
	}
	
}