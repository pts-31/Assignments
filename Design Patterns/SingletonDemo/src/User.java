
public class User {
	
	public static void main(String[] args) {
		
		Client client1=Client.getInstance();
		Client client2=Client.getInstance();

		client1.loggingInfo("This is client 1");
		client2.loggingInfo("This is client 2");

	}
}
