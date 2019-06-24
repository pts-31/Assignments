import java.util.Date;

public abstract class Mode {
	
	//Abstract class having abstract methods for different modes of transport
	
	public abstract void getJourneyDetails(String source, String destination);
	public abstract void getPassengerDetails(Integer number);
	public abstract int getJourneyType(String type);
	public abstract void getJourneyDate(Date date);
	public abstract boolean checkAvailability(Integer seats,Integer numberOfPassengers);
	public abstract void paymentMode(String mode);
	
}
