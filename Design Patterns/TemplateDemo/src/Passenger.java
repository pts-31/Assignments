import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Passenger {

	String name,mail;
	Integer age;
	
	String modeOfTransport;
	
	Scanner sc=new Scanner(System.in);
	Mode mode=null;
	
	public Passenger(String name,Integer age,String mail) {
		this.age=age;
		this.mail=mail;
		this.name=name;
	}
	
	String source,destination,type,paymentMode;
	Integer numberOfPassengers;
	Date date;
	int seats=30;
	
	//Method for ticket booking of the passenger
	
	public boolean bookTicket() {
		System.out.println("Enter the mode of transport");
		modeOfTransport=sc.next();
		
		if(modeOfTransport=="Bus")
			mode=new BusTemplate();
		else if(modeOfTransport=="Train")
			mode=new TrainTemplate();
		else
			mode=new FlightTemplate();
		
		System.out.println("Enter the journey details:From ... To ...");
		source=sc.next();
		destination=sc.next();
		mode.getJourneyDetails(source, destination);
		System.out.println("Enter the number of passengers");
		numberOfPassengers=sc.nextInt();
		mode.getPassengerDetails(numberOfPassengers);
		System.out.println("Enter the date of journey");
		String input=sc.next();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mode.getJourneyDate(date);
		System.out.println("Enter the journey type:single or return");
		type=sc.next();
		mode.getJourneyType(type);
		
		if(mode.checkAvailability(seats, numberOfPassengers))
		{
			System.out.println("Enter payment mode");
			paymentMode=sc.next();
			mode.paymentMode(paymentMode);
			return true;
		}
		return false;
	}
	
}
