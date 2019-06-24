import java.util.Scanner;

/*
 * Main class taking the details of the passenger
 */

public class Booking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your name, age and email address");
		String name,mail;
		Integer age;
		
		name=sc.next();
		age=sc.nextInt();
		mail=sc.next();
		
		Passenger passenger=new Passenger(name, age, mail);
		boolean status=passenger.bookTicket();
		if(status==true)
			System.out.println("Tickets confirmed");
		else
			System.out.println("Tickets not booked");
	}

}
