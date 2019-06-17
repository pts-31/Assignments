import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class logFile {
	public static void main(String[] args) {  

	    Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;  

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("C:/Piyusha/MyLogFile.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
	        logger.info("My first log");  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	        logger.info("Security Exception Handled");
	    } catch (IOException e) {  
	        e.printStackTrace();  
	        logger.info("IO Exception Handled");
	    }  

	}
}
