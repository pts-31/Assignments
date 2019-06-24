import java.util.Date;

public class BusTemplate extends Mode{

	//Implementation of the methods accordingly when mode of transport is chosen as bus
	
	@Override
	public void getJourneyDetails(String source, String destination) {
		// TODO Auto-generated method stub
		System.out.println("The journey of the passenger is from "+source+" to "+destination);
	}

	@Override
	public void getPassengerDetails(Integer number) {
		// TODO Auto-generated method stub
		System.out.println("There are "+number+" passengers travelling together in a bus");
	}

	@Override
	public int getJourneyType(String type) {
		// TODO Auto-generated method stub
		if(type=="single")
			return 1;
		else
			return 2;
	}

	@Override
	public void getJourneyDate(Date date) {
		// TODO Auto-generated method stub
		System.out.println("The passenger in travelling in a bus on "+date);
	}

	@Override
	public boolean checkAvailability(Integer seats,Integer numberOfPassengers) {
		// TODO Auto-generated method stub
		if((seats-numberOfPassengers)>=0)
			return true;
		return false;
	}

	@Override
	public void paymentMode(String mode) {
		// TODO Auto-generated method stub
		if(mode=="card")
			System.out.println("Card payment done");
		else
			System.out.println("Cash payment done");
	}

}