import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Exceptions {
	
	public static void main(String args[]) 
    {
		int a = 30, b = 0; 
	    int arr[] = new int[5]; 
        File file = new File("C://file.txt"); 
        
		Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        
		try { 
            int c = a/b;  // cannot divide by zero 
            System.out.println ("Result = " + c); 
        }
        catch(ArithmeticException e) { 
            System.out.println ("Can't divide a number by 0"); 
            logger.log(Level.INFO, "Üncaught Exception", e);         
       } 
        
        try {
            arr[6] = 9;
        }
        catch(ArrayIndexOutOfBoundsException e){ 
                System.out.println ("Array Index is Out Of Bounds"); 
                logger.log(Level.INFO, "Üncaught Exception", e);
        }
        
        try {
            FileReader fr = new FileReader(file); 
        }
        catch (FileNotFoundException e) { 
            System.out.println("File does not exist"); 
            logger.log(Level.INFO, "Üncaught Exception", e);
            
        }
        
    } 
}
