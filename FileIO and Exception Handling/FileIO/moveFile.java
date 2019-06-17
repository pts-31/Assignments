import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class moveFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path temp = Files.move 
		        (Paths.get("C:\\Piyusha\\read.txt"),  
		        Paths.get("C:\\Sharayu\\read.txt")); 
		  
		        if(temp != null) 
		        { 
		            System.out.println("File moved successfully"); 
		        } 
		        else
		        { 
		            System.out.println("Failed to move the file"); 
		        } 
	}

}
