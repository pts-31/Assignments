import java.util.Map;
import java.util.Scanner;

public class User {
	static String userName, countryCode;
	static long phoneNumber;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your name");
		userName=sc.nextLine();
		System.out.println("Enter your Country Code");
		countryCode=sc.nextLine();
		System.out.println("Enter your Phone Number");
		phoneNumber=sc.nextLong();
		
		cellPhone cell=new cellPhone();
		
		while(true)
		{
			System.out.println("Choose your action:\n1.Call Someone\n2.Receive Call\n3.Save a number\n4.Get my history\n5.Redial\n6.Search a number\n7.Show my contacts");
			int choice=sc.nextInt();
			if(choice==1)
			{
				cell.makeCall();
			}
			else if(choice==2)
			{
				long number=9969778616L;
				cell.receiveCall(number);
			}
			else if(choice==3)
			{
				cell.addContact();
			}
			else if(choice==4)
			{
				cell.getCallHistory();
			}
			else if(choice==5)
			{
				cell.redial();
			}
			else if(choice==6)
			{
				System.out.println("Enter the name of the person want to search for:");
				String person=sc.next();
				long phoneNumber=cell.searchContact(person);
				System.out.println("This is "+person+"'s number "+phoneNumber);
			}
			else if(choice==7)
			{
				if(cell.contactList.size()==0)
				{
					System.out.println("No contacts saved yet!");
				}
				else
				{
					System.out.println("This is your contact list");
					 for (Map.Entry<Long,String> entry : cell.contactList.entrySet())  
				            System.out.println(entry.getValue() + 
				                             "	" + entry.getKey()); 
				}
			}
			else
			{
				System.out.println("Enter valid number!");
			}
		}
	}

}
