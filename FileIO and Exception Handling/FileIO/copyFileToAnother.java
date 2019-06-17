import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyFileToAnother {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        FileInputStream instream = null;
        FileOutputStream outstream = null;
 
    	try{
    	    File infile =new File("C:\\Piyusha\\read.txt");
    	    File outfile =new File("C:\\Piyusha\\write.txt");
 
    	    instream = new FileInputStream(infile);
    	    outstream = new FileOutputStream(outfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;

    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    instream.close();
    	    outstream.close();

    	    System.out.println("File copied successfully!!");
 
    	}catch(IOException ioe){
    		ioe.printStackTrace();
    	 }
	}

}
