import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Client {
	
	private static Client client=null;
	Logger logger = Logger.getLogger("Log");  
	
	private Client() {
		
	    FileHandler fh=null;  
	    try {
			fh = new FileHandler("C:/Piyusha/LogFile.log");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  

		
	}
	
	synchronized public static Client getInstance()
	{
		if(client==null)
			return client=new Client();
		else
			return client;
	}
	
	public void loggingInfo(String msg)
	{
		logger.info(msg);
	}
}
